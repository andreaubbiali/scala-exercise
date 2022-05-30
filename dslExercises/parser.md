### utils information creating DSL

`~>`                  = we are not interested on the result on parser of left part.

`<~`                  = discard the right side

`^^`                  = is a combinator for transforming parser result.

`|`                   = defines alternatives.

`()`                  = brackets wrap a part of parser into kind of “sub-parser”

`something.+`         = quantifier, requires underlying parser to match at least once. Returns Seq[] of what underlying parsers return.

`something.*` or `rep(something)`   = match zero or more times.

`rep1sep(something, separatorChar)`  = match something zero or more times, separated by separatorChar.

`something.?`           = match something zero or 1 time, returns Option.       

`something1 ~ something2`   = combines a parsers into a chain, every parser must match successfully and every parser result is preserved. Returns a special data structure that can be deconstructed with the same character ~ in pattern matching part

`"""\w+""".r`       = alphanumerical character and the underscore (so essentially A through Z, 0 through 9 and _). Spaces however are their own group (represented by \s)

`"""[\w+]""".r`     = one letter
