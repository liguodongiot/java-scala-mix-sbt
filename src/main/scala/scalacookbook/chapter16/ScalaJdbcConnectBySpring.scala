package scalacookbook.chapter16

import org.springframework.context.support.ClassPathXmlApplicationContext
import org.springframework.jdbc.core.support.JdbcDaoSupport


/**
  * You want to connect to a database using the Spring Framework.
  * This gives you a nice way to add connection pooling and
  * other capabilities to your SQL code.
  *
  * Created by liguodong on 2016/8/19.
  */

object ScalaJdbcConnectBySpring extends App{

  // read the application context file
  val ctx = new ClassPathXmlApplicationContext("scalacookbook/ApplicationContext-db.xml",
    "scalacookbook/ApplicationContext-dao.xml")

  // get a testDao instance
  val userDao = ctx.getBean("userDao").asInstanceOf[UserDao]

  val numUsers = userDao.getNumUsers
  println("You have this many users: " + numUsers)

}



class UserDao extends JdbcDaoSupport{
  def getNumUsers: Int = {
    val query = "select count(1) as num from student_info"
    val result = getJdbcTemplate.queryForMap(query)
    return  result.get("num").asInstanceOf[Long].toInt
  }
}