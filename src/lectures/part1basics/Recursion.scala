package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n:Int):Int =
    if (n <= 1) 1
    else n * factorial(n - 1)

  def anotherFactorial(n:BigInt):BigInt = {
    @tailrec
    def factHelper(x:BigInt, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x -1,x * accumulator) // Tail recursion
    factHelper(n,1)
  }
  //println(anotherFactorial(100))

  // when you need loops, use _tail_ recursion

  /*
    1.  Concatenate a String in n times
    2.  IsPrime function tail recursive
    3.  Fibonacci function, tail recursive
   */

  def concat(str: String, n:Int):String = {
    def concatHelper(str: String, accumulator: String, n: Int):String =
      if(n <= 0) accumulator
      else concatHelper(str,str + accumulator, n -1)
    concatHelper(str,"",n)
  }

  //println(concat("Hola",5))

  def fibo(n: Int):Int = {
    def fiboHelper(i: Int, last: Int, nextLast: Int):Int =
      if(i >= n) last
      else fiboHelper(i + 1, last + nextLast, last)
    if(n <= 2) 1
    else fiboHelper(2,1,1)
  }

  println(fibo(4))
}

