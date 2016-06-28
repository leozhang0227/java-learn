package com.leo.concurrent;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableAndFutureTest {

	public static void main(String[] args) {
		
		/*Callable<Integer> callable = new Callable<Integer>()
				{
					public Integer call() throws Exception
					{
						return new Random().nextInt(100);
					}
				};
				
		FutureTask<Integer> future = new FutureTask<Integer>(callable);
		new Thread(future).start();*/
		Callable<Integer> callable = new Callable<Integer>()
				{

					@Override
					public Integer call() throws Exception {
						// TODO Auto-generated method stub
						return new Random().nextInt(100);
					}
					
				};
		
		FutureTask<Integer> future = new FutureTask<Integer>(callable);
		new Thread(future).start();
		try{
			//do somethingelse
			Thread.sleep(5000);
			try {
				System.out.println(future.get());
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(InterruptedException e )
		{
			e.printStackTrace();
		}

	}

}
