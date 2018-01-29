package tech.zuosi.javaenhance.basic;

public class SameParity {
    public static void main(String[] args) {
        System.out.println(isSameParity(12, 3));
        System.out.println(isSameParity(65535, 9));
    }

    private static boolean isSameParity(int a, int b) {
        return (~((a & 1) ^ (b & 1)) & 1) == 1;
    }
}
