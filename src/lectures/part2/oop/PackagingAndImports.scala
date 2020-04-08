package lectures.part2.oop

import java.sql
import java.sql.SQLData

import playground.{PrinceCharming, Cinderella => Princess}
//import playground._

import java.util.Date
import java.sql.{Date => SqlDate}

object PackagingAndImports extends App{

  // Import the package
  val princess = new Princess // import playground.{Cinderella => Princess}
  val princess2 = new playground.Cinderella // fully qualified name

  // packages are in hierarchy
  // matching folder structure

  // package object
  sayHello
  println(SPEED_OF_LIGHT)

  // Imports
  // import playground.{Cinderella, PrinceCharming} or
  // import playground._
  val prince = new PrinceCharming

  val date = new Date() // take from import java.util.Date
  // 1. use FQ names
  val sqlDate = new java.sql.Date(2019)
  val sqlDate2 = new SqlDate(2020) // take import java.sql.{Date => SqlDate}

  // 2. use aliasing
  // defaults imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???




}
