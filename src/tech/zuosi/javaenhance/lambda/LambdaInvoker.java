package tech.zuosi.javaenhance.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LuckyKoala on 18-9-26.
 */

public class LambdaInvoker {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(1);
        list.forEach(System.out::println);
    }
}
