package tech.zuosi.javaenhance.classloading;

/**
 * Created by iwar on 2017/6/15.
 */
public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init!");
    }
}
