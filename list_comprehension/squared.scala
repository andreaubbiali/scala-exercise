class Squared(lst: List[Any]){

    var res = List[Any]()

    def squaredNum() = {

        lst.map(x => res = res :+ calc(x))

        res = res.filterNot(_.isInstanceOf[Unit])
    }
    
    def isNum(v: Any) = v match {
        case _: Int | _: Double => true
        case _ => false
    }
    

    def calc(v: Any): Any = v match {
        case i: Int => i*i
        case d: Double => d*d
        case l: List[Any] => (l.map(x => calc(x))).filterNot(_.isInstanceOf[Unit])
        case t: Tuple3[a, b, c] if isNum(t._1) && isNum(t._2) && isNum(t._3) => (calc(t._1), calc(t._2), calc(t._3))
        case t: Tuple3[a, b, c] if isNum(t._1) && isNum(t._2) => (calc(t._1), calc(t._2))
        case t: Tuple3[a, b, c] if isNum(t._1) && isNum(t._3) => (calc(t._1), calc(t._3))
        case t: Tuple3[a, b, c] if isNum(t._2) && isNum(t._3) => (calc(t._2), calc(t._3))
        case t: Tuple3[a, b, c] if isNum(t._1) => (calc(t._1))
        case t: Tuple3[a, b, c] if isNum(t._2) => (calc(t._2))
        case t: Tuple3[a, b, c] if isNum(t._3) => (calc(t._3))
        case _ => ()
    }
}