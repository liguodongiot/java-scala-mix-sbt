package scalacookbook.chapter17;

/**
 * Created by liguodong on 2016/8/19.
 */
public class JavaCodeRequiresJavaBeans {
    public static void main(String[] args) {
        // create instances
        Person p = new Person("Regina", "Goode");
        EmailAccount acct = new EmailAccount();

        // demonstrate（演示） 'setter' methods
        acct.setUsername("regina");
        acct.setPassword("secret");

        // demonstrate 'getter' methods
        System.out.println(p.getFirstName());
        System.out.println(p.getLastName());
        System.out.println(p);
        System.out.println(acct.getUsername());
        System.out.println(acct.getPassword());
        System.out.println(acct);
    }
}
