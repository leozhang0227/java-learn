package com.leo.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AutomicIntegerTest {
	   //public  static AtomicInteger count = new AtomicInteger(0);
	    public volatile  static int count = 0;  

	    public static void inc() {
	 
	        //�����ӳ�1���룬ʹ�ý������
	        try {
	            Thread.sleep(1);
	        } catch (InterruptedException e) {
	        }
	       // count++;
	        //count.getAndIncrement();
	        synchronized(AutomicIntegerTest.class) {   

	        count++;
	        }
	    }
	 
	    public static void main(String[] args) throws InterruptedException {
	    	
	    	final CountDownLatch latch = new CountDownLatch(10000);
	        //ͬʱ����1000���̣߳�ȥ����i++���㣬����ʵ�ʽ��
	    	final long start = System.currentTimeMillis();
	        for (int i = 0; i < 10000; i++) {
	            new Thread(new Runnable() {
	                @Override
	                public void run() {
	                	AutomicIntegerTest.inc();
	                    latch.countDown();
	                }
	            }).start();
	        }
	        latch.await();
	        //����ÿ�����е�ֵ���п��ܲ�ͬ,����Ϊ1000
	        final long end = System.currentTimeMillis();
	        System.out.println("time="+(end-start));
	        System.out.println("���н��:Counter.count=" + AutomicIntegerTest.count);
	    }
	}