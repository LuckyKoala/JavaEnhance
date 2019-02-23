package tech.zuosi.javaenhance.offer_questions.base.duplication_in_array;

import java.util.Arrays;

/**
 * Created by luckykoala on 19-2-23.
 * 先排序再遍历查重
 * 时间复杂度 O(nlog(n))
 *  最好O(nlog(n)) 前两个数字刚好相同
 *  最坏O(nlog(n))  最后两个数字相同
 * 空间复杂度 O(1) 原地排序
 */
public class WithSorting {
    public static int duplicateNumberOf(int[] arr) {
        Arrays.sort(arr); //双分区点快排 时间复杂度O(nlog(n)) 空间复杂度O(1)?
        int lastVal = -1;
        for(int val : arr) {
            if(val==lastVal) return val; //已经排序过的数组，重复的数字必定相邻
            else lastVal=val;
        }
        return -1; //不应该出现，题意是必有重复数字
    }

    public static void main(String[] args) {
        System.out.println(duplicateNumberOf(new int[]{2,3,1,0,2,5,3}));
    }
}