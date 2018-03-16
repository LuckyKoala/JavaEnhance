package tech.zuosi.javaenhance.algorithms.adt;

/**
 * Created by luckykoala on 18-3-16.
 */
public interface Bag<T> {
    void add(T data);
    int size();
    boolean isEmpty();
}
