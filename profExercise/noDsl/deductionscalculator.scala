package payroll.api

import payroll.Type2Money._
import payroll._


/**
 * gross is of type Money
 * .25 is of type double
 * 
 * How to make a multiplication by two different objects?
 * '.25' is been casted to Money by the implicit conversion done by the package "payroll.Type2Money._"
 */

object DeductionsCalculator {
    def federalIncomeTax(empl: Employee, gross: Money) = gross * .25
    def stateIncomeTax(empl: Employee, gross: Money) = gross * .05
    def insurancePremiums(empl: Employee, gross: Money) = Money(500)
    def retirementFundContributions(empl: Employee, gross: Money) = gross * .10
}