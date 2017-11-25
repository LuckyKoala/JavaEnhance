package tech.zuosi.javaenhance.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iwar on 2017/6/8.
 */
class NaturalNumber {

    private int i;

    public NaturalNumber(int i) { this.i = i; }
    // ...
}

class EvenNumber extends NaturalNumber {

    public EvenNumber(int i) { super(i); }
    // ...
}
/**
 * You can add null.
 * You can invoke clear.
 * You can get the iterator and invoke remove.
 * You can capture the wildcard and write elements that you've read from the list.
 */
public class WildcardGuidelines {
    public static void main(String[] args) {
        List<EvenNumber> le = new ArrayList<>();
        List<? extends NaturalNumber> ln = le;
        helper(ln);
    }
    static <T> void helper(List<T> list) {
        list.add(0, list.get(0)); //capture the wildcard and write elements that you've read from the list.
    }
}
