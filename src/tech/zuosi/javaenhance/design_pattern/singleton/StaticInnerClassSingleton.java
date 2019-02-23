package tech.zuosi.javaenhance.design_pattern.singleton;

/**
 * Created by luckykoala on 19-2-23.
 * 静态内部类实现单例-线程安全
 * 利用类加载机制实现懒加载与线程安全
 */
public class StaticInnerClassSingleton {
    private StaticInnerClassSingleton() {}

    private static class SingletonHolder {
        private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
