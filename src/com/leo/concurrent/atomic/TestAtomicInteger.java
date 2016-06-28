package com.leo.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomicInteger {
	public final static AtomicInteger TEST_INTEGER = new AtomicInteger(0);
	
	public static void main(String[] args)
	{
		Thread[] ts = new Thread[10];
		for(int i = 0; i<10;i++)
		{
			final int num = i;
			ts[i]= new Thread(){
				
				public void run(){
					try {  
                        Thread.sleep(1000);  
                    } catch (InterruptedException e) {  
                        e.printStackTrace();  
                    }  
                    int now = TEST_INTEGER.incrementAndGet();  
                    System.out.println("我是线程：" + num + "，我得到值了，增加后的值为：" + now);  
                 } 
				
			};
			ts[i].start();
		}
	}
	
}
