package com.leo.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallableAndFutureTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService threadPool = Executors.newCachedThreadPool();
		CompletionService<Integer> cs = new ExecutorCompletionService<Integer>(
				threadPool);

		for (int i = 1; i <= 10; i++) {
			final int taskID = i;
			cs.submit(new Callable<Integer>() {
				public Integer call() throws Exception {	
					Integer time = (int)(Math.random()*1000);					
					//System.out.println(this.id+" start");
					Thread.sleep(time);
					System.out.println("taskId====:"+taskID);
					return taskID;
					
				}
			});
			
		}

		for (int i = 1; i <= 10; i++) {
			try {
				System.out.println("ok=="+ cs.take().get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}

	}

}
