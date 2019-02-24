package tech.zuosi.javaenhance.offer_questions.base.bignum_addition;

/**
 * Created by luckykoala on 19-2-24.
 * First try: 11:10-11:56 too complicated, failed.
 * Second try: 11:58-12:20
 *  十进制逐个相加
 *  若a.length = n, b.length = m,则有
 * 时间复杂度 O(max(m,n))
 * 空间复杂度 O(max(m,n))
 */
public class DigitAddition implements Solution {
    @Override
    public String add(String a, String b) {
        //处理特殊情况
        if(a==null || b==null) return null;
        if(a.length()==0) return b;
        if(b.length()==0) return a;
        //容纳新的数字字符串
        StringBuilder builder = new StringBuilder(Math.max(a.length(), b.length()) + 1);
        //进位
        int carry = 0;
        for(int i=1; i<=a.length(); i++) {
            char aVal = a.charAt(a.length()-i);
            int sum;
            int bIndex= b.length()-i;
            if(bIndex >= 0) sum = add(aVal-'0', b.charAt(bIndex)-'0', carry);
            else sum = add(aVal-'0', 0, carry);
            carry = sum/10; //设置进位
            builder.append(carry>0 ? sum-10 : sum); //填充数字
        }
        if(carry>0) builder.append(1); //处理可能存在的最高进位

        return builder.reverse().toString();
    }

    private int add(int a, int b, int carry) {
        return a+b+carry;
    }


    //测试用例
    public static void main(String[] args) {
        DigitAddition addition = new DigitAddition();
        System.out.println(addition.add("12312443123124114231523","1123"));
        System.out.println(addition.add("999999999","1"));
        System.out.println(addition.add(null,null));
        System.out.println(addition.add(null,"1"));
        System.out.println(addition.add("1",null));
        System.out.println(addition.add("","4"));
    }
}
