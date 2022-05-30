package payroll

case class Paycheck(gross: Money, net: Money, deductions: Money) {
    // TODO add paycheck logic(not implemented by profe)
    // printf("%s %s %s\n", gross, net, deductions)

    // def plusGross (m: Money) = Paycheck(gross + m, net + m, deductions)
    // def plusDeductions (m: Money) = Paycheck(gross, net - m, deductions + m)
}