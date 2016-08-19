package scalacookbook.chapter16

import java.sql.{Connection, DriverManager}

/**
  * Created by liguodong on 2016/8/19.
  */


object ScalaJdbcConnectSelect extends App {
  // connect to the database named "mysql" on port 8889 of localhost
  val url = "jdbc:mysql://192.168.133.147:3306/liguodong"
  val driver = "com.mysql.jdbc.Driver"
  val username = "root"
  val password = "123"
  var connection:Connection = _
  try {
    Class.forName(driver)
    connection = DriverManager.getConnection(url, username, password)
    val statement = connection.createStatement
    val rs = statement.executeQuery("SELECT stu_name, stu_age FROM student_info")
    while (rs.next) {
      val stu_name = rs.getString("stu_name")
      val stu_age = rs.getString("stu_age")
      println("stu_name = %s, stu_age = %s".format(stu_name,stu_age))
    }
  } catch {
    case e: Exception => e.printStackTrace
  }
  connection.close
}