package tech.zuosi.tryguava;

import com.google.common.base.Splitter;

import java.util.HashMap;

public class TryMain {
    public static void main(String[] args) {
        Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split("foo,bar,,   qux")
                .forEach(System.out::println);
    }
}
