package tech.zuosi.javaenhance.sugar.foreach;

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
        FakeList<String> list = new FakeList<>("Hello", 5);
        for(String str : list) {
            System.out.println(str);
        }
        list.forEach(System.out::println);
    }
}
