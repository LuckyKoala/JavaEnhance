package tech.zuosi.javaenhance.offer_questions.base.data_structure.array.duplication_in_array;

/**
 * Created by luckykoala on 19-2-23.
 * 遍“排序”遍查重
 * 时间复杂度 O(n)
 *  最好O(1) 第一次比较就找到重复数字
 *  最坏O(n)  最后一次比较才找到重复数字
 * 空间复杂度 O(1) 交换位置
 */
public class WithReordering implements Solution {
    @Override
    public int duplicateNumberOf(int[] arr) {
        if(arr==null) return -1;

        //将数字放到对应的位置，如果对应的位置已经有对应的数字，则返回重复数字
        // 如果对应的位置和数字不对应，则交换两个数字的位置
        int i = 0;
        while(i < arr.length) {
            int val = arr[i];
            if(val==i) i++; //位置正确，检查下一个数字
            else {
                int valInPos = arr[val];
                if(val==valInPos) return val; //发现重复
                else swap(arr, i, val); //交换到正确位置
            }
        }
        return -1; //不应该出现，题意是必有重复数字
    }

    private void swap(int[] arr, int a, int b) {
        //交换数组中指定两个位置的数字
        //a必然和b不相等，所以可以这样交换数字
        arr[a] = arr[a]+arr[b];
        arr[b] = arr[a]-arr[b];
        arr[a] = arr[a]-arr[b];
        /*
        好理解，但是开辟一个空间
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
        */
    }
}
