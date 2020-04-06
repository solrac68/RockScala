package lectures.part2.oop

object CaseClasses extends  App{

  case class Person(name: String, age: Int)
  // 1. class parameters are fields
  val jim = new Person(name = "Jim", age = 25)
  println(s"Name: ${jim.name} Edad: ${jim.age}")

  // 2. Sensible toString
  // println(instance) = println(instance.toString)
  println(jim)

  // 3. equals and hashCode implemented OOTB
  val carlos = new Person("Carlos", 30)
  val jim2 = new Person(name = "Jim", age = 25)

  println(jim == jim2) // Return true

  // 4. CCs have handy copy method
  val jim3 = jim.copy(age = 29)
  println(jim3) // Person(Jim,29)

  // 5. CCs have companion objects
  val theperson = Person(name = "Juan", age = 25)
  println(theperson) // Person(Juan,25)

  //6. CCs are serializable
  //Akka

  //7. CCs have extractor patterns = CCs can be used  in PATTERN MATCHING

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }
  



}
