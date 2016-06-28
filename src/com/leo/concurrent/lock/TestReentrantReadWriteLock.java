package com.leo.concurrent.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;


public class TestReentrantReadWriteLock {
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
     
    public static void main(String[] args)  {
        final TestReentrantReadWriteLock test = new TestReentrantReadWriteLock();
         
        new Thread(){
            public void run() {
                test.get(Thread.currentThread());
            };
        }.start();
         
        new Thread(){
            public void run() {
                test.get(Thread.currentThread());
            };
        }.start();
         
    }  
     
    public void get(Thread thread) {
        rwl.readLock().lock();
       // rwl.writeLock().lock();
    	try {
            long start = System.currentTimeMillis();
             
            while(System.currentTimeMillis() - start <= 1) {
                System.out.println(thread.getName()+"���ڽ��ж�����");
            }
            System.out.println(thread.getName()+"���������");
        } finally {
            rwl.readLock().unlock();
        	//rwl.writeLock().unlock();
        }
    }
}