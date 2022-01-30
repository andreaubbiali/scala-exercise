Desk is a pretty easy language thought to stress some parsers capabilities sine it relies on absolutely
non  circular  attribute  grammars.  But  doesn't  matter  if  you  don't  know  what  this  implies  since  the
language  is  really  simple.  It  is  an  evaluator  of  expressions  with  literals  and  variables  whose  only
available operation is the sum on integers.

Any desk program has the form:

<code>
    PRINT <<expression>> WHERE <<variable inizialization>>
<code>

Please note that the variable initialization is done through the = symbol and can be related to several
variables, each assigment is comma-separated.
The exercise consists of implementing a DSL by using parser combinator techniques that can parse and
execute Desk programs.

The following is an example of expected behavior

<code>
    print x+y+z+1+x+-3 where x = 25, y = 1, z=-7
</code>

<code>
    [10:29]cazzola@surtur:~/lp/scala>scala DeskEvaluator test.desk
            42
            Map(z -> -7, y -> 1, x -> 25)]
</code>