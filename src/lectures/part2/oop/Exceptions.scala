package lectures.part2.oop

object Exceptions extends App {
  val x:String = null
  //println(x.length)
  // this ^^ will crash with NPE
  // 1. throwing and catching exceptions

  //val aWeirdValue: String = throw new NullPointerException

  //Trowable classes extend the Trowable class.
  //Exception and Error are de mayor Throwable subtypes

  // 2. How to catch exceptions
  def getInt(withExceptions: Boolean): Int =
    if(withExceptions) throw new RuntimeException("No int for you")
    else 97

  val potentialFail = try {
    getInt(true)
  } catch {
    //case e: RuntimeException => println("caught a RuntimeExceptions")
    case e: RuntimeException => 52
    case e: NullPointerException => println("caught a NullPointerException")
  } finally {
    // code that will get execute NO MATTER WHAT HAPPEN
    // optional
    // does not influence the return type of this expressions
    // use finally only for side effects
    println("finally")
  }

  println(potentialFail) // Print 52

  // 3. How to define your own exceptions
  class MyException extends Exception

  val exception = new MyException

  //throw exception // Exception in thread "main" lectures.part2.oop.Exceptions$MyException

  /*
    1. Crash your program with an OutOfMemoryError
    2. Crash with SOError
    3. PocketCalculator
        - add(x,y)
        - subtract(x,y)
        - multiply(x,y)
        - divide(x,y)

        Throw
          - OverflowException if add(x,y) exceeds Int.MAX_VALUE
          - UnderflowException if substract(x,y) exceeds Int.MIN_VALUE
          - MathCalculationException for division by 0
   */

    // OOM
    // val array = Array.ofDim(Int.MaxValue)

    // SO
    def infinite: Int = infinite + 1

    //val noLimit = infinite

    class OverflowException extends RuntimeException
    class UnderflowException extends RuntimeException
    class MathCalculationException extends RuntimeException("Division by cero!!")
    object PocketCalculator{
      def add(x: Int, y: Int) = {
        val result = x + y
        if(x > 0 && y > 0 && result < 0) throw new OverflowException
        else if(x < 0 && y < 0 && result > 0) throw new UnderflowException
        else result
      }

      def div(x:Int, y:Int) = {
        if (y == 0) throw new MathCalculationException
        else x / y
      }
    }

    //println(PocketCalculator.add(Int.MaxValue,10))
    println(PocketCalculator.div(10,0))





}
