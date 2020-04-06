package lectures.part2.oop

object AnonymousClass extends App{
  abstract class Animal {
    def eat: Unit
  }

  val funnyAnimal = new Animal {
    override def eat: Unit = println("Hola")
  }

  class AnonymousC extends Animal {
    override def eat: Unit = println("HaHaHaHAHaHaHaHA")
  }

  funnyAnimal.eat

  val anonymousC:Animal = new AnonymousC

  anonymousC.eat

  println(funnyAnimal.getClass)
  println(anonymousC.getClass)

  class Person(name: String){
    def sayHi:Unit = println(s"Hi, my name is $name, how can I help?")
  }

  val jim = new Person("jim") {
    override def sayHi: Unit = println(s"Hi, my name is jim, how can I be of service")
  }


}
