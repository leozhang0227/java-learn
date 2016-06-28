package com.leo.concurrent.lock;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock {
    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
    Lock lock = new ReentrantLock();    //ע������ط�
    public static void main(String[] args)  {
        final TestReentrantLock test = new TestReentrantLock();
         
        new Thread(){
            public void run() {
                test.insert(Thread.currentThread());
            };
        }.start();
         
        new Thread(){
            public void run() {
                test.insert(Thread.currentThread());
            };
        }.start();
    }  
     
    public void insert(Thread thread) {   
    	 //Lock lock = new ReentrantLock();    //ע������ط�
    	/* lock.lock();
        try {
            System.out.println(thread.getName()+"�õ�����");
            for(int i=0;i<5;i++) {
                arrayList.add(i);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }finally {
            System.out.println(thread.getName()+"�ͷ�����");
            lock.unlock();
        }*/
         if(lock.tryLock()) {
             try {
                 System.out.println(thread.getName()+"�õ�����");
                 for(int i=0;i<5;i++) {
                     arrayList.add(i);
                 }
             } catch (Exception e) {
                 // TODO: handle exception
             }finally {
                 System.out.println(thread.getName()+"�ͷ�����");
                 lock.unlock();
             }
         } else {
             System.out.println(thread.getName()+"��ȡ��ʧ��");
         }
    }
}