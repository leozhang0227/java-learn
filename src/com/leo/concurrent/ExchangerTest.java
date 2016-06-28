package com.leo.concurrent;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerTest {

	public static void main(String[] args)
	{
		ExecutorService service = Executors.newCachedThreadPool();
		final Exchanger<String> exchanger = new Exchanger<String>();
		service.execute(new Runnable(){
			String data1 = "abc";
			@Override
			public void run(){
				try {                       
					System.out.println(Thread.currentThread().getName() +"��111�ڰ����� "+ data1+ " ������ȥ" );                       
					Thread.sleep((long) (Math.random()*1000));
					String data2 = (String) exchanger.exchange(data1);
					System.out.println(Thread.currentThread().getName() + "��111������ ��  "+ data2);
					} catch (InterruptedException e)
					{                       
						e.printStackTrace();
						}   
			}
		});
		service.execute(new Runnable(){
			String data1 = "def";
			@Override
			public void run(){
				try {
					System.out.println(Thread.currentThread().getName() +"���ڰ����� "+ data1+ " ������ȥ" );
					Thread.sleep((long) (Math.random()*1000));
					String data2 = (String) exchanger.exchange(data1);
					System.out.println(Thread.currentThread().getName() + "�������� ��  "+ data2);
					} catch (InterruptedException e)
					{                       
						e.printStackTrace();
						}   
			}
		});
	}
}
