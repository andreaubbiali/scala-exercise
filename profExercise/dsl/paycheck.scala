package payroll

case class Paycheck(gross: Money, net: Money, deductions: Money) {
    // not used
    // def plusGross (m: Money) = Paycheck(gross + m, net + m, deductions)
    def plusDeductions (m: Money) = Paycheck(gross, net - m, deductions + m)
}