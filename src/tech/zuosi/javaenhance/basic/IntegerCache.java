package tech.zuosi.javaenhance.basic;

/**
 * Created by luckykoala on 18-4-5.
 */
public class IntegerCache {
    public static void main(String[] args) {
        //Invoke a constructor will always return a new instance
        Integer a = new Integer(23);
        Integer b = new Integer(23);
        System.out.println(a == b);
        //Use valueOf or AutoBox will use IntegerCache
        Integer c = Integer.valueOf(45);
        Integer d = Integer.valueOf(45);
        System.out.println(c == d);
    }
}
