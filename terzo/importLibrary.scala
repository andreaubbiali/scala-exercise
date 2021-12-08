def writeAboutBigInteger() = {

    import java.math.BigInteger.{
        ONE => _,
        TEN,
        ZERO => JAVAZERO 
    }
}

// ONE is effectively undefined
// println( "ONE: "+ONE )
println( "TEN: "+TEN )
println( "ZERO: "+JAVAZERO )
writeAboutBigInteger()

// libreria java.math.BigInteger.ZERO è rinominata in JAVAZERO e possiamo richiamarla così.

// Gli import in scala non devono essere per forza all'inizio, possiamo metterli dove vogliamo