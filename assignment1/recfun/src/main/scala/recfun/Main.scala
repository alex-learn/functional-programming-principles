package recfun
import common._
import scala.collection.immutable.Stack

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    (0 /: chars) {
      case (unbalanced, char) =>
        if (unbalanced == -1) unbalanced
        else
          char match {
            case '(' => unbalanced + 1
            case ')' => if (unbalanced == 0) -1 else unbalanced - 1
            case _ => unbalanced
          }
    } == 0
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int =
    money match {
      case 0 => 1
      case _ if money < 0 || coins.isEmpty => 0
      case _ => countChange(money - coins.head, coins) + countChange(money, coins.tail)
    }

}
