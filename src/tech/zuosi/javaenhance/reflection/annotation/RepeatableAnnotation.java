package tech.zuosi.javaenhance.reflection.annotation;

import java.lang.annotation.Repeatable;

public class RepeatableAnnotation {

    @Author("LuckyKoala")
    @Author("Iwar")
    public String book() {
        return "One book";
    }
}

@Repeatable(Authors.class)
@interface Author {
    String value();
}

@interface Authors {
    Author[] value();
}