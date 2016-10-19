package scalacookbook.chapter09

/**
  * Created by liguodong on 2016/7/24.
  */
object AReadExample {

  def main(args: Array[String]) {
    driver
  }

  /**
  * A "driver" function to test Newton's method.
  * Start with (a) the desired f(x) and f'(x) equations（开始希望f(x) 和 f'(x)相等）,
  * (b) an initial guess(最初的猜测) and (c) tolerance values（公差值）.
  */
  def driver {
    // the f(x) and f'(x) functions
    val fx = (x: Double) => 3*x + math.sin(x) - math.pow(math.E, x)

    //上面方程的导数
    val fxPrime = (x: Double) => 3 + math.cos(x) - math.pow(Math.E, x)

    val initialGuess = 0.0    //最初假设
    val tolerance = 0.00005   //公差值

    // pass f(x) and f'(x) to the Newton's Method function, along with
    // the initial guess and tolerance
    val answer = newtonsMethod(fx, fxPrime, initialGuess, tolerance)
    println("answer : "+answer)
  }

  /**
    * Newton's Method for solving equations.（牛顿求解方程的方法）
    *
    * 两个函数分别传递原方程（FX）和方程的导数
    * @todo check that |f(xNext)| is greater than a second tolerance value
    * @todo check that f'(x) != 0
    */
  def newtonsMethod(
      fx: Double => Double,
      fxPrime: Double => Double,
      x: Double,
      tolerance: Double)
    : Double = {

    var x1 = x

    var xNext = newtonsMethodHelper(fx, fxPrime, x1)

    while (math.abs(xNext - x1) > tolerance) {
      x1 = xNext
      println(xNext) // debugging (intermediate values)
      xNext = newtonsMethodHelper(fx, fxPrime, x1)
    }
    xNext
  }

  /**
    * This is the "x2 = x1 - f(x1)/f'(x1)" calculation
    */
  def newtonsMethodHelper(
      fx: Double => Double,
      fxPrime: Double => Double,
      x: Double)
    : Double = {
    x - fx(x) / fxPrime(x)
  }

}