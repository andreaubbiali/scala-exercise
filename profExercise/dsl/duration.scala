package payroll.dsl

// implicitly converted int to duration
case class Duration(val amount: Int) {
    def weeks = amount * 5
    def years = amount * 260
}