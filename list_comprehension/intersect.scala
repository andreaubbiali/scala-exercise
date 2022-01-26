/**
- intersect that given two generic lists, returns a new list that is the intersection of the two lists
 (e.g., intersect(List(1,2,3,4,5), List(4,5,6,7,8)) should return List(4,5)).
*/

class Intersect(){

    def calcInters(l1: List[Any], l2: List[Any]): List[Any] = {
        var res = List[Any]()

        l1.map(x => if(l2.contains(x)) {res = res :+ x})
        
        res
    }
}