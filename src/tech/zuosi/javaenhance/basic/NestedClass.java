package tech.zuosi.javaenhance.basic;

/**
 * Created by iwar on 2017/7/10.
 */
public class NestedClass {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.print();
        outer.print();
    }
}
class Outer {
    int value = 1;
    void print() {
        Inner inner = new Inner();
        System.out.println("O~");
        inner.print();
    }
    class Inner {
        void print() {
            System.out.println(Outer.this.value);
        }
    }
}
