package payroll

import java.math.BigDecimal

/**
 * Used for implicit conversions
 */ 
object Type2Money {
    implicit def bigDecimal2Money(b: BigDecimal) = Money(b)
    implicit def double2Money(d: Double) = Money(d)
    implicit def long2Money(l: Long) = Money(l)
    implicit def int2Money(i: Int) = Money(i)
}