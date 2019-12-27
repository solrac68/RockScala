package lectures.part2.oop

object OOBasicsExcercise extends App {

  val writer = new Writer("Carlos","Augusto",40)
  val novel = new Novel("Los imperios fictisos de la tierra",2019,writer)
  novel.authorAge()
  val isWritter = novel.isWrittenBy(new Writer("Robert","Larson",29))
  println(isWritter)
  val novel2 = novel.copy(2050)
  println(novel2.author.fullName())

  var counter = new Counter
  counter.print
  counter.inc.inc.print
  counter.inc(5).print

}

class Writer(val firstName: String, val secondName: String, val year: Int){
  def fullName():String = s"${this.firstName} ${this.secondName}"
}

class  Novel(val name: String, val yearOfRelease: Int, val author: Writer ){
  def authorAge():Unit = println(s"Edad del autor ${this.author.year}")
  def isWrittenBy(author: Writer):Boolean = this.author.fullName() == author.fullName()
  def copy(newYear:Int): Novel =  new Novel(this.name,newYear,this.author)
}


class Counter(val count: Int = 0){
  def inc = {
    println("Incrementing")
    new Counter(count + 1) // Immutability
  }

  def dec = {
    println("decrementing")
    new Counter(count - 1)
  }

  def inc(n:Int):Counter = {
    if (n <= 0) this
    else inc.inc(n-1)
  }

  def dec(n:Int):Counter = {
    if(n <= 0) this
    else dec.dec(n-1)
  }

  def print = println(count)

}
