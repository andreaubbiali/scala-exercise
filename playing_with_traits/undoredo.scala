
trait UndoRedo{

    var line: String
    var cursor: Int
    var oldLine : List[String]
    var oldCursor: List[Int]

    def saveUndoRedo(oldLine: String, oldCursor: Int) = {
        this.oldLine = oldLine :: this.oldLine
        this.oldCursor = oldCursor :: this.oldCursor
    }

    def undo() = {

        if(this.oldLine.isEmpty || this.oldCursor.isEmpty) {
            throw new IllegalArgumentException("no old line")
        }

        line = oldLine.head
        oldLine = oldLine.tail
        cursor = oldCursor.head
        oldCursor = oldCursor.tail
    }


}