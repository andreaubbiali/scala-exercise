object StringUtil {
    def joiner(strings: List[String], separator: String): String =
        strings.mkString(separator)

    def joiner(strings: List[String]): String = joiner(strings, " ")
}

object ProvaString {
    // valore deault separator è " " ma se gli passo un'altro valore allora prende quello
    def unisci(strings: List[String], separator: String = " "): String =
        strings.mkString(separator)
}

import StringUtil._
import ProvaString._

// Import the joiner methods.
println( joiner(List("Programming", "Scala")) )
println( joiner(List("Programming", "Scala"), ",") )
println( unisci(List("Prova", "Ciao")))
println( unisci(List("Prova", "Ciao"), "."))