
// questo parte con i comandi:
//          $>scala nomescript.scala
class Upper {
    def upper(strings: String*): Seq[String] = {
        strings.map((s:String) => s.toUpperCase())
    }
}

object Upper {
    def main(args: Array[String])={
        val up = new Upper
        Console.println(up.upper("A", "First", "Scala", "Program"))
    }
    
}

// oppure
// object Upper {
//     def main(args: Array[String]) = {
//         args.map(_.toUpperCase()).foreach(printf("%s ",_))
//         println("")
//     }
// }


// oppure
// questo parte con i comandi:
//              $>scala
//                  scala> :load nomescript.scala
// object Upper {
//     def upper(strings: String*) = strings.map(_.toUpperCase())
// }

// println(Upper.upper("A", "First", "Scala", "Program"))