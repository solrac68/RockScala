package lectures.part2.oop

object Objects {
  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCIONALITY ("static")
  object Person { // type is only instance
    // "static"/"class" - level funcionality
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  class Person(val name: String){
    // Instance-level Funcionality
  }
  //COMPANION

  def main(args: Array[String]): Unit = {
    println(Person.N_EYES)
    println(Person.canFly)

    // SCALA OBJECT IS A SINGLENTON INSTANCE
    val mary = new Person("Mary")
    val john = new Person("John")
    println(s"mary == john es ${(mary == john)}")

    val person1 = Person
    val person2 = Person
    println(s"person1 == person2 es ${(person1 == person2)}")

    val bobbie = Person(mary, john)

    // Scala Applications = Scala object with
    // def main(args: Array[String]): Unit
  }
}
