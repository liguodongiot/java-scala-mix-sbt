package scalacookbook.chapter17;

import java.util.List;

/**
 * Created by liguodong on 2016/8/19.
 */
public class ConversionExamples {

    // java
    public static int sum(List<Integer> list) {
        int sum = 0;
        for (int i: list) { sum = sum + i; }
        return sum;
    }


}
