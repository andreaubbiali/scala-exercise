import payroll.api._
import payroll.api.DeductionsCalculator._
import payroll._
import payroll.Type2Money._


object main{

    def main(args: Array[String]): Unit = {
        val buck = Employee(Name("Buck", "Trends"), Money(80000))
        val jane = Employee(Name("Jane", "Doe"), Money(90000))

        List(buck, jane).foreach { employee =>
            // TODO era '26.' CAMBIA QUALCOSA(?)
            val biweeklyGross = employee.annualGrossSalary / 26 // era '26.' CAMBIA QUALCOSA(?)

            val deductions = federalIncomeTax(employee, biweeklyGross) +
                stateIncomeTax(employee, biweeklyGross) +
                insurancePremiums(employee, biweeklyGross) +
                retirementFundContributions(employee, biweeklyGross)

            val check = Paycheck(biweeklyGross, biweeklyGross - deductions, deductions)
                printf("%s %s: %s\n", employee.name.first, employee.name.last, check)
        }
    }
}
