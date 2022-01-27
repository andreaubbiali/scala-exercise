/**
Left part of the exercise:
    scalar-matrix multiplication B = aA where A, B in Zm×n, a in Z (bij = a·aij for i = 1,...,m j = 1,...,n);
    matrix-matrix multiplication C = A·B where A in Zm×p, B in Zp×n, C in Zm×n (cij = Σk=1, ..., p aik·bkj for i = 1,...,m j = 1,...,n);
    matrix transposition B = AT where A in Zm×n, B in Zn×m (bji = aij for i = 1,...,m j = 1,...,n);
    matrix norm (matrix 1-norm) a = ‖A‖ where a in Z, A in Zm×n (a = maxj Σi | aij | for i = 1,...,m j = 1,...,n).
*/

object main{

    def main(args: Array[String]) = {

        val r1 = Array(1, 2, 3, 4)
        val r2 = Array(4, 3, 2, 1)
        val r3 = Array(1, 1)

        var m1 = Array[Array[Int]]()
        m1 = m1 :+ r1
        m1 = m1 :+ r2

        var m2 =  Array[Array[Int]]()
        m2 = m2 :+ r2
        m2 = m2 :+ r1 
        
        var mat1 = new Matrix(m1)
        println("mat1 created")
        var mat2 = new Matrix(m2)
        println("mat2 created")

        // use of equivalence
        println("expected true founded: " + mat1.equivalence(mat1))
        println("expected false founded: " + mat1.equivalence(mat2))
        println("expected false founded: " + mat1.equivalence(mat2))

        try{
            // throw exceptions
            var m3 = Array[Array[Int]]()
            m3 = m3 :+ r2
            m3 = m3 :+ r3

            var mat3 = new Matrix(m3)
        }catch{
            case e: IllegalArgumentException => println("Exception throwsed as expected")
        }

        // use of copy
        var mat4 = mat1.copy()
        println("expected true founded: " + mat1.equivalence(mat4))

        // use of addition
        var mat5 = mat1.addition(mat2)

        val rAdd1 = Array(5, 5, 5, 5)
        val rAdd2 = Array(5, 5, 5, 5)

        var mAddRes = Array[Array[Int]]()
        mAddRes = mAddRes :+ rAdd1
        mAddRes = mAddRes :+ rAdd2

        var matAddRes = new Matrix(mAddRes)
        println("expected true founded: " + mat5.equivalence(matAddRes))
    }

}