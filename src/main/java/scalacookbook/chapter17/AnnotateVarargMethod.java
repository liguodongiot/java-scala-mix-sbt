package scalacookbook.chapter17;

/**
 * 创建了一个可变参数方法，希望能够被Java代码调用。
 *
 * Created by liguodong on 2016/8/19.
 */
public class AnnotateVarargMethod {

    public static void main(String[] args) {
        Printer p = new Printer();
        p.printAll("Hello");
        p.printAll("Hello, ", "world");
    }


}
