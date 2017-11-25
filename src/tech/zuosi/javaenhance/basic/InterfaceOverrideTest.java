package tech.zuosi.javaenhance.basic;

interface A {
    /**
     * Just test it.
     */
    void test();
}

interface B extends  A{
    /**
     * Of course you can test it.
     */
    void test();
}

public class InterfaceOverrideTest implements B {
    public void test() {
        System.out.println("Override method declaration in interface is possible！");
    }
}
