package lectures.part2.oop

object MethodNotation extends App{
  class Person(val name: String, favoriteMovie: String, age:Int = 20){
    def likes(movie: String):Boolean = movie == favoriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, what the heck?!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi my name is $name and I like $favoriteMovie"
    def apply(twist:Int): String = s"$name watched $twist $favoriteMovie"
    def +(nickName: String): Person = new Person(s"${this.name} (${nickName})",favoriteMovie)
    def unary_+ : Person = new Person(this.name, this.favoriteMovie, age + 1)
    def print(): Unit = println(s"Name is $name, favoriteMovie is $favoriteMovie, age: $age")
  }

  val mary = new Person("Mary","Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent

  val tom = new Person("Tom","Fight Club")
  println(mary + tom)
  println(mary.+(tom)) // Idem to +

  println(1 + 2)
  println(1.+(2)) // Idem to +
    // Infix notation = operator notation (syntactic sugar)
    //All operators are methods

  // prefix notation
  val x = -1 // equivalent 1.unary_-
  val y = 1.unary_-

  // unary_ prefix only works with - + ~ !
  println(!mary) // print "Mary, what the heck?!"
  println(mary.unary_!) // print "Mary, what the heck?!"

  // postfix notation
  //println(mary.isAlive)
  //println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary()) // same effect that mary.apply()

  //println(mary.+("La lectora"))

  println((mary + "La aviona")()) // Hi my name is Mary (La aviona) and I like Inception

  mary.print()
  (+(+mary)).print()

  println(mary(3))



}
