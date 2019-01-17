package tech.zuosi.javaenhance.algorithms.base.interfaces;

/**
 * Created by luckykoala on 18-3-16.
 */
public interface Stack<T> {
    void push(T data);
    T pop();
    int size();
    boolean isEmpty();
}
