package lectures.part2.oop

object OOBasicCount extends App {
  var counter = new Counter
  counter.print
  counter.inc.inc.print
  //counter.inc(5).print
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
