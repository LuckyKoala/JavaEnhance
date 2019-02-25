package tech.zuosi.javaenhance.algorithms.sort;

/**
 * Created by luckykoala on 19-2-24.
 * 时间复杂度O(nlog(n)) n二分近似log(n) 每次分区的时间复杂度为O(n)
 * 空间复杂度O(1) 分区函数的空间复杂度为O(1)
 */
public class QuickSort {
    public void sort(int[] arr) {
        if(arr==null || arr.length<=1) return; //没有必要执行排序

        sortIter(arr, 0, arr.length-1);
    }

    private void sortIter(int[] arr, int start, int end) {
        if(start>=end) return; //不可再分
        int pivotIndex = partition(arr, start, end); //分区
        //一分为二
        sortIter(arr, start, pivotIndex-1);
        sortIter(arr, pivotIndex+1, end);
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[end]; //分区点
        int i = start; //已处理区间为 [start,...,i-1];
        //比分区点数值小的移动到已处理区间的尾部
        for(int j=start; j<end; j++) {
            if(arr[j] < pivot) {
                swap(arr, i, j);
                i++; //已处理区间扩大
            }
        }
        swap(arr, i, end); //移动分区点
        return i;
    }

    //交换数字
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
