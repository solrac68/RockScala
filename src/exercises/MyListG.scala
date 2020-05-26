package exercises

abstract class MyListG[+A] {
  /*
    head = first element of the list
    tail = remainder of the list
    isEmpty = is this list empty
    add(int) => return a new list with this element added
    toString => a string of representation of the list
   */
  def head :A
  def tail:MyListG[A]
  def isEmpty:Boolean
  def add[B >: A]( data:B):MyListG[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"


  // higher-order functions
  //def map[B](transformer: MyTransformer[A,B]):MyListG[B]
  def map[B](transformer: A => B):MyListG[B]
  //def flatMap[B](transformer:MyTransformer[A,MyListG[B]]):MyListG[B]
  def flatMap[B](transformer:A => MyListG[B]):MyListG[B]
  //def filter(predicate:MyPredicate[A]):MyListG[A]
  def filter(predicate:A => Boolean):MyListG[A]

  // Concatenation
  def ++[B >: A](list: MyListG[B]):MyListG[B]

  //
}

case object Empty extends MyListG[Nothing] {
  def head :Nothing = throw new NoSuchElementException
  def tail: MyListG[Nothing] = throw new NoSuchElementException

  def isEmpty:Boolean = true

  def add[B >: Nothing](data:B):MyListG[B] = new Cons(data, Empty)

  override def printElements: String = ""

  //def map[B](transformer: MyTransformer[Nothing,B]):MyListG[B] = Empty
  def map[B](transformer: Nothing => B):MyListG[B] = Empty

  //def flatMap[B](transformer:MyTransformer[Nothing,MyListG[B]]):MyListG[B] = Empty
  def flatMap[B](transformer:Nothing => MyListG[B]):MyListG[B] = Empty

  //def filter(predicate:MyPredicate[Nothing]):MyListG[Nothing] = Empty
  def filter(predicate:Nothing => Boolean):MyListG[Nothing] = Empty

  def ++[B >: Nothing](list: MyListG[B]):MyListG[B] = list
}

case class Cons[+A](h: A, t: MyListG[A]) extends MyListG[A] {
  def  head = h
  def tail: MyListG[A] = t

  def isEmpty:Boolean = false

  def add[B >: A]( data:B):MyListG[B] = new Cons(data, this)

  override def printElements: String =
    if(t.isEmpty) "" + h
    else h + " " + t.printElements

  /*
    [1,2,3].filter(n % 2 == 0) =
    [2,3].filter(n % 2 == 0) =
    new Cons(2,[3].filter(n % 2 == 0)) =
    new Cons(2, Empty.filter(n % 2 == 0)) =
    new Cons(2, Empty) =
   */
  //override def filter(predicate: MyPredicate[A]): MyListG[A] = {
  override def filter(predicate: A => Boolean): MyListG[A] = {
    if(predicate.apply(h)) new Cons(h,t.filter(predicate))
    else t.filter(predicate)
  }

  /*
    [1,2,3].map(n * 2)
      = new Cons(2, [2,3].map(n * 2))
      = new Cons(2, new Cons(4,[3].map(n * 2)))
      = new Cons(2, new Cons(4, new Cons(6, Empty.map(n*2))))
      = new Cons(2, new Cons(4, new Cons(6, Empty)))
   */
  override def map[B](transformer: A => B): MyListG[B] = {
    new Cons(transformer.apply(h), t.map(transformer))
  }

  /*
    [1,2].flatMap(n => [n,n+1])
    = flatMap(1 => [1,1+1]) ++ [2].flatMap(2 => [2,2+1])
    = [1,2] ++ [2,3] ++ Empty.flatMap(n => [n,n+1])
    = [1,2] ++ [2,3] ++ Empty
   */
  override def flatMap[B](transformer: A => MyListG[B]): MyListG[B] =
    transformer.apply(h) ++ t.flatMap(transformer)

  /*
    [1,2] ++ [3,4,5]
    = new Cons(1, [2] ++ [3,4,5])
    = new Cons(1, new Cons(2, Empty ++ [3,4,5]))
    = new Cons(1, new Cons(2,[3,4,5]))
    = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5)))))

   */
  override def ++[B >: A](list: MyListG[B]): MyListG[B] = new Cons(h, t ++ list)
}

//trait MyPredicate[-T]{
//  def test(element: T):Boolean
//}

//trait MyTransformer[-A,B]{
////  def transform(element:A): B
////}

object ListTestG extends App {
  val listOfIntegers:MyListG[Int] = new Cons(1, new Cons(2, new Cons(3,Empty)))
  val anotherlistOfIntegers:MyListG[Int] = new Cons(4, new Cons(5, Empty))
  val listOfStrings:MyListG[String] = new Cons("Uno", new Cons("Dos",new Cons("Tres", Empty)))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)

//  println(listOfIntegers.map(new Function1[Int,Int] {
//    override def apply(elem: Int): Int = elem * 3
//  }).toString)

  println(listOfIntegers.map((x:Int) => 3*x).toString)
  println(listOfIntegers.map(_ * 3).toString)


//  println(listOfIntegers.filter(new Function1[Int,Boolean] {
//    override def apply(element: Int): Boolean = element % 2 == 1
//  }).toString)

  println(listOfIntegers.filter((elem: Int) => elem % 2 == 1).toString)
  println(listOfIntegers.filter(_ % 2 == 1).toString)


  println((listOfIntegers ++ anotherlistOfIntegers).toString)

  println(listOfIntegers.flatMap(new Function1[Int,MyListG[Int]] {
    override def apply(elem: Int): MyListG[Int] = new Cons(elem, new Cons(elem + 1, Empty))
  })).toString

  println(listOfIntegers.flatMap(elem => new Cons(elem,new Cons(elem + 1,Empty))).toString)

}
