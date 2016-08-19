package scalacookbook.chapter17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liguodong on 2016/8/19.
 */
public class JavaExamples {

    // java
    public static List<Integer> getNumbers() {
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        return numbers;
    }

    // java
    public static Map<String, String> getPeeps() {
        Map<String, String> peeps = new HashMap<String, String>();
        peeps.put("captain", "Kirk");
        peeps.put("doctor", "McCoy");
        return peeps;
    }



}
