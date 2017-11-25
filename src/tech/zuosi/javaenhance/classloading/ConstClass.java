package tech.zuosi.javaenhance.classloading;

/**
 * Created by iwar on 2017/6/15.
 */
public class ConstClass {
    static {
        System.out.println("ConstClass init!");
    }
    public static final String HELLOWORLD = "hello world";
}
