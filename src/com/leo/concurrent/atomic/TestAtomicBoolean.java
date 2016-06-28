package com.leo.concurrent.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

public class TestAtomicBoolean {

	public final static AtomicBoolean Test_BOOLEAN = new AtomicBoolean();
	
	public static void main(String[] args)
	{
		for(int i=0;i<10;i++)
		{
			new Thread(){
				public void run(){
					 try {  
	                        Thread.sleep(1000);  
	                    } catch (InterruptedException e) {  
	                        e.printStackTrace();  
	                    }  
					if(Test_BOOLEAN.compareAndSet(false, true))
					System.out.println("successful");
				}
			}.start();
		}
	}
}
