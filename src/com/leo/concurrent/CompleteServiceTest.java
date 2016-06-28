package com.leo.concurrent;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CompleteServiceTest {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException
	{
		ExecutorService  exec = Executors.newCachedThreadPool();
		CompletionService<Integer> cse= new ExecutorCompletionService<Integer>(exec);
		
		for(int i =0;i<5;i++)
		{
			cse.submit(new Task());
		}
		exec.shutdown();
		int index =1, count=0;
		while(count<5)
		{
			Future<Integer> f = cse.poll();
			if( f==null)
			{
				System.out.println("no result now");
			}
			else
			{
				
				System.out.println("result="+f.get());
				count++;
			}
			index++;  
            TimeUnit.MILLISECONDS.sleep(500);  
		}
		System.out.println("index=="+index);
		System.out.println("count="+count);
	}

}
class Task implements Callable<Integer> 
{

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		Random result = new Random();
		TimeUnit.SECONDS.sleep(result.nextInt(7));  
        return result.nextInt();  
		//return null;
	}
	
}
