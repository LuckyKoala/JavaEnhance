package tech.zuosi.javaenhance.generics;

/**
 * Created by iwar on 2017/6/8.
 */
public class Box<T> {
    private T t;
    public T get() {
        return t;
    }
    public void set(T value) {
        this.t = value;
    }
}
