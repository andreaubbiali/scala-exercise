import shapes._

// start di ShapeDrawingActor
ShapeDrawingActor.start()

// invio di messaggio a ShapeDrawingActor
ShapeDrawingActor ! new Circle(new Point(0.0,0.0), 1.0)

ShapeDrawingActor ! new Rectangle(new Point(0.0,0.0), 2, 5)

ShapeDrawingActor ! new Triangle(new Point(0.0,0.0),
                                new Point(1.0,0.0),
                                new Point(0.0,1.0))

ShapeDrawingActor ! 3.14159

ShapeDrawingActor ! "exit"