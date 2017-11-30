package tech.zuosi.javaenhance.concurrent.thread;

public class Join {
    public static void main(String args[])
            throws InterruptedException {
        Join join = new Join();
        Thread first = new Thread(join::printFirst);
        Thread last = new Thread(() -> join.printLast(first));

        last.start();
        first.start();
    }

    private void printFirst() {
        System.out.println("first");
    }

    private void printLast(Thread joinThread) {
        try {
            joinThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("last");
    }
}
