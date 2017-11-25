package tech.zuosi.javaenhance.generics.exercise;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by iwar on 2017/6/12.
 */
interface UnaryPredicate<T> {
    boolean test(T obj);
}
public final class CollectionUtil {
    //Write a generic method to count the number of elements in a collection
    // that have a specific property (for example, odd integers, prime numbers, palindromes).
    static <T> int countIf(Collection<T> c, UnaryPredicate<T> p) {

        int count = 0;
        for (T elem : c)
            if (p.test(elem))
                ++count;
        return count;
    }
    //Write a generic method to exchange the positions of two different elements in an array.
    static <T> void exchange(T[] array, int a, int b) {
        T value = array[a];
        array[a] = array[b];
        array[b] = value;
    }
    //Write a generic method to find the maximal element in the range [begin, end) of a list.
    static <T extends Object & Comparable<? super T>> T max(List<? extends T> list, int begin, int end) {
        T maxElem = list.get(begin);

        for (++begin; begin < end; ++begin)
            if (maxElem.compareTo(list.get(begin)) < 0)
                maxElem = list.get(begin);
        return maxElem;
    }
    public static void main(String[] args) {
        Collection<Integer> ci = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);
        System.out.println("Number of odd integers = " + countIf(ci, i -> i%2!=0));
        Integer a[] = new Integer[]{1,3,4,6,10};
        exchange(a, 1, 3);
        for(Integer i:a) {
            System.out.println(i);
        }
    }
}
