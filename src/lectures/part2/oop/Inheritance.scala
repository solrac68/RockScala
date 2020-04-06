package lectures.part2.oop

object Inheritance extends App{

  // Single class inheritance
  class Animal {
    val creatureType = "Wild"
    protected def eat = println("nomnom")
    private def drink = println("gluglu")
    final def run = println("runnig") // couldn't override
  }

  class Cat extends  Animal{
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  //cat.eat solo se puede llamar sí es publico

  cat.crunch // nomnom /n crunch crunch

  // Constructors
  class Person(name: String, age: Int){
    def this(name: String) = this(name,0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name,age)
  class Child(name: String, idCard: String) extends Person(name) // Invoca el segundo constructor

  //Overriding
  class Dog(override val creatureType: String) extends Animal {
    //override val creatureType: String = "Domestic"
    override  def eat: Unit = {
      super.eat // Invoca la definición base
      println("Ñame Ñame") // Agrega una nueva acción
    }

    //override def run = println("Yo corro") No es posible el override because run use final
  }

  //Overriding // same override that Dog
  class Duck(duckType: String) extends Animal {
    override val creatureType: String = duckType
  }

  val dog = new Dog("Domestic")
  dog.eat // nomnom
          // Ñame Ñame
  println(dog.creatureType)

  val duck = new Duck(duckType = "SemiDomestic")
  println(duck.creatureType) //SemiDomestic

  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  println(unknownAnimal.creatureType)

  println(unknownAnimal.run)

  // overRIDING vs overLOADING

  // super

  // preventing overrides
  // 1 - use final
  // 2 - use final on the entire Class, this preventing that entering could be extending
  // 3 - seal the class = extend classes in this FILE, prevent extention in other files

  sealed class Figure(alto: Int, ancho: Int)






}
