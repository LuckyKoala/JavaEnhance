package tech.zuosi.javaenhance.classloading;

/**
 * Created by iwar on 2017/6/15.
 */
public class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 123;
}
