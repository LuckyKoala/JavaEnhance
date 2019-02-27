package tech.zuosi.javaenhance.offer_questions.base.data_structure.string.replace_blank;

/**
 * Created by luckykoala on 19-2-27.
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 */
public class Solution {
    private static final char BLANK = ' ';

    public String replaceBlank(String origin) {
        if(origin==null) return null;
        //先遍历一次，得到空格字符的数量
        int spaceCount = 0;
        for(int i=0; i<origin.length(); i++) {
            if(origin.charAt(i) == BLANK) spaceCount++;
        }
        //申请新的字符数组
        char[] chars = new char[spaceCount*2 + origin.length()];
        origin.getChars(0, origin.length(), chars, 0);
        //替换空格字符
        int p = origin.length()-1; //由后往前查找空格字符，指向查找的下标
        int q = chars.length-1; //替换空格字符，指向替换的下标，-1是初始化值
        while(p!=q && p>=0) {
            if(chars[p] == BLANK) {
                chars[q--] = '0';
                chars[q--] = '2';
                chars[q--] = '%';
            } else {
                chars[q--] = chars[p]; //移动原字符到新的位置
            }
            p--;
        }
        return new String(chars);
    }
}
