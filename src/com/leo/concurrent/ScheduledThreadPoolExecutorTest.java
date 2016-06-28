package com.leo.concurrent;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorTest {
	private static long start;

	public static void main(String[] args) {
		/**
		 * 工厂创建 ScheduledThreadPool
		 */
		ScheduledExecutorService newScheduledThreadPool = Executors
				.newScheduledThreadPool(2);

		TimerTask task1 = new TimerTask() {
			@Override
			public void run() {
				try {

					throw new RuntimeException();
					//System.out.println("task1 invoked ! "
					//		+ (System.currentTimeMillis() - start));
					//Thread.sleep(3000);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		};

		TimerTask task2 = new TimerTask() {
			@Override
			public void run() {
				System.out.println("task2 invoked ! "
						+ (System.currentTimeMillis() - start));
			}
		};
		start = System.currentTimeMillis();
		newScheduledThreadPool.schedule(task1, 1000, TimeUnit.MILLISECONDS);
		newScheduledThreadPool.scheduleAtFixedRate(task2, 0 , 1000, TimeUnit.MILLISECONDS);
	}
}