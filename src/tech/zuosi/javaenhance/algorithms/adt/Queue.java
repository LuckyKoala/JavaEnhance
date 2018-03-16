package tech.zuosi.javaenhance.algorithms.adt;

/**
 * Created by luckykoala on 18-3-16.
 */
public interface Queue<T> {
    void enqueue(T data);
    T dequeue();
    int size();
    boolean isEmpty();
}
