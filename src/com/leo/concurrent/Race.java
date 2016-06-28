package com.leo.concurrent;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Runner implements Runnable {

	private CyclicBarrier barrier;

	private String name;

	public Runner(CyclicBarrier barrier, String name) {
		super();
		this.barrier = barrier;
		this.name = name;
	}

	@Override
	public void run() {
		try {
			int i = new Random().nextInt(8);
			Thread.sleep(1000 * i);
			System.out.println(name + " 准备OK."+ ",i="+i);
			System.out.println("已经准备好了:"+(barrier.getNumberWaiting()+1));
			barrier.await();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println(name + " Go!!");
	}
}

public class Race {

	public static void main(String[] args) throws IOException, InterruptedException {
		CyclicBarrier barrier = new CyclicBarrier(3,new Runnable() {		
			public void run() {
				System.out.println(Thread.currentThread().getName() + "执行--byLeo");
			}});

		ExecutorService executor = Executors.newCachedThreadPool();
		executor.submit(new Thread(new Runner(barrier, "zhangsan")));
		executor.submit(new Thread(new Runner(barrier, "lisi")));
		executor.submit(new Thread(new Runner(barrier, "wangwu")));

		executor.shutdown();
	}

}
