package tech.zuosi.javaenhance.collection.map;

import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Created by luckykoala on 18-3-23.
 */
public class TreeMapTest {
    private static NavigableMap<Integer, String> map;

    static {
        map = new TreeMap<>();
        map.put(100, "one");
        map.put(1500, "four");
        map.put(640, "two");
        map.put(730, "three");
    }

    public static void main(String[] args) {
        System.out.println(map.floorEntry(650).getValue());
        System.out.println(map.ceilingEntry(650).getValue());
    }
}
