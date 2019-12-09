package lectures.part1basics

object Functions extends App {
  def aFunction(a:String, b:Int):String =
    a + " " + b

  def aFunction2(a:String, b:Int):String = {
    a + " " + b
  }

  def aFunction3(a:String, b:Int) =
    a + " " + b

  println(aFunction("hOLA",7))
  println(aFunction2("Hi",9))
  println(aFunction2("Hola",19))

  def aParameterlessFunction(): Int = 79

  println(aParameterlessFunction())
  println(aParameterlessFunction) // Ok sin parentesis

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  print(aRepeatedFunction("Duque",5))

  // WHEN YOU NEED A LOOP, USE RECURSION

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  aFunctionWithSideEffects("Andres")

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b
    aSmallerFunction(n, n - 1)
  }

  println(aBigFunction(5))

  def greetingKids(name: String, age: Int): Unit = {println(s"Hola mi nombre es $name y mi edad es $age")}

  println(greetingKids("Andres", 14))


  def aFactorial(n:Int):Int = {
    if (n == 0 || n == 1) 1
    else n * aFactorial(n -1)
  }

  println(aFactorial(0))

  def f(n: Int):Int = {
    if (n == 1 || n == 2) 1
    else (f(n-1) + f(n-2))
  }

  println(f(4))
}
