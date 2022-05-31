# Description
The brainfuck language uses a simple machine model consisting of the program and instruction pointer, as well as an array of at least 30,000 byte cells initialized to zero; a movable data pointer (initialized to point to the leftmost byte of the array); and two streams of bytes for input and output (most often connected to a keyboard and a monitor respectively, and using the ASCII character encoding).

### Commands:

The eight language commands, each consisting of a single character:

Character ->	Meaning

`>` 	 ->       increment the data pointer (to point to the next cell to the right).

`<` 	 ->       decrement the data pointer (to point to the next cell to the left).

`+` 	 ->       increment (increase by one) the byte at the data pointer.

`-` 	 ->       decrement (decrease by one) the byte at the data pointer.

`.` 	 ->       output a character, the ASCII value of which being the byte at the data pointer.

`,` 	 ->       accept one byte of input, storing its value in the byte at the data pointer.

`[` 	 ->       if the byte at the data pointer is zero, then instead of moving the instruction pointer forward to the next command, jump it forward to the command after the matching]command*.

`]` 	 ->       if the byte at the data pointer is nonzero, then instead of moving the instruction pointer forward to the next command, jump it back to the command after the matching[command*.

Any other character contributes to for a spurious string and is ignored.

## To start the execution:
Type in terminal:
-   `sbt`
-   `run file.txt`