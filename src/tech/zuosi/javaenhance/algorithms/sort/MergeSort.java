package tech.zuosi.javaenhance.algorithms.sort;

/**
 * Created by luckykoala on 19-2-24.
 * 时间复杂度O(nlog(n)) n二分近似log(n) 每次合并的时间复杂度为O(n)
 * 空间复杂度O(n) 同一时间只会有一个合并函数申请临时数组
 */
public class MergeSort {
    public void sort(int[] arr) {
        if(arr==null || arr.length<=1) return; //没有必要执行排序

        sortIter(arr, 0, arr.length-1);
    }

    private void sortIter(int[] arr, int start, int end) {
        if(start>=end) return; //不可再分

        int middle = (start+end)/2;
        //一分为二
        sortIter(arr, start, middle);
        sortIter(arr, middle+1, end);
        //子数组有序后合并
        merge(arr, start, middle, middle+1, end);
    }

    private void merge(int[] arr, int start, int middleEnd, int middleStart, int end) {
        int[] tmp = new int[end-start+1]; //申请临时数组
        int index = 0; //临时数组的下标
        int i = start;
        int j = middleStart;
        while(i<=middleEnd && j<=end) {
            //依次比较两个子数组的头一个元素，取其一放入临时数组
            if(arr[i]<=arr[j]) tmp[index++] = arr[i++];
            else tmp[index++] = arr[j++];
        }
        //其中一个数组为空，则将另一个数组的所有元素加入临时数组
        if(i>middleEnd) System.arraycopy(arr, j, tmp, index, end-j+1);
        else System.arraycopy(arr, i, tmp, index, middleEnd-i+1);
        //将临时数组中有序的结果覆盖到原数组中
        System.arraycopy(tmp, 0, arr, start, tmp.length);
    }
}
