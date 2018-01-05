package tech.zuosi.javaenhance.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleTaskByExecutor {
    public static void main(String[] args) {
        //Print 'Hello world' every 3 seconds
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(() -> System.out.println("Hello world"), 0, 3, TimeUnit.SECONDS);
    }
}
