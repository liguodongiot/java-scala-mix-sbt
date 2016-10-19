package scalacookbook.chapter04

/**
 * Created by liguodong on 2016/7/3.
 */

object UseAbstractClass extends App{
  //两个原因使用抽象类。
  //1、创建一个基类有构造参数（特质不允许有构造参数）
  //2、代码将从Java代码中调用

  // this won't compile
  //trait Animal(name: String)

  abstract class Animal(name: String)

  //Discussion
  class Database{
    def save = println("save")
    def update = println("update")
    def delete = println("delete")
  }

  abstract class BaseController(db: Database) {
    def save { db.save }
    def update { db.update }
    def delete { db.delete }

    // abstract
    def connect

    // an abstract method that returns a String
    def getStatus: String

    // an abstract method that takes a parameter
    def setServerName(serverName: String)
  }

  class WidgetController(db: Database) extends BaseController(db){
    // abstract
    override def connect: Unit = println("connect")

    // an abstract method that returns a String
    override def getStatus: String = {println("getStatus");"getStatus"}

    // an abstract method that takes a parameter
    override def setServerName(serverName: String): Unit = println("setServerName")
  }

  val db = new Database
  val widgetController = new WidgetController(db)
  widgetController.connect
  widgetController.getStatus
  widgetController.setServerName("liguodong")
  widgetController.delete
  widgetController.save
  widgetController.update

}
