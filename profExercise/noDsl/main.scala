import payroll.api._
import payroll.api.DeductionsCalculator._
import payroll._
import payroll.Type2Money._

object main{

    def main(args: Array[String]): Unit = {

        /**
         * Instantiate two new objects. The 'new' keyword is not used because 
         * the case classes have the apply method implicitly that works like a constructor
         */
        val buck = Employee(Name("Buck", "Trends"), Money(80000))
        val jane = Employee(Name("Jane", "Doe"), Money(90000))

        List(buck, jane).foreach { employee =>

            // 26 is casted (implicitly) to Money object by the class "import payroll.Type2Money._"
            val biweeklyGross = employee.annualGrossSalary / 26.0
            
            // we are calling methods of the singleton object 'DeductionsCalculator' imported in this file
            val deductions = federalIncomeTax(employee, biweeklyGross) +
                stateIncomeTax(employee, biweeklyGross) +
                insurancePremiums(employee, biweeklyGross) +
                retirementFundContributions(employee, biweeklyGross)

            val check = Paycheck(biweeklyGross, biweeklyGross - deductions, deductions)
            
            printf("%s %s: %s\n", employee.name.first, employee.name.last, check)
        }
    }
}
