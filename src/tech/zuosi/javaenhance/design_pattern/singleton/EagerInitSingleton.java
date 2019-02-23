package tech.zuosi.javaenhance.design_pattern.singleton;

/**
 * Created by luckykoala on 19-2-23.
 * 饿汉式-线程安全
 */
public class EagerInitSingleton {
    private static final EagerInitSingleton INSTANCE = new EagerInitSingleton();

    private EagerInitSingleton() {}

    public static EagerInitSingleton getInstance() {
        return INSTANCE;
    }
}
