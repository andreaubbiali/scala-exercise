import scala.util.parsing.combinator._
import scala.collection.mutable._


class DeskCombinators(var the_table: HashMap[Char,Int])  extends JavaTokenParsers {
    
    def program = "print" ~> expr ~ ("where" ~> rep1sep(decl, ",")) ^^
                {
                    case f ~ d => println(f());the_table
                }

    def expr: Parser[() => Int] = 
        (
            (x ~ ("+" ~> x)) ^^ 
            {
                case f1~f2 => () => f1() + f2()
            }:Parser[()=>Int]
        )
    /**
    def program = "print" ~> expr ~ 
            ( "where" ~> rep1sep(decl, ",")) ^^ { 
                case f ~ d => println(f()); the_table 
            }
    
    def expr: Parser[() => Int] = 
        (
            (( (num~("+" ~> expr))
            | (x ~ ("+" ~> expr))
        ) ^^ {case f1~f2 => () => f1() + f2()}:Parser[()=>Int])| x | num)
    */

    def x = """[a-z]""".r ^^ {c => () => the_table(c.charAt(0))} 
    
    def num = wholeNumber ^^ { n => () => n.toInt }
    
    // qualcosa[a-z] ~ ("=" e wholeNumber)
    // poi nel case vado a fare il vero parse e gli dico cosa fare
    def decl = """[a-z]""".r ~ ("=" ~> wholeNumber) ^^ {
        case c~n => the_table(c.charAt(0)) = n.toInt
    }
}

object DeskEvaluator {
    def main(args: Array[String]) = {
        val p = new DeskCombinators(new HashMap[Char,Int]())
        
        // val lines = "print x+y+z+1+x+-3 where x = 25, y = 1, z=-7"
        val semplice = "print x+y where x = 25, y = 1"

        p.parseAll(p.program, semplice) match {
            case p.Success(s,_) => println(s)
            case x => print(x.toString)
        }
        
    }
}
