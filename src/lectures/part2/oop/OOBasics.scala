package lectures.part2.oop

object OOBasics extends App {
  val person = new Person("Carlos",30)
  println(person)

  val person2 = new Person2("Carlos",41)
  println(person2.age)
  println(person2.x)
  person2.greet("John")
  person2.greet()

  val person21 = new Person2("Arthur")
  println(person21.age)

  val person22 = new Person2()
  person22.greet()
}

class Person(name: String, age: Int) // Constructor
// class parameters are NOT FIELDS

// Constructor, class parameters have age how FIELDS (val)
class Person2(name: String, val age: Int = 0){
  // body
  val x = 2
  println(1 + 3)

  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")
  // overloading
  def greet(): Unit = println(s"Hi, I am ${this.name}")
  // multiple constructors
  def this(name:String) = this(name,0)
  def this() = this("Andres")
}
