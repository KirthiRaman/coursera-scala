package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")

    for (row <- 0 to 12) {

      // leading spaces depend on max row
      for(spc <- 0 to 12-row)
        print("  ")

      // formatting is required to make the numbers 
      // look like a triangle (centered) %4d only works upto certain row
      for (col <- 0 to row){
        print("%4d ".format(pascal(col,row)))
      }

      println()
    }

    print(balance("(if (zero? x) max (/ 1 x))".toList))
    println()
    print(balance("())(".toList))
    println()

    val inplist: List[Int] = List(1,2,3);
    println(countChange(9,inplist));
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
     var b = 1
     if ( r <= 2 ){
        if ( (r == 2) && (c == 1) ) b = 2;
     } else {
        if ( (c != 0) && (r != c) ){
          val b1=pascal(c-1,r-1)
          val b2 = pascal(c, r-1)
          b = b1 + b2
        } 
     }
     b
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
     var bal = true

     if ( !chars.isEmpty ){
        val len = chars.length
        var count=0
        var i=0
        while ( i < len && bal ){
             if ( chars(i) == '(' )  count += 1
             else if ( chars(i) == ')' ) {
               if ( count > 0 )  
                 count -= 1
               else 
                 bal = false
             }
             i += 1
        }
     }   
    bal
  }
  
  /**
   * Exercise 3
   */  
  // Nested function is a perfect choice (at least to me while I am learning)
  // for this example
  def countChange(money: Int, coins: List[Int]) : Int = {
    var count: Int = 0
    def changePartition(money: Int, maxchange: Int, pattern: String, coins: List[Int]): Unit = {
       if (money == 0) {
            println(pattern);
            count += 1;
       } else {
         for (i <- math.min(maxchange, money) to 1 by -1) {
            if ( coins.contains(i) ){  // don't know how expensive this lookup might be (can coins be a set?)
              changePartition(money-i, i, pattern+" " +i, coins);
            }
         }
       }
    }
    changePartition(money, money, "", coins)
    count
  }
 
}
