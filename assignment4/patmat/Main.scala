package patmat

import common._

object Main extends App {
   import Huffman._
   val sampleTree = makeCodeTree(
    makeCodeTree(Leaf('x', 1),
      Leaf('e', 1)),
    Leaf('t', 2))
    println(sampleTree)

   val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
   val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
   println(t1)
   println(t2)
}
