import scala.io.Source
import scala.util.parsing.combinator.JavaTokenParsers
import scala.collection.mutable
import scala.util.matching.Regex


class csvParser(var mappa : mutable.HashMap[String, Array[String]]) extends JavaTokenParsers{

    override val whiteSpace = """[ \t]+""".r

    def start = line ~ ("\n" ~> rep1sep(line, "\n")) ^^{
        case fstLine~values => (fstLine,values)
    }

    def line = rep1sep(word, ",") ^^ {
        case l => l
    }
    
    def word = """[a-zA-Z0-9\" /]+""".r ^^ {
        case w => w
    }
}

object main{

    def main(args: Array[String]): Unit = {
        
       var mappa = new mutable.HashMap[String, Array[String]]()

        val csv = new csvParser(mappa)

        val src = scala.io.Source.fromFile("file.csv")
        val lines = src.mkString
        
        csv.parseAll(csv.start, lines) match{
            case csv.Success(res, _) => println(res._1)
                                        println(res._2)
            case x => println(x.toString)
        }

        src.close()
    }    
}