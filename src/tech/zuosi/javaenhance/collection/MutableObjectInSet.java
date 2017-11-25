package tech.zuosi.javaenhance.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by iwar on 2017/6/30.
 */
public class MutableObjectInSet {
    public static void main(String[] args) {
        Set<Set> set = new HashSet();
        Set<String> stringSet = new HashSet<>();
        Set<String> anotherStringSet = new HashSet<>();

        stringSet.add("hello");
        set.add(set);
        set.add(stringSet);
        set.add(anotherStringSet);
        //Change content after it is added to set;
        anotherStringSet.add("hello");

        set.forEach(System.out::println);
        //We made a set contains two equal object
        //So we should be care of adding mutable object to Set which can lead unpredictable result
        System.out.println(stringSet.equals(anotherStringSet));

        //Output:
        // [(this Collection), [hello], [hello]]
        // [hello]
        // [hello]
        // true
    }
}
