
class Editor(var cursor: Int, var line: String) extends UndoRedo {

    var oldLine = List[String]()
    var oldCursor = List[Int]()

    /**
        x which deletes the character under the cursor (does nothing if no characters are present) and move the cursor on the character on the right if 
        present otherwise back of one
    */
    def xOperation(addr: Int): Unit = {
        saveUndoRedo(line, cursor)
        
        if (addr > line.size){
            return
        }

        // update the string
        var tmp = line
        if (addr == line.size){
            
            line = tmp.substring(0, addr-1)

        } else {

            line = tmp.substring(0, addr) + line.substring(addr+1, line.size)

        }
        

        if (line.size == addr-1){
            cursor = addr-1
        } else {
            cursor = addr
        }

    }
    
    /**
        dw which deletes from the character under the cursor (included) to the next space (excluded) or to the end of the line and moves the cursor on the 
        character on the right if any or backwards otherwise;
    */
    def dwOperation(addr: Int): Unit = {
        saveUndoRedo(line, cursor)
    }

    def uOperation() = {
        try{
            this.undo()
        }catch{
            case e:IllegalArgumentException => println("No old line")
        }
        
    }

    /**
    * i which adds a character c after the character under the cursor and moves the cursor under c
    * iw which adds a word w followed by a blank space after the character under the cursor and moves the cursor under the blank space;
    * l which moves the cursor n (1 as default, i.e., when nothing is specified) characters on the right from the current position (it does nothing when at 
        the end of the text or it moves less if it is close to the end);
    * h which moves the cursor n (1 as default, i.e., when nothing is specified) character on the left from the current position (it does nothing when at the 
        beginning of the text or it moves less if it is close to the beginning).
    */

    override def toString(): String = {
        return this.line + ".\nThe cursor is at the position: " + this.cursor
    }

}