package tech.zuosi.javaenhance.design_pattern.singleton;

/**
 * Created by luckykoala on 19-2-23.
 * 懒汉式-线程安全
 */
public class SynchronizedLazyInitSingleton {
    private static SynchronizedLazyInitSingleton instance;

    private SynchronizedLazyInitSingleton() {}

    public static synchronized SynchronizedLazyInitSingleton getInstance() {
        if(instance == null) {
            instance = new SynchronizedLazyInitSingleton();
        }
        return instance;
    }
}
