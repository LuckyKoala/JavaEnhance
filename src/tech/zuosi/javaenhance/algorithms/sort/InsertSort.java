package tech.zuosi.javaenhance.algorithms.sort;

/**
 * Created by luckykoala on 19-2-24.
 * First try: 16:40-17:09
 * 时间复杂度O(n²) 数组中插入数据的平均时间复杂度O(n) n次插入
 *  最好O(n) 有序，比较一次即找到插入点
 *  最坏O(n²) 倒序，每次都在数组的头部插入
 * 空间复杂度O(1)
 */
public class InsertSort {
    public void sort(int[] arr) {
        if(arr==null || arr.length<=1) return; //没有必要执行排序

        //初始状态下，第一个元素在已排序区间
        for(int i=1; i<arr.length; i++) {
            int value = arr[i];
            //每次选择未排序区间的一个元素，依次与前面已排序的数字进行比较并做相应移动
            //查找插入点，从已排序区间 尾部搜索到头部
            for(int j=i-1; j>=0; j--) {
                if(arr[j] > value) arr[j+1] = arr[j]; //对应移动插入点后面的数据
                else {
                    arr[j+1] = value; //将元素移动到插入点
                    break; //该区域所有元素有序，所以只需要找到小于等于的第一个元素即可。
                }
            }
        }
    }
}
