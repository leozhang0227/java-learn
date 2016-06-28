package com.leo.concurrent.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestReadWriteLock {
	private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	
	public static void main(String[] args)
	{
		final TestReadWriteLock test = new TestReadWriteLock();
		new Thread (){
			public void run(){
				test.get(Thread.currentThread());
			}
		}.start();
		new Thread (){
			public void run(){
				test.get(Thread.currentThread());
			}
		}.start();
	}
	
	//public synchronized void get(Thread thread)
	public  void get(Thread thread)
	{
		rwl.readLock().lock();
		
		try {
			long start = System.currentTimeMillis();
			while(System.currentTimeMillis() -start<10)
			{
				System.out.println(thread.getName() + "is reading");
			}
		} finally
		{
			rwl.readLock().unlock();
		}
		
		
	}

}
