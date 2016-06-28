package com.leo.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableAndFutureTest2 {

	public static void main(String[] args) {
		
		ExecutorService threadpool = Executors.newFixedThreadPool(1);
		Future<String> future = threadpool.submit(new Callable<String>()
				{
				public String call() throws Exception
				{
				return "XY";
				}
				});
		try
		{
		// 做其他的事情
		Thread.sleep(5000);
		System.out.println(future.get());
		}
		catch (InterruptedException e)
		{
		e.printStackTrace();
		}
		catch (ExecutionException e)
		{
		e.printStackTrace();
		}
		
		

	}

}
