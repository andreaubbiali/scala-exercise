val stateCapitals = Map(
    "Alabama" -> "Montgomery",
    "Alaska" -> "Juneau",
    // ...
    "Wyoming" -> "Cheyenne"
)

println("Get the capitals wrapped in Options:" )
println("Alabama: " + stateCapitals.get("Alabama") )
println("Wyoming: " + stateCapitals.get("Wyoming") )
println("Unknown: " + stateCapitals.get("Unknown") )


println( "Get the capitals themselves out of the Options:" )
println("Alabama: " + stateCapitals.get("Alabama").get )
println("Wyoming: " + stateCapitals.get("Wyoming").getOrElse("Oops!") )
println("Unknown: " + stateCapitals.get("Unknown").getOrElse("Oops2!") )

// risposta dell'esecuzione
// questo primo gruppo richiama toString implicitamente. Stiamo chiamando il ToString su Some o su None
// Get the capitals wrapped in Options:
// Alabama: Some(Montgomery)
// Wyoming: Some(Cheyenne)
// Unknown: None

// chiamiamo il get sull'oggetto some o none 
// Get the capitals themselves out of the Options:
// Alabama: Montgomery
// Wyoming: Cheyenne
// Unknown: Oops2!

// The second group of println statements goes a step further. After calling Map.get , they
// call get or getOrElse on each Option instance to retrieve the value it contains.
// Option.get requires that the Option is not empty—that is, the Option instance must
// actually be a Some . In this case, get returns the value wrapped by the Some , as demon-
// strated in the println where we print the capital of Alabama. However, if the Option
// is actually None , then None.get throws a NoSuchElementException .

// We also show the alternative method, getOrElse , in the last two println statements.
// This method returns either the value in the Option , if it is a Some instance, or it returns
// the second argument we passed to getOrElse , if it is a None instance. In other words,
// the second argument to getOrElse functions as the default return value.

// come ritornare un oggetto option?:
def get(key: A): Option[B] = {
    if (contains(key))
        new Some(getValue(key))
    else
        None
}