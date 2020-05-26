package part3fp

object AnonymousFunctions extends App{
  val doubler = new Function[Int, Int] {
    override def apply(x: Int): Int = 2*x
  }

  //AnonymousFunctions (LAMBDA)
  val doubler2 = (x: Int) => x * 2

  val doubler3: Int => Int = (x: Int) => x * 2

  // Shorthand notations
  val doubler4: Int => Int = x => x * 2


  println(doubler(2)) // 4
  println(doubler2(2)) // 4
  println(doubler3(2)) // 4
  println(doubler4(2)) // 4

  // Multiple params in a lambda
  val adder = (a: Int, b: Int) => a + b
  val adder2: (Int,Int) => Int = (a, b) => a + b

  println(adder(2,2)) // 4
  println(adder2(2,2)) // 4

  // no params
  val justDoSomething = () => 2
  val justDoSomething2: () => Int = () => 2
  println(justDoSomething()) // 2
  println(justDoSomething2()) // 2

  // curly braces with lambda
  val stringToInt = { (str: String) =>
    str.toInt
  }

  println(stringToInt("2") + 2) // 4

  // MOAR syntactic sugar
  val incrementer: Int => Int = (x: Int) => x + 1
  println(incrementer(2)) // 3

  val niceIncrementer: Int => Int = _ + 1
  val niceAdder: (Int, Int) => Int = _ + _
  println(niceIncrementer(2)) // 3
  println(niceAdder(2,1)) // 3

  val superAdd = (x: Int) => (y: Int) => x + y

  println(superAdd(3)(4))



}
