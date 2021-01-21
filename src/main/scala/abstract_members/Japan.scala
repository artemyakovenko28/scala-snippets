package com.company
package abstract_members

object Japan extends CurrencyZone {
  abstract class Yen extends AbstractCurrency {
    def designation = "JPY"
  }
  type Currency = Yen
  def make(yen: Long): Yen = new Yen {
    val amount: Long = yen
  }
  val Yen: Yen = make(1)
  val CurrencyUnit: Yen = Yen
}
