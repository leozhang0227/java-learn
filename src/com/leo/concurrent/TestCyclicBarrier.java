package com.leo.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrier {
	
	private static CyclicBarrier barrier = new CyclicBarrier(3,
			new Runnable(){

				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName()+"all the runner are ready, let's go!!!!");
					
				}});
	public static void main(String[] args)
	{
		Runner runner1 = new Runner(barrier);
		Runner runner2 = new Runner(barrier);
		Runner runner3 = new Runner(barrier);
		runner1.start();
		runner2.start();
		runner3.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("again");
		
		Runner runner6 = new Runner(barrier);
		Runner runner4 = new Runner(barrier);
		Runner runner5 = new Runner(barrier);
		runner6.start();
		runner4.start();
		runner5.start();
		
	}
	static class Runner extends Thread
	{
		private CyclicBarrier barrier;

		public Runner(CyclicBarrier barrier) {
			super();
			this.barrier = barrier;
		}

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + "is ready");
			try {
				barrier.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "is finished");
		}
		
	}
}


