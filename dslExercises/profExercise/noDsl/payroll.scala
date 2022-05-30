package payroll

/**
 * Case classes are something like a pattern matching
 * but is used a class to do it.
 * They can be instantiated without the new keywoark because implicitly
 * have the apply method that works like a constructor.
 */ 
case class Name(first: String, last: String)
case class Employee(name: Name, annualGrossSalary: Money)