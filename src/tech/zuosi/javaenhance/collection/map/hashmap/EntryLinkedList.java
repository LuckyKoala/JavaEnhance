package tech.zuosi.javaenhance.collection.map.hashmap;

import java.util.HashMap;
import java.util.Map;

public class EntryLinkedList {
    //insert breakpoint and debug to see underlying structure of HashMap
    //instances that return same hash code in map will make hash table fall back to linked list which
    //  can lead to performance problem
    public static void main(String[] args) {
        SameHashCode a = new SameHashCode();
        SameHashCode b = new SameHashCode();
        Map<SameHashCode, Integer> map = new HashMap<>(2);
        map.put(a, 1);
        map.put(b, 2);
        System.out.println(map.size());
        System.out.println(String.format("%d %d", map.get(a), map.get(b)));
    }
}
