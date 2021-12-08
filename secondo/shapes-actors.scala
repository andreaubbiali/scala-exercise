// package shapes indica che è l'attore di quel pacchetto
package shapes {
    // _ == * (l'underscore è uguale a l'asterisco di java)
    import akka.actors._
    import akka.actors.Actor._
}


object ShapeDrawingActor extends Actor{
    def act() {
        // si mette in loop infinito aspettando i messaggi (come erlang)
        loop {
            // pattern match con il messaggio in arrivo
            receive {
                case s: Shape => s.draw()
                case "exit" => println("exiting..."); exit
                // se non è shape e non exit allora distruggiamo il messaggio
                case x: Any => println("Error: Unknown message! " + x)
            }
        }
    }
}