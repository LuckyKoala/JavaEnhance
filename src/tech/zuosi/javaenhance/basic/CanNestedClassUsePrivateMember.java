package tech.zuosi.javaenhance.basic;

public class CanNestedClassUsePrivateMember {
    private int whatever;

    class Inner {
        void access() {
            System.out.println(whatever);
        }
    }

    public static void main(String[] args) {
        new CanNestedClassUsePrivateMember().new Inner().access();
    }
}
