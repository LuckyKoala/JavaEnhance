package tech.zuosi.javaenhance.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iwar on 2017/6/8.
 * During the type erasure process, the Java compiler erases all type parameters and
 *   replaces each with its first bound if the type parameter is bounded,
 *   or Object if the type parameter is unbounded.
 * You can check it by use View-> Show Bytecode after compile.
 */
interface a {}
interface b {}
class c {}
class v extends c implements a,b {}
public class TypeErasure {
    public static void main(String[] args) {
        List<Number> numberList = new ArrayList<>();
        numberList.add(0, 1);
        func(numberList);
        //fun(new v());
    }
    static void func(List<? super Integer> list) {
        System.out.println(list.get(0));
    }
    /*static <T extends a & b> void fun(T value) {
        System.out.println(value);
    }*/
}
