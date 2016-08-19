package scalacookbook.chapter17;

/**
 * Created by liguodong on 2016/8/19.
 */
public class JavaMath extends MathTraitWrapper{

    public static void main(String[] args) {
        new JavaMath();
    }
    public JavaMath() {
        System.out.println(sum(2,2));
    }

    //The only way to solve the problem is to wrap the trait with a class on the Scala side,
    //which was demonstrated in the Solution.

    //To summarize: If you’re writing a Scala API that will be used by Java clients,
    // don’t expose traits that have implemented behavior in your public API.
    // If you have traits like that,wrap them in a class for your Java consumers.

}
