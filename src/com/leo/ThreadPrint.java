package com.leo;

import java.util.concurrent.CountDownLatch;

/**
 * ���������߳�
 * ��һ�̴߳�ӡ123
 * ֪ͨ�ڶ�����ӡ456
 * ��֪ͨ��һ���̴߳�ӡ789
 */
public class ThreadPrint {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(1);

        new Thread(){
            public void run() {
                System.out.println("���߳� (" + Thread.currentThread().getName() + "): 456");
                latch.countDown();
            };
        }.start();

        try {
            System.out.println("���̴߳�ӡ (" + Thread.currentThread().getName() + "): 123");
            latch.await();
            System.out.println("����ִ�����߳�");
            System.out.println("���̴߳�ӡ (" + Thread.currentThread().getName() + "): 789");
            System.out.println("���߳�ִ�����");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
