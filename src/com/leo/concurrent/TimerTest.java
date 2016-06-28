package com.leo.concurrent;


import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest
{
	private static long start;

	public static void main(String[] args) throws Exception
	{

		TimerTask task1 = new TimerTask()
		{
			@Override
			public void run()
			{

				System.out.println("task1 invoked ! "
						+ (System.currentTimeMillis() - start));
				try
				{
					Thread.sleep(4000);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}

			}
		};
		TimerTask task2 = new TimerTask()
		{
			@Override
			public void run()
			{
				System.out.println("task2 invoked ! "
						+ (System.currentTimeMillis() - start));
			}
		};
		Timer timer = new Timer();
		start = System.currentTimeMillis();
		timer.schedule(task1, 1000);
		timer.schedule(task2, 3000);
		
		
				final TimerTask task11 = new TimerTask()
				{

					@Override
					public void run()
					{
						throw new RuntimeException();
					}
				};

				final TimerTask task21 = new TimerTask()
				{

					@Override
					public void run()
					{
						System.out.println("task21 invoked!");
					}
				};
				
				Timer timer1 = new Timer();
				timer1.schedule(task11, 100);
				timer1.scheduleAtFixedRate(task21, new Date(), 1000);
				
			
	}
}