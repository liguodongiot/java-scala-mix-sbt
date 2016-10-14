package databrickstandard.syntaxstyle.brackets

/**
  * Created by liguodong on 2016/10/14.
  */

object Main extends App{

  println(new Bar().foo)  // This returns a Foo

  //错误
  println(new Bar().foo())  // This returns an Int!


}

class Foo {
  def apply(args: String*): Int = {
    args.length
  }
}

class Bar {
  def foo: Foo = new Foo
}
