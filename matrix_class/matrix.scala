class Matrix(var dim1: Int, var dim2: Int){

    var mat = Array[Array[Int]]()

    /**
    * Constructor
    */
    def this(matr: Array[Array[Int]]) = {
        this(matr.size-1, matr(0).size-1)

        var size = matr(0).size
        
        for (r <-0 to (matr.size-1)){

            if (matr(r).size != size){
                throw new IllegalArgumentException("size mismatch")
            }
        }

        mat = matr
    }

    /**
    * Equivalence between two matrix
    */
    def equivalence(m2: Matrix): Boolean = {
        if (!sameSize(m2)){
            false
        }

        for( r <- 0 to dim1){
            
            for (c <-0 to dim2){

                if(mat(r)(c) != m2.mat(r)(c)){
                    return false
                }
            }
        }

        true
    }

    /**
    * Return a new matrix equal to this
    */
    def copy(): Matrix = {
        return new Matrix(mat)
    }

    /**
    * Return a new matrix equal to this+m2
    */
    def addition(m2: Matrix): Matrix = {
        if (!sameSize(m2)){
            throw new IllegalArgumentException("not same size")
        }

        var arr = Array[Array[Int]]()
        
        //sum this to mres
        for( r <- 0 to dim1){
            
            var row = Array[Int]()
            
            for (c <-0 to dim2){

                row = row :+ (m2.mat(r)(c) + this.mat(r)(c))
            }
            arr = arr :+ row

        }
        return new Matrix(arr)
    }

    /**
    * Check the equal size of the two matrix
    */
    def sameSize(m2: Matrix): Boolean = {
        if (dim1 == m2.dim1 || dim2 == m2.dim2){
            false
        }

        true
    }

    override def toString(): String = {
        var res = "matrix:\n"

        for( r <- 0 to dim1){
            
            for (c <- 0 to dim2){
                
                res = res + mat(r)(c)

            }
            res = res ++ "\n"
        }
        res

    }

}