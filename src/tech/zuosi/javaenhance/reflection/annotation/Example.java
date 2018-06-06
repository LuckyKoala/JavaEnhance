package tech.zuosi.javaenhance.reflection.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * Created by luckykoala on 18-6-6.
 */
public class Example {

    @RequestMapping("/blog")
    public void doSomething() {
        //
    }

    @RequestMapping(value="/user", method="POST")
    public void tryAnother() {
        //
    }

    public static void main(String[] args) {
        Class<?> cls = Example.class;
        Method[] allMethods = cls.getDeclaredMethods();
        for (Method m : allMethods) {
            System.out.println(String.format("Method name: %s ", m.getName()));

            RequestMapping requestMapping = m.getAnnotation(RequestMapping.class);
            if(requestMapping == null) {
                System.out.println("Without RequestMapping Annotation \n");
                return;
            }
            System.out.println(String.format("RequestMapping(value='%s', method='%s')\n",
                    requestMapping.value(), requestMapping.method()));
        }
    }
}

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface RequestMapping {
    String value();
    String method() default "GET";
}


