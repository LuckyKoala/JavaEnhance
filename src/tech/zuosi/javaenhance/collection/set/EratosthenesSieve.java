package tech.zuosi.javaenhance.collection.set;

import java.util.BitSet;

/**
 * Created by iwar on 2017/7/2.
 * 利用BitSet计算1-2000000之间的素数
 * From Java核心技术·卷一 程序清单13.8
 * Eratosthenes筛子
 */
public class EratosthenesSieve {
    public static void main(String[] args) {
        int n = 2000000;
        long start = System.currentTimeMillis();
        BitSet b = new BitSet(n+1);
        int count = 0;
        int i;
        for (i=2;i<=n;i++)
            b.set(i);
        i = 2;
        while (i*i<=n) {
            if (b.get(i)) {
                count++;
                int k = 2*i;
                while (k<=n) {
                    b.clear(k);
                    k+=i;
                }
            }
            i++;
        }
        while (i<=n) {
            if (b.get(i)) count++;
            i++;
        }
        long end = System.currentTimeMillis();
        System.out.println(count + " primes");
        System.out.println((end-start)+ " milliseconds");
    }
}
