package com.leo;

import java.util.concurrent.CountDownLatch;

/**
 * 创建两个线程
 * 第一线程打印123
 * 通知第二个打印456
 * 再通知第一个线程打印789
 */
public class ThreadPrint {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(1);

        new Thread(){
            public void run() {
                System.out.println("子线程 (" + Thread.currentThread().getName() + "): 456");
                latch.countDown();
            };
        }.start();

        try {
            System.out.println("主线程打印 (" + Thread.currentThread().getName() + "): 123");
            latch.await();
            System.out.println("继续执行主线程");
            System.out.println("主线程打印 (" + Thread.currentThread().getName() + "): 789");
            System.out.println("主线程执行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
