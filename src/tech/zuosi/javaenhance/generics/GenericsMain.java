package tech.zuosi.javaenhance.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iwar on 2017/6/8.
 */
public class GenericsMain {
    public static void main(String[] args) {
        List<? extends Integer> intList = new ArrayList<>();
        List<? extends Number>  numList = intList;
    }
    /*void foo(List<?> i) {
        i.set(0, i.get(0)); //Error:(17, 23) java: 不兼容的类型: java.lang.Object无法转换为capture#1, 共 ?
    }*/
    void foo(List<?> i) {
        fooHelper(i);
    }
    private <T> void fooHelper(List<T> l) {
        l.set(0, l.get(0));
    }
}
