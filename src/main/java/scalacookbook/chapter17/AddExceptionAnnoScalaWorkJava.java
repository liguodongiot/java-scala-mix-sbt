package scalacookbook.chapter17;

/**
 * Created by liguodong on 2016/8/19.
 */
public class AddExceptionAnnoScalaWorkJava {

    public static void main(String[] args){

        // java
        Thrower t = new Thrower();
        try {
            t.exceptionThrower();
        } catch (Exception e) {
            System.err.println("Caught the exception.");
            e.printStackTrace();
        }



        try {
            Thrower t2 = new Thrower();
            t2.exceptionThrower();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
