
import payroll._
import payroll.dsl._
import payroll.dsl.rules._
import scala.language.postfixOps

object main{

    def main(args: Array[String]): Unit = {
        val payrollCalculator = rules { employee =>
            employee salary_for 2.weeks minus_deductions_for { gross =>
                // TODO era '25.'
                federalIncomeTax is (25 percent_of gross)
                // TODO era '5.'
                stateIncomeTax is (5 percent_of gross)
                // TODO era '500.'
                insurancePremiums are (500 in gross.currency)
                // TODO era '10.'
                retirementFundContributions are (10 percent_of gross)
            }
        }

        val buck = Employee(Name("Buck", "Trends"), Money(80000))
        val jane = Employee(Name("Jane", "Doe"), Money(90000))

        List(buck, jane).foreach { employee =>
            val check = payrollCalculator(employee)
            printf("%s %s: %s\n", employee.name.first, employee.name.last, check)
        }
    }

}

