package com.leo.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TestBarrier {
	
	public static void main(String[] args) { 

	int n = 4;
	CyclicBarrier barrier  = new CyclicBarrier(n,new Runnable() {		
		public void run() {
			System.out.println(Thread.currentThread().getName() + "执行--byLeo");
		}
	});


	for(int i =0;i<n;i++)
	{
		if(i<n-1)
		{
			new Writer(barrier).start();
		}
		else
		{
			try{Thread.sleep(5000);}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			new Writer(barrier).start();
		}
	}
	
	
	}
	static class Writer extends Thread
	{

		public Writer(CyclicBarrier barrier) {
			super();
			this.barrier = barrier;
		}
		private CyclicBarrier barrier;
		@Override
		public void run() {
			// TODO Auto-generated method stub
			//super.run();
			System.out.println("thread:"+Thread.currentThread().getName()+"正在写入数据");
			try{
				Thread.sleep(5000);
				System.out.println("线程"+Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入完毕"); 
				try { 
					barrier.await(2000, TimeUnit.MILLISECONDS); 
                } catch (TimeoutException e) { 
                    // TODO Auto-generated catch block 
                	System.out.println("Exception throws");
                    e.printStackTrace(); 
                } 

			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		catch(BrokenBarrierException e){ 
            e.printStackTrace(); 
        } 
         
			System.out.println(Thread.currentThread().getName()+"所有线程写入完毕，继续处理其他任务...");
		}
		
	}
}



