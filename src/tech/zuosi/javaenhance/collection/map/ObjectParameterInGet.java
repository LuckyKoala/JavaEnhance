package tech.zuosi.javaenhance.collection.map;

import java.util.HashMap;
import java.util.Map;

public class ObjectParameterInGet {
    static class Item {
        private static int nextId = 0;
        private int id;

        Item() {
            this.id = nextId++;
        }

        @Override
        public int hashCode() {
            return id;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == null) return false;
            if(obj == this) return true;
            if(obj instanceof Item) {
                Item item = (Item) obj;
                return item.id == id;
            }
            return false;
        }
    }

    //Instance of which can be treated like item in Map implementations
    static class Box {
        private Item containedItem;

        Box(Item containedItem) {
            this.containedItem = containedItem;
        }

        @Override
        public int hashCode() {
            return containedItem.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == null) return false;
            if(obj == this) return true;
            if(obj instanceof Box) {
                Box box = (Box) obj;
                return box.containedItem.equals(containedItem);
            } else if(obj instanceof Item) {
                Item item = (Item) obj;
                return item.equals(containedItem);
            }
            return false;
        }
    }

    //Use not exactly same type of object as parameter of map.get() to get value
    public static void main(String[] args) {
        Item one = new Item();
        Box box = new Box(one);
        Map<Item, String> map = new HashMap<>();

        map.put(one, "one");
        String value = map.get(box);
        System.out.println("Value is " + value);
    }
}
