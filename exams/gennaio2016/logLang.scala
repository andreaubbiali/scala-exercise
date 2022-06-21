import scala.util.parsing.combinator.JavaTokenParsers;;
import scala.io.Source;;

trait command{
    def exec: Unit
}
case class remove(f: String) extends command {
    def exec = println("remove") 
}
case class rename() extends command {
    def exec = println("rename")  
}
case class backup() extends command {
    def exec = println("backup")  
}
case class merge() extends command {
    def exec = println("merge")  
}

class logParse() extends JavaTokenParsers{
    
    def start = rep(task) ^^ {
        case a =>
    }
    
    def task = "task" ~> word ~ ("{" ~> rep(comm) <~ "}") ^^{
        case a~t => println("Task " + a);
                    t.foreach(c => c.exec)
    }

    def word = """[a-zA-Z.+]+""".r ^^ {case w => w}
     
    def comm :Parser[command] = ("remove" | "rename" | "backup" | "merge") ~ rep(nameFile) ^^{
        case "remove" ~ a => remove(a)
        case "rename" ~ a => rename()
        case "backup" ~ a => backup()
        case "merge" ~ a => merge()
        case x  => throw new Exception()
    } 

    def nameFile = "\"" ~> word <~ "\"" ^^ {
        case w => w
    }

}


object main {

    def main(args: Array[String]): Unit = {
        
        val p = new logParse()

        var file = Source.fromFile("test.ll").mkString

        p.parseAll(p.start, file) match {
            case p.Success(res, _) => println("ok")
            case x  => println(x.toString)
        }
    }

}
