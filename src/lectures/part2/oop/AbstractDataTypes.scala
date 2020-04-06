package lectures.part2.oop

object AbstractDataTypes extends App{
  // abstract
  abstract  class Animal {
    val creatureType: String = "Wild"
    def eat: Unit
  }
  //val animal = new Animal No se puede  implementar una clase abstracta

  class Dog extends Animal {
    override val creatureType: String = "Perro"
    def eat: Unit = println("LLom  LLom") // Igual con override
  }

  val dog = new Dog
  println(dog.creatureType)
  dog.eat

  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh Meat"
  }

  trait ColdBloded

  class Crocodrile extends Animal with Carnivore with ColdBloded {
    override val creatureType: String = "croc"
    def eat: Unit = println("NonNom")
    def eat(animal: Animal):Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }


  val croc = new Crocodrile
  croc.eat(dog)
  croc.eat

  // traits vs abstract classes
  // 1 - traits do not have constructor parameters
  // 2 - Multiple traits may be inherited by the same class, but only one abstract class can be inherited
  // 3 - traits = behaviour, abstract class is type of "thing"
}
