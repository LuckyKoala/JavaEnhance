package tech.zuosi.javaenhance.collection.set.bitset;

import static tech.zuosi.javaenhance.util.BinaryFormatter.binaryStringFor;

public class WordMask {
    /*
    Print:
    FirstWordMask: 11111111 11111111 11111111 11111111 11111111 11111111 11111111 11111110
    LastWorkMask:  00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000111
    FinalMask:     11111111 11111111 11111111 11111111 11111111 11111111 11111111 11111001
     */

    /* Used to shift left or right for a partial word mask */
    private static final long WORD_MASK = 0xffffffffffffffffL;

    /**
     * x >>> i
     * 根据JLS，移位运算使用右侧的低n位(当左侧类型可提升至int时，n为5; 当左侧类型可提升至long时，n为6)
     * 所以当x为int类型时，上述表达式实际等同于 x >>> (i & 0b11111) 即 x >>> (i % 32)
     * 测试 {@link java.util.BitSet#clear(int, int)} 的mask值
     */
    public static void main(String[] args) {
        int fromIndex = 1;
        int toIndex = 3;
        long firstWordMask = WORD_MASK << fromIndex;
        long lastWordMask  = WORD_MASK >>> -toIndex;
        long finalMask = ~(firstWordMask & lastWordMask);
        System.out.println(String.format("FirstWordMask: %s %nLastWorkMask:  %s %nFinalMask:     %s",
                binaryStringFor(firstWordMask), binaryStringFor(lastWordMask), binaryStringFor(finalMask)));
    }
}
