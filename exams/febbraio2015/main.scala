import scala.util.parsing.combinator.JavaTokenParsers;
import scala.collection.mutable.HashMap;

class deskparser(map: HashMap[String, Int]) extends JavaTokenParsers{

    def start = "print" ~> rep1sep(expr, "+") ~ ( "where" <~ rep1sep(assignVar, ",")) ^^{
        case e~v => var res = 0;
                    e.foreach(x => res += x());
                    println(res); map
    }

    def expr : Parser[()=>Int] = (
        (
            variable ^^{
                case v => () => map.get(v) match{
                    case Some(b) => b
                    case None => throw new Exception   
                }
            }:Parser[()=>Int]
        )
        | num
    )

    def assignVar = variable ~ ("=" ~> num )^^{
        case v~n => map.put(v, n())
    }

    def variable = """[a-z]""".r ^^ {case v => v}

    def num :Parser[()=>Int] = wholeNumber ^^ { case a => () => a.toInt}
}

object main{

    def main(args: Array[String]) : Unit = {
        
        var map = new HashMap[String, Int]
        val p = new deskparser(map)

        var str = "print x+y+z+1+x+-3 where x = 25, y = 1, z=-7"

        p.parseAll(p.start, str) match {
            case p.Success(res, _) => println("ok")
            case x => println(x.toString()) 
        } 
        
    }

}

