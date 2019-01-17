package tech.zuosi.javaenhance.sugar;

/**
 * Created by LuckyKoala on 18-10-9.
 */
public class TryFinally {
    static int test() {
        int x = 1;
        try {
            return x;
        } finally {
            ++x;
        }
    }

    public static void main(String[] args) {
        System.out.println(TryFinally.test());
    }
}
