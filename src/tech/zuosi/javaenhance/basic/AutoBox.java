package tech.zuosi.javaenhance.basic;

/**
 * Created by iwar on 2017/7/7.
 */
public class AutoBox {
    public static void main(String[] args) {
        //Long sum = 0L //time: 25003ms
        long sum = 0L; //time: 1461ms
        long before = System.currentTimeMillis();
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        long after = System.currentTimeMillis();
        System.out.println(String.format("Sum: %d, Times used: %d", sum, after-before));
    }
}
