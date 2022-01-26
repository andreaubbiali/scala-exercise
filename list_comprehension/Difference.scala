
class Difference(){

    def calcDiff(l1: List[Any], l2: List[Any]): List[Any] = {
        var res = List[Any]()

        var inter = new Intersect()

        var not = inter.calcInters(l1, l2)

        res = res ++ l1.filterNot(x => not.contains(x))
        res = res ++ l2.filterNot(x => not.contains(x))
        
        res
    }
}