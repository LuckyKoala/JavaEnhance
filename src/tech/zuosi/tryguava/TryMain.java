package tech.zuosi.tryguava;

import com.google.common.base.Splitter;

public class TryMain {
    public static void main(String[] args) {
        Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split("foo,bar,,   qux")
                .forEach(System.out::println);
    }
}
