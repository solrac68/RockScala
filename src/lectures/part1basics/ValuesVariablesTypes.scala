package lectures.part1basics

object ValuesVariablesTypes extends App{
  //val x: Int = 45 //vals are immutable
  val x = 45 //vals are immutable, compila can infer types
  println(
    x
  )

  val aString: String = "hello"
  println(aString)
  val otherString = "Scala"
  println(otherString)
  val aBoolean:Boolean = false
  val aChar:Char = 'a'
  val anInt: Int = x
  val aLong:Long = 81273621836l
  val aFloat:Float = 2.9f
  val aDouble: Double = 3.14

  // variables
  var aVariable:Int = 4 // mutable type
  aVariable =9
  aVariable =10
}
