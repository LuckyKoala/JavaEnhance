package tech.zuosi.javaenhance.collection;

/**
 * Created by iwar on 2017/6/30.
 */
public class Item implements Comparable<Item> {
    String name;
    int num;

    public Item(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Item o) {
        return num-o.num;
    }
}
