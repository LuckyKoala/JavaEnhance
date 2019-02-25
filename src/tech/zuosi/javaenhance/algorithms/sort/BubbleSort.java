package tech.zuosi.javaenhance.algorithms.sort;

/**
 * Created by luckykoala on 19-2-24.
 * 14:01-14:19
 * 时间复杂度 O(n²)
 *  最好O(n) 数组是有序的
 *  最坏O(n²) 数组是无序的
 * 空间复杂度 O(1) 原地排序
 * 稳定排序
 */
public class BubbleSort {
    public void sort(int[] arr) {
        if(arr==null || arr.length<=1) return; //没有必要执行排序

        //对n个元素进行n次冒泡操作
        boolean swapHappened = false;
        for(int i=0; i<arr.length; i++) {
            //每次冒泡比较相邻的两个数，故比较次数为 元素个数-1
            for(int j=0; j<arr.length-i-1; j++) {
                int nextIndex = j+1;
                if(nextIndex<arr.length && arr[j] > arr[nextIndex]) {
                    swapHappened = true;
                    swap(arr, i, j);
                }
            }
            //如果这次冒泡操作没有执行过交换操作，那么该数组已经是完全有序的了
            if(!swapHappened) break;
        }
    }

    //交换数字
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
