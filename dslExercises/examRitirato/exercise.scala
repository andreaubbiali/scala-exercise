import scala.io.Source
import scala.util.parsing.combinator.JavaTokenParsers

class csvParser(var keys: List[String], var values: List[String], var index: Int) extends JavaTokenParsers{

    def prova = firstLine <~ ("\n" ~> linee <~ """[\.]+""".r ) ^^ {
        case a => values
    }

    def linee = repsep(linea, "\n") ^^ { 
        case a => println(a) 
    }

    def linea = repsep(something, ",")  ^^ {
        case a => a
    }

    

  // def program: Parser[Program] = rep(command) ^^ { Program }


    def firstLine = repsep(something, ",") ^^ {
        case a => keys = a;
    }

    def restline: Unit = ((oneLine <~ "\n") | ".") ^^ {
        case "." => println("FINEEEE")
        case a => restline
    }

    def oneLine = repsep(something, "\n") ^^ {
        case a => a
    }

/**
    def restline = repsep(line, "\n") ^^ {
        case a => println(a)
    }

    def line = ("." | repsep(something, ","))  ^^ {
        case "." => println("FINEEEEEEE")
        case a => println(a)
    }
*/
    def something = ("""[\w\s\d\"\/]+""".r) ^^ {
        case a => a.toString()
    }
    
}

object main{

    def main(args: Array[String]): Unit = {
        
       var lstKeys = List[String]() 
       var lstValues = List[String]()

        val csv = new csvParser(lstKeys, lstValues, 0)

        val src = scala.io.Source.fromFile("file.csv")
        val lines = src.mkString
        
        csv.parseAll(csv.prova, lines) match{
            case csv.Success(_, _) => printa(lstKeys)
            case x => println(x.toString)
        }

        src.close()
    }

    def printa(values: List[String]) : Unit = {
        println ("HA FINITO")
    }
    
}