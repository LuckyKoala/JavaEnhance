package tech.zuosi.javaenhance.offer_questions.base.data_structure.array.search_in_two_dimentional_array;

/**
 * Created by luckykoala on 19-2-25.
 * First try: 18:39-18:56 use binary search, too complicated, failed
 */
public class DeceaseProblemRange {
    public boolean search(int[][] arr, int target) {
        if(arr==null || arr.length==0 || arr[0].length==0) return false;

        //从右上角开始,也可以从左下角开始
        int row = 0;
        int column = arr[0].length-1;
        while(row<arr.length && column>=0) {
            int val = arr[row][column];
            if(val == target) return true;
            //每次减少一行/一列的搜索范围
            if(val > target) column--; //该列数值都大于目标，减少列下标
            else row++; //该行数值都小于目标，增加行下标
        }
        return false;
    }
}
