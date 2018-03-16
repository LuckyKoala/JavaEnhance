package tech.zuosi.javaenhance.algorithms.adt;

/**
 * Created by luckykoala on 18-3-16.
 */
public class LinkedBag<T> implements Bag<T> {
    private Node<T> head;
    private int size = 0;

    public LinkedBag() {}

    public void add(T data) {
        Node<T> node = new Node<>();
        node.setData(data);
        node.setNext(head);
        head = node;
        size++;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public int size() {
        return size;
    }
}
