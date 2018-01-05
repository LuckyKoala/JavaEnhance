package tech.zuosi.javaenhance.reflection;

import java.lang.reflect.Array;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by iwar on 2017/6/16.
 */
public class ReflectionMain {
    public static void main(String[] args) {
        List<String> argList = new ArrayList<>(2);
        getList(argList).clear();
    }

    void arrayTest() {
        Object array = Array.newInstance(String.class, 10);
        Array.set(array, 0, "Hello,world!");
    }

    static List getList(final List list) {
        return (List) Proxy.newProxyInstance(List.class.getClassLoader(), new Class[] { List.class },
                (proxy, method, args) -> {
                    if ("add".equals(method.getName())) {
                        throw new UnsupportedOperationException();
                    }
                    else {
                        return method.invoke(list, args);
                    }
                });
    }
}
