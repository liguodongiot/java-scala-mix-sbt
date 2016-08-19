package scalacookbook.chapter17

/**
  * Created by liguodong on 2016/8/19.
  */
object UseOtherAnno {

  //Use the Scala @SerialVersionUID annotation while also
  // having your class extend the Serializable trait
  @SerialVersionUID(1000L)
  class Foo extends Serializable {
    // class code here
  }

  //Discussion

  // Scala code and Java code are equivalent

  // scala
  @remote trait Hello {
    def sayHello(): String
  }
  // java
  /*
  public interface Hello extends java.rmi.Remote {
    String sayHello() throws java.rmi.RemoteException;
  }
  */




}


