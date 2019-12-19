package lectures.part1basics

object StringOps extends App{
  val str: String = "Hello, I am Learning Scala"
  println(s"Posicion 0 de $str: " + str.charAt(0))
  println(s"Posicion 1 de $str: " + str.charAt(1))
  println(s"Posicion 2 de $str: " + str.charAt(2))

  println(str.substring(7,11)) // I am
  println(str.split(" ").toList) // List(Hello,, I, am, Learning, Scala)
  println(str.startsWith("Hello")) // True
  println(str.replace(" ","-")) // Hello,-I-am-Learning-Scala
  println(str) // Hello, I am Learning Scala
  println(str.toLowerCase())
  println(str) // Hello, I am Learning Scala
  println(str.length) // 26

  val aNumberString = "45"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z') // a45z
  println(str.reverse) // alacS gninraeL ma I ,olleH
  println(str.take(2)) // He

  // Scala specific Interpolations

  // S-interpolators
  val name = "Carlos"
  val age = 12
  val greeting = s"Hello, my name is $name I am $age years old"
  println(greeting)

  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old"
  println(anotherGreeting)

  // F-interpolators
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute"
  println(myth) //Carlos can eat 1.20 burgers per minute

  // raw-interpolators
  println(raw"This is a \n newline ") //This is a \n newline
  println("This is a \n newline ") //This is a
                                   //  newline
  val escaped = "This is a \n newline"
  println(raw"$escaped") //This is a
                         //  newline
}
