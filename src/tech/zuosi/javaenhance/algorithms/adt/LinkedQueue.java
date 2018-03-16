package tech.zuosi.javaenhance.algorithms.adt;

import java.util.NoSuchElementException;

/**
 * Created by luckykoala on 18-3-16.
 */
public class LinkedQueue<T> implements Queue<T> {
    private Node<T> head, tail;
    private int size = 0;

    public LinkedQueue() {}

    public void enqueue(T data) {
        Node<T> node = new Node<>();
        node.setData(data);
        if(size == 0) head = tail = node;
        tail.setNext(node);
        tail = node;
        size++;
    }

    public T dequeue() {
        if(size == 0) throw new NoSuchElementException();
        Node<T> node = head;
        head = head.getNext();
        size--;
        if(size == 0) tail = null;
        return node.getData();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
