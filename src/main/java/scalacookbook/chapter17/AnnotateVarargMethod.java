package scalacookbook.chapter17;

/**
 *
 * Created by liguodong on 2016/8/19.
 */
public class AnnotateVarargMethod {

    //在Scala中创建可变参函数加注解，被Java代码调用
    public static void main(String[] args) {
        Printer p = new Printer();
        p.printAll("Hello");
        p.printAll("Hello, ", "world");
    }


}
