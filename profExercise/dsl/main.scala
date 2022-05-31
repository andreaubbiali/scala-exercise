
import payroll._
import payroll.dsl._
import payroll.dsl.rules._

object main{

    def main(args: Array[String]): Unit = {

        /**
         * Creation of the function payrollCalculator which takes an argument of type Employee
         */        
        val payrollCalculator = rules { employee =>
            employee salary_for 2.weeks minus_deductions_for { gross =>
                // federalIncomeTax {object} is {take a DeductionBuilder} (25.0 percent_of gross) {new rule}
                federalIncomeTax is (25.0 percent_of gross)
                stateIncomeTax is (5.0 percent_of gross)
                insurancePremiums are (500.0 in gross.currency)
                retirementFundContributions are (10.0 percent_of gross)
            }
        }

        val buck = Employee(Name("Buck", "Trends"), Money(80000))
        val jane = Employee(Name("Jane", "Doe"), Money(90000))

        List(buck, jane).foreach { employee =>
            // call tha function payrollCalculator passing the employee
            val check = payrollCalculator(employee)
            
            printf("%s %s: %s\n", employee.name.first, employee.name.last, check)
        }
    }

}

