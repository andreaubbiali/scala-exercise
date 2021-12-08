// abbiamo usato due volte la variabile i ma non cambia niente perchè non mi serve all'interno del metodo fact la i esterna
def factorial(i: Int): Int = {
    def fact(i: Int, accumulator: Int): Int = {
        if (i <= 1)
            accumulator
        else
            fact(i - 1, i * accumulator)
    }
    fact(i, 1)
}

println(factorial(0))
println(factorial(1))
println(factorial(2))
println(factorial(3))
println(factorial(4))
println(factorial(5))

// se mi serve n nel metodo innestato la chiamo senza dovergliela passare. Il metodo interno ha visibilità su variabili esterne
def countTo(n: Int):Unit = {
    def count(i: Int): Unit = {
        if (i <= n) {
            println(i)
            count(i + 1)
        }
    }
    count(1)
}

countTo(5)