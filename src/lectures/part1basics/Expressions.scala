package lectures.part1basics

object Expressions extends App {
  val x = 1 +2
  println(x)

  println(1 == x)
  // == != > >= < <=

  println((!(1 == x)))

  var aVariable = 2
  aVariable += 3 // also works with -= *= /=

  println(aVariable)

  // Instructions (DO) vs Expressions (VALUE)

  // IF expressions
  val aCondition = true
  val aConditionValue = if(aCondition) 5 else 4 // IF EXPRESSIONS
  println(aConditionValue)

  var i = 0
  while(i < 10){
    println(i)
    i += 1
  }
  // never write this again

  // Everything in Scala is an Expressions

  val aWeirdValue = (aVariable = 3) // Unit === void

  println(aWeirdValue)

  // side effects: println(), whiles, reassigning

  // Code Block

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if(z > 2) "hello" else "good bye"
  }






}
