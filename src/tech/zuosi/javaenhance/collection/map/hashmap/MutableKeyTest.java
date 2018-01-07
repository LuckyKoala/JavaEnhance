package tech.zuosi.javaenhance.collection.map.hashmap;

import java.util.HashMap;
import java.util.Map;

public class MutableKeyTest {
    public static void main(String[] args) {

        class MyKey {
            private Integer i;

            public void setI(Integer i) {
                this.i = i;
            }

            MyKey(Integer i) {
                this.i = i;
            }

            @Override
            public int hashCode() {
                return i;
            }

            @Override
            public boolean equals(Object obj) {
                return obj instanceof MyKey && i.equals(((MyKey) obj).i);
            }

        }

        Map<MyKey, String> myMap = new HashMap<>();
        MyKey key1 = new MyKey(1);
        MyKey key2 = new MyKey(2);

        myMap.put(key1, "test " + 1);
        myMap.put(key2, "test " + 2);

        // modifying key1
        key1.setI(3);

        String test1 = myMap.get(key1);
        String test2 = myMap.get(key2);

        System.out.println("test1= " + test1 + " test2=" + test2);

    }
}
