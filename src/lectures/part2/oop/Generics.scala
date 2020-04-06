package lectures.part2.oop

object Generics extends App{
  class MyList[+A]{
    def add[B >: A](element: B): MyList[B] = ???
    // use the type A
  }

  class MyMap[key, value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[String]

  class Animal

  class Cat extends Animal
  class Dog extends Animal

  //1. yes List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ??? HARD QUESTION

  //2. NO = INVARIANCE
  class InvariantList[A]
  //val invariantAnimalList:InvariantList[Animal] = new InvariantList[Cat] Not is Possible
  val invariantAnimalList:InvariantList[Animal] = new InvariantList[Animal] //OK

  //3. Hell, no! Contravariance
  class Trainer[-A]
  val trainer:Trainer[Cat] = new Trainer[Animal]

  //4: Bounded types
  class Cage[A <: Animal](animal: A) // Clase con parámetro A con la restricción que debe ser un subtipo de Animal.
  val cage = new Cage(new Dog)

  class Car
  //val newCage = new Cage(new Car) //No es posible





}
