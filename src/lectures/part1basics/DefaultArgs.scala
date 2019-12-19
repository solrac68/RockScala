package lectures.part1basics

object DefaultArgs extends App {
  def trFact(n: Int, acc: Int = 1): Int =
    if(n <= 1) acc
    else trFact(n-1,n*acc)

  val fact10 = trFact(10) // Toma el valor 1 para el parametro acc

  println(s"El factorial de 10: $fact10")

  val fact102 = trFact(10,2) // Toma el valor 2 para el parametro acc

  println(s"El factorial de 10 ?: $fact102")

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080):Unit = println(s"Formato : $format, Ancho: $width, Alto: $height")

  savePicture() // Toma todos los valores por defecto: Formato : jpg, Ancho: 1920, Alto: 1080
  savePicture(width = 800) // Reemplaza el valor por defecto de width por 800: Formato : jpg, Ancho: 800, Alto: 1080
  savePicture(width = 800,height = 600) // Reemplaza el valor por defecto de width por 800 y height: Formato : jpg, Ancho: 800, Alto: 600
  savePicture(height = 600, width = 800, format = "png") // Formato : png, Ancho: 800, Alto: 600

}
