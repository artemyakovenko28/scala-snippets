import com.company.traits.{BasicIntQueue, Doubling, DoublingQueue, Filtering, Incrementing}

val queue = new BasicIntQueue
queue.put(10)
queue.put(20)
queue.get()
queue.get()

val doublingQueue = new DoublingQueue
doublingQueue.put(10)
doublingQueue.get()

val dQueue = new BasicIntQueue with Doubling
dQueue.put(20)
dQueue.get()

val ifQueue = new BasicIntQueue with Incrementing with Filtering
ifQueue.put(-1)
ifQueue.put(0)
ifQueue.put(1)
ifQueue.get()
ifQueue.get()

val fiQueue = new BasicIntQueue with Filtering with Incrementing
fiQueue.put(-1)
fiQueue.put(0)
fiQueue.put(1)
fiQueue.get()
fiQueue.get()
fiQueue.get()