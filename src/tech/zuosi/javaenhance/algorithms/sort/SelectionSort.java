package tech.zuosi.javaenhance.algorithms.sort;

/**
 * Created by luckykoala on 19-2-24.
 * First try: 14:24-14:42
 * 时间复杂度O(n²)
 * 空间复杂度O(1)
 */
public class SelectionSort {
    public void sort(int[] arr) {
        if(arr==null || arr.length<=1) return; //没有必要执行排序

        //n个元素对应n次插入操作
        for(int i=0; i<arr.length-1; i++) {
            //每次插入操作是找到未排序区间最小的数插入到已排序区间的后面
            int minIndex = i;
            int j=i+1; //与后面的数进行比较
            for( ; j<arr.length; j++) {
                if(arr[j] < arr[minIndex]) minIndex = j; //记录最小数的下标
            }
            swap(arr, i, minIndex); //插入最小数
        }
    }

    //交换数字
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
