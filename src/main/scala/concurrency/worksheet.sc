import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Future, Promise}
import scala.util.{Failure, Success}

val fut = Future {
  Thread.sleep(500)
  21 + 21
}

fut.isCompleted
fut.value

Thread.sleep(1000)
fut.isCompleted
fut.value

val failFut = Future {
  21 / 0
}

Thread.sleep(10)
failFut.value

// Transforming futures
// map
val future = Future { 21 + 21 }
  .map(_ + 1)

Thread.sleep(10)
future.value

// for expressions

// parallel
val fut1 = Future { 21 + 21 }
val fut2 = Future { 23 + 23 }
val result = for {
  x <- fut1
  y <- fut2
} yield x + y
Thread.sleep(10)
result.value

// consequentially
val result1 = for {
  x <- Future { 21 + 21 }
  y <- Future { 23 + 23 }
} yield x + y
Thread.sleep(10)
result1.value

// Creating futures
Future.successful(21 + 21)
Future.failed(new Exception("bummer!"))
Future.fromTry(Success(21 + 21))
Future.fromTry(Failure(new Exception("bummer!")))

val pro = Promise[Int]
val proFut = pro.future
proFut.value
pro.success(42)
proFut.value

// Filtering futures
// filter
val f = Future.successful(42)
val valid = f.filter(_ > 0)
Thread.sleep(10)
valid.value
val invalid = f.filter(_ < 0)
// for expressions (analog to filter)
val validFor = for (res <- f if res > 0) yield res
Thread.sleep(10)
validFor.value
val invalidFor = for (res <- f if res < 0) yield res
// collect
val validc = fut.collect {
  case res if res > 0 => res + 46
}
Thread.sleep(10)
validc.value
try {
  val invalidc = fut.collect {
    case res if res < 0 => res + 46
  }
  Thread.sleep(10)
  invalidc.value
} catch {
  case e: Throwable => e.printStackTrace()
}

// Dealing with failure
// failed
val failure = Future { 42 / 0 }
Thread.sleep(10)
failure.value
val expectedFailure = failure.failed
expectedFailure.value

val success = Future { 42 / 1 }
Thread.sleep(10)
val unexpectedSuccess = success.failed
unexpectedSuccess.value

// fallbackTo
val fallback = failure.fallbackTo(success)
fallback.value

val failedFallback = failure.fallbackTo(Future {
  val res = 42
  require(res < 0)
  res
})
Thread.sleep(10)
failedFallback.value

// recover
val recovered = failure.recover({
  case _: ArithmeticException => -1
})
Thread.sleep(10)
recovered.value

val unrecovered = fallback.recover({
  case _: ArithmeticException => -1
})
unrecovered.value

val alsoUnrecovered = failedFallback.recover({
  case _: IllegalArgumentException => -2
})
alsoUnrecovered.value

// recoverWith
val alsoRecovered = failedFallback.recoverWith({
  case _: ArithmeticException => Future { 42 + 46 }
})
Thread.sleep(10)
alsoRecovered.value

// Mapping success and error at once
// transform
val first = success.transform(
  res => res * -1,
  ex => new Exception("see cause", ex)
)
Thread.sleep(10)
first.value

val second = failure.transform(
  res => res * -1,
  ex => new Exception("see cause", ex)
)
Thread.sleep(10)
second.value

// transform from Try to Try
val firstCase = success.transform {
  case Success(res) => Success(res * -1)
  case Failure(ex) =>
    Failure(new Exception("see cause", ex))
}
Thread.sleep(10)
firstCase.value

val secondCase = failure.transform {
  case Success(res) => Success(res * -1)
  case Failure(ex) =>
    Failure(new Exception("see cause", ex))
}
Thread.sleep(10)
secondCase.value

val nonNegative = failure.transform {
  case Success(res) => Success(res.abs + 1)
  case Failure(_) => Success(0)
}
Thread.sleep(10)
nonNegative.value

// Combining futures
// zip
val zippedSuccess = success.zip(recovered)
zippedSuccess.value

val zippedFailure = success.zip(failure)
zippedFailure.value

// fold
val fortyTwo = Future { 21 + 21 }
val fortySix = Future { 23 + 23 }
val futureNums = List(fortyTwo, fortySix)
val folded =
  Future.foldLeft(futureNums)(0) { (acc, num) =>
    acc + num
  }
Thread.sleep(10)
folded.value

// reduce
val reduced =
  Future.reduceLeft(futureNums) { (acc, num) =>
    acc + num
  }
Thread.sleep(10)
reduced.value

// sequence
val futureList = Future.sequence(futureNums)
Thread.sleep(10)
futureList.value

// traverse
val traversed =
  Future.traverse(List(1, 2, 3)) { i => Future(i) }
Thread.sleep(10)
traversed.value

// Performing side effects
// foreach
//failure.foreach(ex => println(ex)) // not executed
//success.foreach(res => println(res))
//for (res <- failure) println(res)
//for (res <- success) println(res)

// onComplete
//success onComplete {
//  case Success(res) => println(res)
//  case Failure(ex) => println(ex)
//}

//failure onComplete {
//  case Success(res) => println(res)
//  case Failure(ex) => println(ex)
//}

// andThen
val newFuture = success andThen {
  case Success(res) => println(res)
  case Failure(ex) => println(ex)
}
Thread.sleep(10)
newFuture.value