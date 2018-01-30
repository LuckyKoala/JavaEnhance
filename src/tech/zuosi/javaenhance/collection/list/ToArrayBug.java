package tech.zuosi.javaenhance.collection.list;

import java.util.*;


public class ToArrayBug
{
    // c.toArray might (incorrectly) not return Object[] (see 6260652)
    // Actual:
    //   [Ljava.lang.String;@7f31245a
    //   [Ljava.lang.Object;@6d6f6e28
    // Expected:
    //   [Ljava.lang.Object;@7f31245a
    //   [Ljava.lang.Object;@6d6f6e28
    public static void main(String[] args)
    {
        List l = Arrays.asList(args);

        System.out.println(l.toArray());
        System.out.println(l.toArray(new Object[0]));
    }
}
