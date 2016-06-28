package com.leo.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestInterruptibly {
	
	private Lock lock = new ReentrantLock();
	public static void main(String[] args)
	{
		TestInterruptibly test = new TestInterruptibly();
		MyThread1 thread1 = new MyThread1(test);
		MyThread1 thread2 = new MyThread1(test);
		thread1.start();
		thread2.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread2.interrupt();
	}
	
	public void insert(Thread thread)throws InterruptedException
	{
		lock.lockInterruptibly();
		
		try {
			System.out.println(thread.getName()+"得到了锁");
			long startTime = System.currentTimeMillis();
			for(;;) {
			   
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
            System.out.println(Thread.currentThread().getName()+"执行finally");
            lock.unlock();
            System.out.println(thread.getName()+"释放了锁");
        }  
		
	}

}

class MyThread1 extends Thread{
	TestInterruptibly test = null;
	MyThread1(TestInterruptibly test)
	{
		this.test=test;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//super.run();
		try {
			test.insert(this);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block			
			System.out.println(Thread.currentThread().getName()+"被中断");
		}
	}
	
}
