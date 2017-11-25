package tech.zuosi.javaenhance.concurrent.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by iwar on 2017/6/23.
 */
public class AtomicReferenceABATest {
    public final static AtomicReference<String> ATOMIC_REFERENCE = new AtomicReference<String>("abc");

    public static void main(String []args) {
        for(int i = 0 ; i < 100 ; i++) {
            final int num = i;
            new Thread(() -> {
                try {
                    Thread.sleep(Math.abs((int)(Math.random() * 100)));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(ATOMIC_REFERENCE.compareAndSet("abc" , "abc2")) {
                    System.out.println("我是线程：" + num + ",我获得了锁进行了对象修改！");
                }
            }).start();
        }
        new Thread(() -> {
            while(!ATOMIC_REFERENCE.compareAndSet("abc2", "abc"));
            System.out.println("已经改为原始值！");
        }).start();
    }
}
