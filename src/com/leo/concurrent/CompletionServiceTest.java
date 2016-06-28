package com.leo.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletionServiceTest implements Callable<String> {
	private int id;

	public CompletionServiceTest(int i) {
		this.id = i;
	}

	public static void main(String[] args) throws Exception {
		ExecutorService service = Executors.newCachedThreadPool();
		CompletionService<String> completion = new ExecutorCompletionService<String>(service);
		
		for(int i=0;i<10;i++)
		{
			completion.submit(new CompletionServiceTest(i));
		}
		for(int i=0;i<10;i++)
		{
			System.out.println(completion.take().get());
		}
		
	}

	public String call() throws Exception {
		Integer time = (int)(Math.random()*1000);
		
		//System.out.println(this.id+" start");
		Thread.sleep(time);
		System.out.println(this.id+" end");
		
		return this.id +"" ;
	}
}
