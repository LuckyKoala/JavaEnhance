package tech.zuosi.javaenhance.offer_questions.base.biggest_index_of_subset_in_array;

/**
 * Created by luckykoala on 19-2-24.
 * First try: 09:27-09:38
 * 遍历匹配
 * 若a.length = n, b.length = m,则有
 * 时间复杂度 O(mn)
 *  最好O(m)
 *  最坏O(nm)
 * 空间复杂度 O(1)
 */
public class WithNormalLoop implements Solution {
    @Override
    public int indexOfBiggestSubset(int[] a, int[] b) {
        if(a==null || b==null || b.length==0) return -1;

        int lastIndex = -1;
        for(int i=0; i<a.length; i++) {
            if(matchSubset(a, b, i)) lastIndex=i;
        }

        return lastIndex;
    }

    private boolean matchSubset(int[] fullset, int[] subset, int start) {
        for(int i=0; i<subset.length; i++) {
            if(fullset[start+i]!=subset[i]) return false;
        }
        return true;
    }
}
