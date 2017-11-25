package tech.zuosi.javaenhance.concurrent.unsynch;

/**
 * Created by iwar on 2017/7/3.
 */
public class UnsynchBankTest {
    public static final int NACCOUNTS = 100;
    public static final int INITIABL_BALANCE = 1000;

    public static void main(String[] args) {
        Bank b = new Bank(NACCOUNTS, INITIABL_BALANCE);
        for (int i = 0; i < NACCOUNTS; i++) {
            TransferRunnable r = new TransferRunnable(b, i, INITIABL_BALANCE);
            Thread t = new Thread(r);
            t.start();
        }
    }
}
