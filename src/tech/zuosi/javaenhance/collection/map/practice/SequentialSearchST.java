package tech.zuosi.javaenhance.collection.map.practice;

import java.util.Iterator;

public class SequentialSearchST<K,V> {
    private Node first;
    private int size;

    private class Node {
        private K key;
        private V value;
        private Node next;

        Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node find(K key) {
        Node x = first;
        while(x!=null) {
            if(key.equals(x.key)) return x;
            x = x.next;
        }
        return null;
    }

    V get(K key) {
        Node node = find(key);
        if(node != null) return node.value;
        else return null;
    }

    void put(K key, V value) {
        Node node = find(key);
        if(node != null) {
            node.value = value;
        } else {
            first = new Node(key, value, first);
            size++;
        }
    }

    void delete(K key) {
        Node p = null;
        Node c = first;
        while(c!=null) {
            if(key.equals(c.key)) {
                if(p == null) first = c.next;
                else p.next = c.next;
                size--;
            }
            p = c;
            c = c.next;
        }
    }

    int size() {
        return size;
    }

    Iterator<K> keys() {
        return new KeyItr();
    }

    private class KeyItr implements Iterator<K> {
        Node current;
        Node next;

        KeyItr() {
            current = null;
            next = first;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public K next() {
            current = next;
            next = next.next;
            return current.key;
        }
    }
}
