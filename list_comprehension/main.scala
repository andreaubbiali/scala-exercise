object main {

    def main(args: Array[String]) = {
        
        val lst = (1 :: "hello" :: 100 :: 3.14 :: ('a'::10::Nil) :: 'c' :: (5,7,'a') :: Nil)
        val squar = new Squared(lst)

        squar.squaredNum()

        println(squar.res)
        println("expected " + List(1, 10000, 9.8596, List(100), (25,49)))

        println()
        var inter = new Intersect()
        println(inter.calcInters(List(1,2,3,4,5), List(4,5,6,7,8)))

        println()
        var diff = new Difference()
        println(diff.calcDiff(List(1,2,3,4,5), List(4,5,6,7,8)))
    }

}