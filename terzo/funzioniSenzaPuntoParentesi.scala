
// un metodo senza parametri puoi chiamarlo senza parentesi
def aa = List(1,2,3).size  // --> se scrivi List(1,2,3).size() da errore
println(aa)

// dovrebbe funzionare ma non lo fa (bho?)
// // un metodo senza parametri o con solo uno puoi chiamarlo omettendo il punto
// import scala.language.postfixOps
// def bb = List(1,2,3) size 


def isEven(n: Int) = (n % 2) == 0
List(1, 2, 3, 4) filter isEven foreach println // --> printa 2 4


