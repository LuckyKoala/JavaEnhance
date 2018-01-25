package tech.zuosi.javaenhance.collection.map.hashmap;

import static tech.zuosi.javaenhance.util.BinaryFormatter.binaryStringFor;

public class TableSize {
    static final int MAXIMUM_CAPACITY = 1 << 30;
    private static final int A = 0b00000000_00000000_00000000_00010001; //aka 17
    private static final int B = 0b00000000_00000000_00000000_00000011; //aka 3

    /*
    Note:
        先减1是预先处理已经是2的n次方的数，这样得到的结果是正确的最接近的2的n次方数 例如func(16)=16而不是32
        之后移动有效位，逐位进行或操作，最终得到从最高有效位开启全是1的数字（二进制位表示），最后加1则得到
        2的n次方数 例如00000000 00000000 00000000 00011111(31) -> 00000000 00000000 00000000 00100000(32)
     */
    public static void main(String[] args) {
        tableSizeFor(A);
        tableSizeFor(B);
    }

    /**
     * Partial copied from {@link java.util.HashMap#tableSizeFor(int)}
     * @param cap capacity to process
     * @return Returns a power of two size for the given target capacity.
     */
    static final int tableSizeFor(int cap) {
        System.out.println("Cap value: " + binaryStringFor(cap));
        int n = cap - 1;
        System.out.println("Compute value: " + binaryStringFor(n));
        System.out.println();
        n = orAndPrint(n, n>>>1);
        n = orAndPrint(n, n>>>2);
        n = orAndPrint(n, n>>>4);
        n = orAndPrint(n, n>>>8);
        n = orAndPrint(n, n>>>16);
        System.out.println(binaryStringFor(n+1)+ String.format("(%d)", n+1));
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    static int orAndPrint(int a, int b) {
        int result = a|b;

        System.out.println("A:" + binaryStringFor(a));
        System.out.println("B:" + binaryStringFor(b));
        System.out.println("->" + binaryStringFor(result));
        return result;
    }
}
