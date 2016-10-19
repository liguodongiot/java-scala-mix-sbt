package scalacookbook.chapter06;

/**
 * Created by liguodong on 2016/10/8.
 */
public class AJavaClass {

    public static void sendObjects(Object[] obj){

        System.out.println("Scala 调用 Java:");
        for (Object temp : obj) {
            System.out.print(" "+temp);
        }
        System.out.println("\n赫赫赫赫。。。");
    }

}
