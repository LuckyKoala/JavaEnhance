package tech.zuosi.javaenhance.design_pattern.singleton;

/**
 * Created by luckykoala on 19-1-18.
 * Singleton method
 * Use cases:
 *  1. When class can only have one single instance and clients can only access it from one single entry.
 *  2. When such a single instance should be able to extended and clients can use one extended instance without
 *       modifications.
 */
public class Singleton {
    private static Singleton instance;

    protected Singleton() {}

    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
