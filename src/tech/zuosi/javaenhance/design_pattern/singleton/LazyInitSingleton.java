package tech.zuosi.javaenhance.design_pattern.singleton;

/**
 * Created by luckykoala on 19-1-18.
 * Singleton method
 * Use cases:
 *  1. When class can only have one single instance and clients can only access it from one single entry.
 *  2. When such a single instance should be able to extended and clients can use one extended instance without
 *       modifications.
 * 懒汉式-线程不安全
 */
public class LazyInitSingleton {
    private static LazyInitSingleton instance;

    private LazyInitSingleton() {}

    public static LazyInitSingleton getInstance() {
        if(instance == null) {
            instance = new LazyInitSingleton();
        }
        return instance;
    }
}
