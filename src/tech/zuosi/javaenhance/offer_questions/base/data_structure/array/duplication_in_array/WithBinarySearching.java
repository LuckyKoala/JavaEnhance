package tech.zuosi.javaenhance.offer_questions.base.data_structure.array.duplication_in_array;

/**
 * Created by luckykoala on 19-2-23.
 * 二分查找
 * [NOTE] 不保证能找到，请看下面Main方法中两个测试用例，如果重复的数字分散在两侧，本算法无法找到
 * 把从0～n-1的数字从中间m分为两份，也就是0~m和m+1~n-1，
 *  如果0~m中的数字的数目超过m+1，则重复的数字肯定在前半部分，否则在后半部分。
 * 时间复杂度 O(nlogn)
 *  函数countInRange的时间复杂度为O(n)
 * 空间复杂度 O(1)
 */
public class WithBinarySearching implements Solution {
    @Override
    public int duplicateNumberOf(int[] arr) {
        if(arr == null) return -1;

        int start = 0;
        int end = arr.length-1;

        while(end >= start) {
            int middle = start + ((end-start)>>1); //取中间值
            int count = countInRange(arr, start, middle);
            if(end==start) {
                if(count>1) return start;
                else break;
            }

            if(count > (middle-start+1)) {
                //如果数组中只有奇数个数字，可能出现end和middle相等的情况，如果不处理则会出现死循环
                if(end==middle) end = start;
                else end = middle;
            } else {
                start = middle+1;
            }
        }
        return -1; //不应该出现，题意是必有重复数字
    }

    private static int countInRange(int[] arr, int start, int end) {
        int count = 0;
        for(int val : arr) {
            if(val >= start && val <= end) count++;
        }
        return count;
    }
}
