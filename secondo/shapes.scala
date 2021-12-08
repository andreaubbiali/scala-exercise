// in scala tutto il body della classe è un costruttore
package shapes {

    // i parametri essendo con "val" sono read-only. Per farli mutabili devi mettere "var"
    class Point(val x: Double, val y: Double) {
        // override la funzione toString()
        override def toString() = "Point(" + x + "," + y + ")"
    }

    // classe astratta 
    abstract class Shape() {
        // unit è uguale a tornare void
        def draw(): Unit
    }

    // concreta sottoclasse di shape
    class Circle(val center: Point, val radius: Double) extends Shape {
        def draw() = println("Circle.draw: " + this)
        override def toString() = "Circle(" + center + "," + radius + ")"
    }

    // concreta sottoclasse di shape
    class Rectangle(val lowerLeft: Point, val height: Double, val width: Double) extends Shape {
        def draw() = println("Rectangle.draw: " + this)
        override def toString() =
        "Rectangle(" + lowerLeft + "," + height + "," + width + ")"
    }

    // concreta sottoclasse di shape
    class Triangle(val point1: Point, val point2: Point, val point3: Point)
        extends Shape {
        def draw() = println("Triangle.draw: " + this)
        override def toString() =
        "Triangle(" + point1 + "," + point2 + "," + point3 + ")"
    }
}