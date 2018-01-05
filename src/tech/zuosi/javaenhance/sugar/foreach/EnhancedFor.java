package tech.zuosi.javaenhance.sugar.foreach;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class EnhancedFor {
    void sugar(List<String> stringList) {
        for(String str : stringList) {
            System.out.println(str);
        }
    }

    void actual(List<String> stringList) {
        Iterator<String> iterator = stringList.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
        //Use a instance of custom class to test
        FakeList<String> list = new FakeList<>("Hello from fake list", 5);
        for(String str : list) {
            System.out.println(str);
        }
        //list.forEach(System.out::println);
        //Use a instance of class which is returned by method implemented in java.util.Collections package
        List<String> nCopies = Collections.nCopies(5, "Hello from nCopies");
        nCopies.forEach(System.out::println);
    }
}
