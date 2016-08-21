package cb005

/**
 *
 * Scala provides these scope options:
    • Object-private scope
    • Private
    • Package
    • Package-specific
    • Public
 *
 *
 * Created by liguodong on 2016/7/4.
 */
object ControlMethodScope extends App{

  class Foo {
    //1 Object-private scope
    private[this] def isFoo = true

    def doFoo(other: Foo) {
      //    if (other.isFoo) { // this line won't compile
      //      // ...
      //    }
    }

    //2 Private
    private def isFoo2 = true
    def doFoo2(other: Foo) {
      if (other.isFoo2) { // this now compiles
        // ...
      }
    }

  }


  //By making a method private, it is not available to subclasses.
  class Animal {
    private def heartBeat {}

    //3 Protected scope
    protected def breathe {}
  }

  class Dog extends Animal {
    //heartBeat // won't compile

    breathe
  }




}





//In Java, protected methods can be accessed by other classes in the same package,
//but this isn’t true in Scala. The following code won’t compile because the Jungle class
//can’t access the breathe method of the Animal class, even though they’re in the same package
package world {
  class Animal {
    protected def breathe {}
  }

  class Jungle {
    val a = new Animal
    //a.breathe // error: this line won't compile
  }
}

//4 Package scope
package com.acme.coolapp.model {
  class Foo {

    //the method doX can be accessed by other classes in the same package (the model package),
    //but the method doY is available only to the Foo class
    private[model] def doX {}
    private def doY {}
  }
  class Bar {
    val f = new Foo
    f.doX // compiles
    //f.doY // won't compile
  }
}


//5 More package-level control
package com.acme.lgd.china {

  class Foo {
    private[china] def doX {}
    private[lgd] def doY {}
    private[acme] def doZ {}
  }
}

import com.acme.lgd.china._

package com.acme.lgd.view {
  class Bar {
    val f = new Foo
    //f.doX // won't compile
    f.doY
    f.doZ
  }
}

package com.acme.common {
  class Bar {
    val f = new Foo
    //f.doX // won't compile
    //f.doY // won't compile  //要想通过编译com.acme.common改成com.acme.lgd
    f.doZ
  }
}

//6 Public scope
//If no access modifier is added to the method declaration, the method is public.
package com.acme.bb.model {
  class Foo {
    def doX {}
  }
}
package org.xyz.bar {

  class Bar {
    val f = new com.acme.bb.model.Foo
    f.doX
  }

}

/*

Access            modifier Description
private[this]     The method is available only to the current instance of the class it’s declared in.
private           The method is available to the current instance and other instances of the class it’s declared in.
protected         The method is available only to instances of the current class and subclasses of the current class.
private[model]    The method is available to all classes beneath the com.acme.coolapp.model package.
private[coolapp]  The method is available to all classes beneath the com.acme.coolapp package.
private[acme]     The method is available to all classes beneath the com.acme package.
(no modifier)     The method is public.

*/
