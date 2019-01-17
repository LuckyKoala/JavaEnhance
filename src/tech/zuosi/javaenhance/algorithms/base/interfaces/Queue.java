package tech.zuosi.javaenhance.algorithms.base.interfaces;

/**
 * Created by luckykoala on 18-3-16.
 */
public interface Queue<T> {
    void enqueue(T data);
    T dequeue();
    int size();
    boolean isEmpty();
}
