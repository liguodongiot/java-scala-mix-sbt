package scalacookbook.chapter09;

/**
 * Created by liguodong on 2016/7/23.
 */
public class SimulatedClosure {

    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        greeter.setHelloPhrase("Hello");
        greeter.sayHello("Al"); // "Hello, Al"

        greeter.setHelloPhrase("Hola");
        greeter.sayHello("Lorenzo"); // "Hola, Lorenzo"


        greeter.setHelloPhrase("Yo");
        Bar bar = new Bar(greeter); // pass the greeter instance to a new Bar
        bar.sayHello("Adrian"); // invoke greeter.sayHello via Bar
        //Yo, Adrian
    }
}


class Greeter {
    private String helloPhrase;
    public void setHelloPhrase(String helloPhrase) {
        this.helloPhrase = helloPhrase;
    }
    public void sayHello(String name) {
        System.out.println(helloPhrase + ", " + name);
    }
}

class Bar {
    private Greeter greeter;
    public Bar (Greeter greeter) {
        this.greeter = greeter;
    }
    public void sayHello(String name) {
        greeter.sayHello(name);
    }
}