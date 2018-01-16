package tech.zuosi.javaenhance.collection.map.hashmap;

import java.util.HashMap;
import java.util.Map;

public class TreeifyTest {
    private static final Object PRESENT = new Object();
    /**
     * The smallest table capacity for which bins may be treeified.
     * (Otherwise the table is resized if too many nodes in a bin.)
     * Should be at least 4 * TREEIFY_THRESHOLD to avoid conflicts
     * between resizing and treeification thresholds.
     */
    private static final int MIN_TREEIFY_CAPACITY = 64;

    public static void main(String[] args) {
        Map<SameHashCode, Object> map = new HashMap<>(64);
        for (int i = 0; i < MIN_TREEIFY_CAPACITY; i++) {
            map.put(new SameHashCode(), PRESENT);
        }
        System.out.println("Insert breakpoint here");
        System.out.println("End of test");
    }
}
