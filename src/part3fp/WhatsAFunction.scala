package part3fp

object WhatsAFunction extends App{
  // DREAM: use functions as first class elements
  // problem: oop

  val doubler = new MyFunction[Int,Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  // function types = Function1[A,B]

  val stringToIntConverter = new Function[String,Int] {
    override def apply(v1: String): Int = v1.toInt
  }

  println(stringToIntConverter("12") + 7)

  val adder = new Function2[Int,Int,Int]{
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  println(adder(1,2))

  val adder2: (Int, Int) => Int = new Function2[Int,Int,Int]{
    override def apply(v1: Int, v2: Int): Int = v1 * v2
  }

  // Function types Function2[A, B, R] === (A,B) => R
  // ALL SCALA FUNCTIONS ARE OBJECTS


  // 1. a function which takes 2 strings and concatenates them
  val concate: ((String,String) => String) = new Function2[String,String,String] {
    override def apply(v1: String, v2: String): String = v1.concat(v2)
  }

  println(concate("Uno", "Dos")) // UnoDos

  // Function1[Int, Function1[Int,Int]]
  val superAdder: Int => (Int => Int) = new Function1[Int, Function1[Int,Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val adder3 = superAdder(3)
  println(adder3(4))

  println(superAdder(5)(4)) // Curried Function



}

trait MyFunction[A, B] {
  def apply(element: A):B
}
