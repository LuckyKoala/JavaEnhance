package tech.zuosi.javaenhance.algorithms.base.implementations;

import tech.zuosi.javaenhance.algorithms.base.interfaces.Stack;

import java.util.NoSuchElementException;

/**
 * Created by luckykoala on 18-3-16.
 */
public class LinkedStack<T> implements Stack<T> {
    private Node<T> head;
    private int size = 0;

    public LinkedStack() {}

    public void push(T data) {
        Node<T> node = new Node<>();
        node.setData(data);
        node.setNext(head);
        head = node;
        size++;
    }

    public T pop() {
        if(size == 0) throw new NoSuchElementException();
        Node<T> node = head;
        head = head.getNext();
        size--;
        return node.getData();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
