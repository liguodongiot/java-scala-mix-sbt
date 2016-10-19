package scalacookbook.chapter04

import org.scalatest.{BeforeAndAfter, FunSuite}

/**
  * Created by liguodong on 2016/9/8.
  */
class EmployeeTests extends FunSuite with BeforeAndAfter {
  import section15._

  // these first two instance should be equal
  val eNimoy1 = new Employee("Leonard Nimoy", 82, "Actor")
  val eNimoy2 = new Employee("Leonard Nimoy", 82, "Actor")
  val pNimoy = new Person("Leonard Nimoy", 82)
  val eShatner = new Employee("William Shatner", 82, "Actor")
  test("eNimoy1 == eNimoy1") { assert(eNimoy1 == eNimoy1) }
  test("eNimoy1 == eNimoy2") { assert(eNimoy1 == eNimoy2) }
  test("eNimoy2 == eNimoy1") { assert(eNimoy2 == eNimoy1) }

  test("eNimoy != pNimoy") { assert(eNimoy1 != pNimoy) }
  test("pNimoy != eNimoy") { assert(pNimoy != eNimoy1) }


}
