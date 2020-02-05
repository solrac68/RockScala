package lectures.part2.oop

object OOBasicsExcercise extends App {

  val writer = new Writer("Carlos","Augusto",40)
  val novel = new Novel("Los imperios ficticios de la tierra",2019,writer)
  novel.authorAge()
  val isWritter = novel.isWrittenBy(new Writer("Robert","Larson",29))
  println(isWritter)
  val novel2 = novel.copy(2050)
  println(novel2.author.fullName())

}

class Writer(val firstName: String, val secondName: String, val year: Int){
  def fullName():String = s"${this.firstName} ${this.secondName}"
}

class  Novel(val name: String, val yearOfRelease: Int, val author: Writer ){
  def authorAge():Unit = println(s"Edad del autor ${this.author.year}")
  def isWrittenBy(author: Writer):Boolean = this.author.fullName() == author.fullName()
  def copy(newYear:Int): Novel =  new Novel(this.name,newYear,this.author)
}
