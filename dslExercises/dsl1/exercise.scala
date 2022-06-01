import scala.util.parsing.combinator._
import scala.collection.mutable._


class DeskCombinators(var the_table: HashMap[Char,Int])  extends JavaTokenParsers {
    
    // split the string in things (expression and repetition of variable)
    def program = "print" ~> expr ~ ("where" ~> rep1sep(decl, ",")) ^^ {
            case f ~ d => f()
        }

    /**
     * parse the expression and return the function to exec this expression. There are 3 type of parse:
     * 1. is something + expression
     * 2. is a variable
     * 3. is a number
     * the 2 and 3 are needed to make the parse end. Without this two the parser need another expr and another and ...
     * In case expression:  x+y+z+1+x+-3 the last value is a number so "num" is needed to finish the parse
     * In case expression: x+y+z+1+x+y the last value is a var so "varToNum is needed to finish the parse"
     */        
    def expr: Parser[() => Int] = 
        (
            // 1. something(variable/number) "+" an expression
            (
                (( varToNum ~ ("+" ~> expr)) | (num ~ ("+" ~> expr))) ^^
                    {
                        case f1~f2 => () => f1() + f2()
                    }:Parser[()=>Int]
            ) 
            // 2. return a function that cast a variable to a number
            | varToNum 
            // 3. return a number
            | num 
        )

    // convert from variable to number
    def varToNum = """[a-z]""".r ^^ {c => () => the_table(c.charAt(0))} 
    
    // simply number
    def num = wholeNumber ^^ { n => () => n.toInt }
    
    // add into the map the value of the variable
    def decl = """[a-z]""".r ~ ("=" ~> wholeNumber) ^^ {
        case c~n => the_table(c.charAt(0)) = n.toInt
    }
}

object DeskEvaluator {
    def main(args: Array[String]) = {
        val p = new DeskCombinators(new HashMap[Char,Int]())
        
        val lines = "print x+y+z+1+x+-3 where x = 25, y = 1, z=-7"
        
        // parse that return the result of the computation.
        p.parseAll(p.program, lines) match {
            case p.Success(s,_) => println("RESULT: "+ s)
            case x => print(x.toString)
        }
        
    }
}
