package com.leo.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * FutureTask  当有一个任务需要交给某个线程去处理时，可以用FutureTask
 * FutureTask实现了Runnable接口，因此可以通过Thread启动，或交给ExecutorService处理
 * 并提供了一个 get() 方法，返回任务执行的结果。在任务执行结束之前该方法阻塞，直到任务执行完，并返回结果。
 * 相当于同步了。
 * @author Administrator
 *
 */
public class FutureTaskTest {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService pool = Executors.newCachedThreadPool();
		
		FutureTask<String> task = new FutureTask<String>(new Callable<String>() {

			@Override
			public String call() throws Exception {
				Thread.sleep(5000);
				return Thread.currentThread().getName();
			}
		});
		
		pool.execute(task);
		
		String result = task.get();
		
		
		System.out.println(result);  
		pool.shutdown();  //需要注意的是，如果线程池中还有多个方法在执行，该方法会在线程池中所有线程执行完毕后关闭。
                                  //如果要马上关闭线程池，可以用shutdownNow();方法来实现。
}

}