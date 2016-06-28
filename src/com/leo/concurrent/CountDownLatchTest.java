package com.leo.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {
	
	public static void main(String[] args)
	{
		ExecutorService service = Executors.newCachedThreadPool(); //create a thread pool
		final CountDownLatch latchOrder = new CountDownLatch(1); //order
		final CountDownLatch latchAnswer = new CountDownLatch(3);//3 soldier
		for(int i=0; i<3;i++)
		{
			Runnable runnable = new Runnable(){
				public void run(){
					try
						{
							System.out.println(Thread.currentThread().getName() +" is ready to get order");
							latchOrder.await();
							System.out.println(Thread.currentThread().getName() +" got the order");
							Thread.sleep((long)(Math.random()*10000));
							System.out.println(Thread.currentThread().getName() +" finish the order");
							latchAnswer.countDown();
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
			}
			};
			service.execute(runnable);
		}
		
		try{
			Thread.sleep((long)(Math.random()*10000));
			System.out.println(Thread.currentThread().getName() +"is going to send out the order");
			latchOrder.countDown();
			System.out.println(Thread.currentThread().getName() +"order is send, waiting the result");
			latchAnswer.await();
			System.out.println(Thread.currentThread().getName() +"get all the results");
		}
		catch(Exception e)
		{e.printStackTrace();}
		service.shutdown();
	}

}
