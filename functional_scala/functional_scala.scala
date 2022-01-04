
import scala.io.StdIn.readLine
import scala.io.StdIn.readInt

object Main{
    def main(args: Array[String]): Unit = {
        
        val str = readLine()

        println("Is " + str + " palindrome? " + is_palindrome(replaceCaracters(str)))

        val anagStr = "precisa"
        val anagLst = List(	"sciarPe", "rapIsce", "NotAnag", "saperci",	"ripesca", "notAnagramma")
        is_an_anagram(anagStr, anagLst)

        val num = readInt()
        println("Prime numbers of " + num + " are: " + factors(num))

        println("is the number " + num + " a proper number? " + is_proper(num))
    }

    def is_palindrome(str: String): Boolean = {

        val reversedStr = str.reverse

        str.toUpperCase() == reversedStr.toUpperCase()
    }

    def is_an_anagram(str: String, strLst: List[String]): Unit = {

        val anagrams =
            for (s <- strLst if is_anagram(str, s))
            yield s  // add s to the anagrams list

        println("The anagrams of " + str + " are " + anagrams)
    }

    def is_anagram(str1: String, str2: String): Boolean = {
        val s1 = str1.toUpperCase()
        var s2 = str2.toUpperCase()
        var founded = true

        for (c <- s1.toList
            if founded == true; if s2.length() > 1){

                if (s2.indexOf(c) == -1) {
                    founded = false
                }else{
                    s2 = s2.replaceFirst(c.toString(), "")
                }
        }

        founded
    }

    def factors(num: Integer): IndexedSeq[Int] = {
        
        for (n <- 2 to num if is_prime(n))
        yield n

    }

    def is_prime(num: Integer): Boolean = {

        var prime = true
        
        for (n <- 2 to num-1 if prime == true){
            if (num % n == 0) {
                prime = false
            }
        }

        prime
    }

    def is_proper(num: Integer): Boolean ={
        val divisors = find_divisors(num)
        var sum = 0

        for (n <- divisors){
            sum = sum + n
        }

        sum == num
    }

    def find_divisors(num: Integer): IndexedSeq[Int] = {
        
        for (n <- 1 to num/2 if num%n == 0)
        yield n
    }

    // replace " " & "," & "?" & "." with "" 
    def replaceCaracters(str: String): String = {
        var newStr = str
        newStr = newStr.replaceAll(" ", "")
        newStr = newStr.replaceAll(",", "")
        newStr = newStr.replaceAll("\\?", "")
        newStr = newStr.replaceAll("\\.", "")
        newStr
    }
}

