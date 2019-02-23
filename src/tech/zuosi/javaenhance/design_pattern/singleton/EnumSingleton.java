package tech.zuosi.javaenhance.design_pattern.singleton;

/**
 * Created by luckykoala on 19-2-23.
 * 枚举类实现单例-线程安全
 * 利用JVM提供的机制保证线程安全
 */
public enum EnumSingleton {
    INSTANCE
}
