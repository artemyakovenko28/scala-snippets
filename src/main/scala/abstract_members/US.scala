package com.company
package abstract_members

object US extends CurrencyZone {
  type Currency = Dollar

  def make(cents: Long): Currency = new Dollar {
    val amount: Long = cents
  }

  val Cent: Dollar = make(1)
  val Dollar: Dollar = make(100)
  val CurrencyUnit: Dollar = Dollar

  abstract class Dollar extends AbstractCurrency {
    def designation: String = "USD"
  }

}
