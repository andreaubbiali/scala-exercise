import scala.util.matching.Regex
import scala.util.parsing.combinator.JavaTokenParsers
import scala.collection.mutable

object BrainfuckInterpreter {

    /**
     * exec every expression in the list on the environment instance
     */
    def exec(expressions: List[Command], env: Environment): Unit = {
      expressions.foreach {
        case IncrementPointer() => env.incrementPointer()
        case DecrementPointer() => env.decrementPointer()
        case IncrementData() => env.increment()
        case DecrementData() => env.decrement()
        case Loop(innerExpressions) => while (env.get() > 0) exec(innerExpressions, env)
        case Print() => print(env.get().toChar)
        case PrintState() => println(env)
        case Input() => env.put(Console.in.read())
        case _ => throw new IllegalArgumentException
      }
    }
}

/**
 * Environment class, it need to be instantiated.
 */
class Environment {
  /** 
   * attributes of the class:
   * data is a map (int, int)
   * pointer is an int
   */
  private val data = new mutable.HashMap[Int, Int].withDefault(_ => 0)
  private var pointer = 0

  /**
   * methods of the class
   */
  def incrementPointer(): Unit = pointer += 1
  def decrementPointer(): Unit = pointer -= 1
  def increment(): Unit = data(pointer) += 1
  def decrement(): Unit = data(pointer) -= 1
  def get(): Int = data(pointer)
  def get(n: Int): Int = data(n)
  def put(n: Int): Unit = data(pointer) = n

  override def toString: String = f"^$pointer, " + data.toString()
}

/**
 * traits are like java interface
 * case classes under here implements the traits.
 */ 
sealed trait Command
case class IncrementPointer() extends Command
case class DecrementPointer() extends Command
case class IncrementData() extends Command
case class DecrementData() extends Command
case class Print() extends Command
case class PrintState() extends Command
case class Input() extends Command
// !expressions is an attribute of the class not a param
case class Loop(expressions: List[Command]) extends Command
// !expressions is an attribute of the class not a param
case class Program(expressions: List[Command])

object BrainfuckParser extends JavaTokenParsers {
  /**
  * specify what is a whiteSpace for us (all except the things written in the string)
  * thanks to this the program doesn't go in loop searchig for end of input
  */
  override protected val whiteSpace: Regex = """[^><\+\-\[\]\.#,]*""".r

  /**
   * loop is a list of commands of type "[ {commands} ]"
   * ^^ identify what to return
   * @return Loop -> is a case class that implement the Command interface so it's ok.
   */
  def loop: Parser[Loop] = "[" ~> rep(command) <~ "]" ^^ { Loop }

  /**
   * Do a parse of functions that implements the traits Command
   */
  def command: Parser[Command] = ("<" | ">" | "+" | "-" | "." | "," | "#" | loop) ^^ {
    case ">" => IncrementPointer()
    case "<" => DecrementPointer()
    case "+" => IncrementData()
    case "-" => DecrementData()
    case "." => Print()
    case "," => Input()
    case "#" => PrintState()
    case Loop(expressions) => Loop(expressions)
  }
  
  /**
   * program 
   * @return a Parser[Program] --> Program is a list of command
   * is a repetition of function command
   */
  def program: Parser[Program] = rep(command) ^^ { Program }
}

object BrainfuckEvaluator {
  def main(args: Array[String]): Unit = {

    args.foreach { filename =>
        val src = scala.io.Source.fromFile(filename)
        val lines = src.mkString

        println("RESULT expected is 'Hello World\\n':")

        // pass the file to the BrainfuckParser object
        BrainfuckParser.parseAll(BrainfuckParser.program, lines) match {
            case BrainfuckParser.Success(t,_) =>
                // pass the t to BrainfuckInterpreter object. 't' contains a concatenate of call of case classes(view above) 
                // BrainfuckInterpreter.exec(t, new Environment)
                BrainfuckInterpreter.exec(t.expressions, new Environment)
            case x => print(x.toString)
        }
        src.close()
      }
  }
}
