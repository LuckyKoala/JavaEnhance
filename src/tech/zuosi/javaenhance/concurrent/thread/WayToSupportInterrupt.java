package tech.zuosi.javaenhance.concurrent.thread;

public class WayToSupportInterrupt {
    public static void main(String[] args) {
        final WayToSupportInterrupt interrupt = new WayToSupportInterrupt();
        Thread checkStatus = new Thread(interrupt::checkStatus);
        Thread handleException = new Thread(interrupt::handleException);
        checkStatus.start();
        handleException.start();

        checkStatus.interrupt();
        handleException.interrupt();
    }

    private void checkStatus() {
        if(Thread.interrupted()) {
            System.out.println("checkStatus thread interrupted");
            return;
        }
        System.out.println("checkStatus()");
    }

    private void handleException() {
        //Pause for 4 seconds
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            System.out.println("handleException thread interrupted");
            return;
        }
        //Print a message
        System.out.println("handleException()");
    }
}
