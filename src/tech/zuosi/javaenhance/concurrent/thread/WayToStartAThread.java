package tech.zuosi.javaenhance.concurrent.thread;

/**
 * Created by iwar on 2017/6/23.
 */
public class WayToStartAThread {
    public static void main(String[] args) {
        new Thread(new HelloRunnable()).start();
        new Thread(new HelloThread()).start();
    }
}

class HelloRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello from a thread whose code is defined in a class implement Runnable");
    }
}

class HelloThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello from a thread whose code is defined in a class extends Thread");
    }
}
