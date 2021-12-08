val bools = List(true, false)


for (bool <- bools) {
    bool match {
        case true => println("heads")
        case false => println("tails")
        case _ => println("something other than heads or tails (yikes!)")
    }
}

import scala.util.Random
val randomInt = new Random().nextInt(10)

// se non matcha con 7 matcha con otherNumber che è una variabile che avrà il valore di randomInt
randomInt match {
    case 7 => println("lucky seven!")
    case otherNumber => println("boo, got boring ol' " + otherNumber)
}

// match basato sul type

val sundries = List(23, "Hello", 8.5, 'q')

for (sundry <- sundries) {
    sundry match {
        case i: Int => println("got an Integer: " + i)
        case s: String => println("got a String: " + s)
        case f: Double => println("got a Double: " + f)
        case other => println("got something else: " + other)
    }
}


val willWork = List(1, 3, 23, 90)
val willNotWork = List(4, 18, 52)
val empty = List()
// possiamo controllare se ci sono n elementi ed il secondo è 3
for (l <- List(willWork, willNotWork, empty)) {
    l match {
        case List(_, 3, _, _) => println("Four elements, with the 2nd being '3'.")
        case List(_*) => println("Any other list with 0 or more elements.")
    }
}

// notazione head::tail per dividere la coda dalla testa
def processList(l: List[Any]): Unit = l match {
    case head :: tail =>
        print(head + "-")
        processList(tail)
    case Nil => println("")
}
// for per chiamare processList
for (l <- List(willWork, willNotWork, empty)) {
    print("List: ")
    processList(l)
}

// pattern matching su tuple anche con guardie
val tupA = ("Good", "Morning!")
val tupB = ("Guten", "Tag!")
for (tup <- List(tupA, tupB)) {
    tup match {
        case (thingOne, thingTwo) if thingOne == "Good" =>
        println("A two-tuple starting with 'Good'.")
        case (thingOne, thingTwo) =>
        println("This has two things: " + thingOne + " and " + thingTwo)
    }
}

// pattern matching su classi
case class Person(name: String, age: Int)

val alice = new Person("Alice", 25)
val bob = new Person("Bob", 32)
val charlie = new Person("Charlie", 32)

for (person <- List(alice, bob, charlie)) {
    person match {
        case Person("Alice", 25) => println("Hi Alice!")
        case Person("Bob", 32) => println("Hi Bob!")
        case Person(name, age) => println("Who are you, " + age + " year-old person named " + name + "?")
    }
}

// pattern matching with nested variables
class Role
case object Manager extends Role
case object Developer extends Role
case class Person(name: String, age: Int, role: Role)
val alice = new Person("Alice", 25, Developer)
val bob = new Person("Bob", 32, Manager)
val charlie = new Person("Charlie", 32, Developer)

for (item <- Map(1 -> alice, 2 -> bob, 3 -> charlie)) {
    item match {
        // diamo a p il valore, così possiamo utilizzarlo per stampare
        case (id, p @ Person(_, _, Manager)) => format("%s is overpaid.\n", p)
        case (id, p @ Person(_, _, _)) => format("%s is underpaid.\n", p)
    }
}

// use of regexp
val BookExtractorRE = """Book: title=([^,]+),\s+authors=(.+)""".r
val MagazineExtractorRE = """Magazine: title=([^,]+),\s+issue=(.+)""".r
val catalog = List(
    "Book: title=Programming Scala, authors=Dean Wampler, Alex Payne",
    "Magazine: title=The New Yorker, issue=January 2009",
    "Book: title=War and Peace, authors=Leo Tolstoy",
    "Magazine: title=The Atlantic, issue=February 2009",
    "BadData: text=Who put this here??"
)

for (item <- catalog) {
    item match {
        case BookExtractorRE(title, authors) =>
            println("Book \"" + title + "\", written by " + authors)
        case MagazineExtractorRE(title, issue) =>
            println("Magazine \"" + title + "\", issue " + issue)
            case entry => println("Unrecognized entry: " + entry)
    }
}