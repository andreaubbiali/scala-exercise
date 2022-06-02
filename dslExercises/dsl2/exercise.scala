/**
 * calculate how much one person has to give to another person:
 * "Andrea has paied 10€, 15€, 18€ while Luca has paied 18€, 16€"
 * expected is:
 * "Andrea owe 0€ to Luca, Luca owe 9€ to Andrea"
 */ 

import scala.util.parsing.combinator._

object calcCost{
    
    def divide(p1: Tuple2[String, List[Int]], p2: Tuple2[String, List[Int]]) : Tuple2[Tuple2[String,Int], Tuple2[String,Int]] = { 

        val p1Amount = calcAmount(p1._2)
        val p2Amount = calcAmount(p2._2)

        if ((p1Amount-p2Amount) < 0) {
            ((p1._1, (p2Amount-p1Amount)), (p2._1, 0))
        } else {
            ((p1._1, 0), (p2._1, (p1Amount-p2Amount)))
        }
    }

    def calcAmount (amount: List[Int]): Int = {
        var tot = 0
        amount.foreach( a => tot += a)
        tot
    }

    def printResult(res : Tuple2[Tuple2[String,Int], Tuple2[String,Int]]) : Unit = {
        val p1 = res._1
        val p2 = res._2
        println(p1._1 + " owe " + p1._2 + "€ to " + p2._1 + ", " + p2._1 + " owe " + p2._2 + "€ to " + p1._1)
    }

}

class splitCosts() extends JavaTokenParsers{
    
    def start = person ~ ("while" ~> person) ^^ {
        case p1~p2 => calcCost.divide(p1, p2)
    }

    def person = name ~ ("has paied" ~> rep1sep(expenses, ","))^^{
        case n~exp => (n,exp)
    }
        
    def name = """[a-zA-Z]+""".r ^^{
        case p => p
    }

    def expenses = wholeNumber <~ "€" ^^{
        case amount => amount.toInt
    }

}

object main{

    def main(args: Array[String]): Unit = {
        
        val str = "Andrea has paied 10€, 15€, 18€ while Luca has paied 18€, 16€"

        // !attention. It must be 'val'
        val split = new splitCosts()

        split.parseAll(split.start, str) match{
            case split.Success(res, _) => calcCost.printResult(res)
            case x => println(x)
        }

    }

}