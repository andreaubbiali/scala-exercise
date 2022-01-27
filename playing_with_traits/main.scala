import scala.io.StdIn

/**
    I could use also the enum for the different commands possible.
*/

object main{

    var editor = new Editor(0, "ciao questa è la linea su cui lavorare")

    def main(args: Array[String]): Unit = {

        println("command must be of type: \":[address] command [options]\". Write end to finish")

        /** NEXT IMPLEMENTATION
            var document = new Document()
            document.addLine("prova di aggiunta di una prima linea")
            document.addLine("ed ecco la seconda linea che ho aggiunto")
            document.addLine("qua la terza linea")
        */
        

        var res = StdIn.readLine()

        while(res != "end"){
            
            res = res.filterNot(x => (":").contains(x))
            
            var splitted = res.split(" ")
            callAction(splitted.size, splitted)

            println(editor)

            res = StdIn.readLine()
        }
        
    }

    def callAction(numSplit: Int, splitted: Array[String]) = numSplit match{
        case 3 => 
        case 2 => call2(splitted(0).toInt, splitted(1))
        case 1 => call1(splitted(0))
        case _ => println("the input is wrong")
    }

    def call2(addr: Int, command: String) = command match{
        case "x"  => editor.xOperation(addr)
        case "dw" => editor.dwOperation(addr)
        case _ =>  println("the input is wrong")
    }

    def call1(command: String) = command match{
        case "u" => editor.uOperation()
        case _ => println("the input is wrong")
    }

}