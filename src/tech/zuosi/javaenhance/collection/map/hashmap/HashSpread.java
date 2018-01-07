package tech.zuosi.javaenhance.collection.map.hashmap;

import java.util.Objects;

import static tech.zuosi.javaenhance.collection.map.hashmap.BinaryFormatter.binaryStringFor;

public class HashSpread {
    /*
    Print:
            For object -> hello, world
            hashCode:  11011001 11010001 00010101 10001100
            shift to:  00000000 00000000 11011001 11010001
            result is: 11011001 11010001 11001100 01011101
    Note:
        对于32位int逻辑右移16位，再执行异或操作，高16位和0做异或操作，没有变化，
        而低16位和高16位逐位异或，所以说是将高位的影响传播到低位。
    */
    public static void main(String[] args) {
        String str = "hello, world";
        hash(str);
    }

    /**
     * Partial copied from {@link java.util.HashMap#hash(Object)}
     * @param key object to process
     * @return a hash which apply a transform that spreads the impact of higher bits
     * downward
     */
    static final int hash(Object key) {
        if (Objects.nonNull(key)) {
            int hashCode = key.hashCode();
            int hashCodeAfterShift = hashCode >>> 16;
            int result = hashCode ^ hashCodeAfterShift;
            System.out.println("For object -> " + key.toString());
            System.out.println("hashCode:  " + binaryStringFor(hashCode));
            System.out.println("shift to:  " + binaryStringFor(hashCodeAfterShift));
            System.out.println("result is: " +binaryStringFor(result));
        }
        return 0;
    }
}
