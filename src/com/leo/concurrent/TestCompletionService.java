package com.leo.concurrent;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

public class TestCompletionService {
	
	public static void main(String[]args) throws Exception
	{
		TestCompletionService ts = new TestCompletionService();
		ts.count2();
		ts.count1();
	}
	
	public void count1() throws Exception
	{
		ExecutorService service = Executors.newCachedThreadPool();
		BlockingQueue<Future<Integer>> queue = new LinkedBlockingQueue<Future<Integer>>();
		for(int i=0;i<10;i++)
		{
			Future<Integer> future = service.submit(getTask());
			queue.add(future);
		}
		int sum =0;
		int queueSize=queue.size();
		for(int i=0;i<queueSize;i++)
		{
			sum+=queue.take().get();
		}
		System.out.println("总数："+ sum);
	    service.shutdown();
	}
	
	public void count2() throws InterruptedException, ExecutionException{
		ExecutorService service = Executors.newCachedThreadPool();
		CompletionService<Integer> cs = new ExecutorCompletionService<Integer>(service);
		for(int i = 0;i<10; i++)
		{
			cs.submit(getTask());
		}
		int sum = 0;
		for(int i =0;i <10;i++)
		{
			Future<Integer> future = cs.take();
			sum+=future.get();
		}
		System.out.println("总数："+ sum);
	    service.shutdown();
	}

	public Callable<Integer> getTask()
	{
		final Random rand = new Random();
		Callable<Integer> task = new Callable<Integer>(){

			@Override
			public Integer call() throws Exception {
				int i = rand.nextInt(10);
				int j = rand.nextInt(10);
				int sum = i*j;
				System.out.print(sum + "\t");
				return sum;
			}
			
		};
		return task;
	}
}
