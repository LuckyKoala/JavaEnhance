package tech.zuosi.javaenhance.offer_questions.base.data_structure.array.duplication_in_array;

import java.util.BitSet;

/**
 * Created by luckykoala on 19-2-23.
 *
 * First try: 16:50-16:58
 * 使用位向量（BitSet）
 * 时间复杂度 O(n)
 *  最好O(1) 前两个数字刚好相同
 *  最坏O(n)  最后两个数字相同
 * 空间复杂度 O(n)
 */
public class WithBitSet implements Solution {
    @Override
    public int duplicateNumberOf(int[] arr) {
        if(arr==null) return -1;

        BitSet bitSet = new BitSet(arr.length);
        for(int i : arr) {
            boolean found = bitSet.get(i); //之前是否已经找到过该数字？
            if(found) return i;
            else bitSet.set(i); //未找到过，设置状态
        }
        return -1; //不应该出现，题意是必有重复数字
    }
}
