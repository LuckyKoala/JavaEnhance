package tech.zuosi.javaenhance.util;

import org.jetbrains.annotations.NotNull;

/**
 * 用于格式化输出基本数据类型的二进制表示
 */
public class BinaryFormatter {
    private static final char ZERO = '0';
    private static final String SPACE = " ";

    private BinaryFormatter() {}

    //---long---
    public static String binaryStringFor(long val) {
        return insertSpaceEveryNDigits(binaryStringWithLeadingZeros(val), 8);
    }

    public static String binaryStringFor(long val, int period) {
        return insertSpaceEveryNDigits(binaryStringWithLeadingZeros(val), period);
    }

    private static String binaryStringWithLeadingZeros(long i) {
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(i);
        if(numberOfLeadingZeros == Long.SIZE) numberOfLeadingZeros = Long.SIZE - 1;

        String zerosStr = getZerosString(numberOfLeadingZeros);
        return zerosStr + Long.toBinaryString(i);
    }

    //---int---
    public static String binaryStringFor(int val) {
        return insertSpaceEveryNDigits(binaryStringWithLeadingZeros(val), 8);
    }

    public static String binaryStringFor(int val, int period) {
        return insertSpaceEveryNDigits(binaryStringWithLeadingZeros(val), period);
    }

    private static String binaryStringWithLeadingZeros(int i) {
        int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i);
        if(numberOfLeadingZeros == Integer.SIZE) numberOfLeadingZeros = Integer.SIZE - 1;

        String zerosStr = getZerosString(numberOfLeadingZeros);
        return zerosStr + Integer.toBinaryString(i);
    }

    @NotNull
    private static String getZerosString(int numberOfLeadingZeros) {
        StringBuilder builder = new StringBuilder(numberOfLeadingZeros);
        for (int j = 0; j < numberOfLeadingZeros; j++) {
            builder.append(ZERO);
        }
        return builder.toString();
    }

    private static String insertSpaceEveryNDigits(String text, int period) {
        return insertPeriodically(text, SPACE, period);
    }

    private static String insertPeriodically(
            String text, String insert, int period)
    {
        StringBuilder builder = new StringBuilder(
                text.length() + insert.length() * (text.length()/period)+1);

        int index = 0;
        String prefix = "";
        while (index < text.length())
        {
            // Don't put the insert in the very first iteration.
            // This is easier than appending it *after* each substring
            builder.append(prefix);
            prefix = insert;
            builder.append(text.substring(index,
                    Math.min(index + period, text.length())));
            index += period;
        }
        return builder.toString();
    }
}
