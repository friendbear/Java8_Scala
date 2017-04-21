/**
  * Created by kumagai on 2017/04/21.
  */
import org.scalatest.FunSuite

class HelloWorldTest extends FunSuite {
  test("Hello, <引数> という文字列が返ってくる") {
    val hello = new Hello()
    assert(hello.sayHello("Kumagai").contains("Scala"))
  }
}
