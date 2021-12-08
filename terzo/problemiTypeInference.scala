// potresti scegliere di non specificare cosa torna una funzione però.... vedi sotto

def makeList(strings: String*) = {
    if (strings.length == 0)
        List(0) // #1
    else
        strings.toList
}

val list: List[String] = makeList()

// We intended for makeList to return a List[String] , but when strings.length equals
// zero, we returned List(0) , incorrectly “assuming” that this expression is the correct
// way to create an empty list. In fact, we returned a List[Int] with one element, 0 . We
// should have returned List() . Since the else expression returns a List[String] , the
// result of strings.toList , the inferred return type for the method is the closest common
// supertype of List[Int] and List[String] , which is List[Any] . Note that the compila-
// tion error doesn’t occur in the function definition. We only see it when we attempt to
// assign the value returned from makeList to a List[String] variable.