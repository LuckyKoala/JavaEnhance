package tech.zuosi.javaenhance.concurrent.unsynch;


/**
 * Created by iwar on 2017/7/3.
 */
public class Bank {
    /*private Lock bankLock;
    private Condition sufficientFunds;*/
    private double[] accounts;

    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        for (int i = 0; i < accounts.length; i++)
            accounts[i] = initialBalance;
        /*bankLock = new ReentrantLock();
        sufficientFunds = bankLock.newCondition();*/
    }

    public synchronized void transfer(int from, int to, double amount) throws InterruptedException {
        while (accounts[from] < amount)
            wait();
        System.out.print(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf(" %10.2f from %d to %d", amount, from, to);
        accounts[to] += amount;
        System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
        notifyAll();
        /*bankLock.lock();
        try {
            while (accounts[from] < amount)
                sufficientFunds.await();
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
        } finally {
            bankLock.unlock();
        }*/
    }

    public synchronized double getTotalBalance() {
        double sum = 0;
        for (double a : accounts)
            sum += a;

        return sum;
        /*bankLock.lock();
        try {
            double sum = 0;
            for (double a : accounts)
                sum += a;

            return sum;
        } finally {
            bankLock.unlock();
        }*/
    }

    public int size() {
        return accounts.length;
    }
}
