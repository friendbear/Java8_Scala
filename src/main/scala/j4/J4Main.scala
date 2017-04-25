package j4

import java.util.Arrays

/**
  * Created by kumagai on 2017/04/24.
  */
object J4Main extends App {

  val array = Array(1,1,3,5,12)

  val newArray = Arrays.copyOf(array, 4)

  println(newArray)

  val scalaNewArray = new Array(5)
  Array.copy(array, 0, scalaNewArray, 0, 4)
  println(scalaNewArray.toString)
}
