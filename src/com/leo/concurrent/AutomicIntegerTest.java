package com.leo.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AutomicIntegerTest {
	   //public  static AtomicInteger count = new AtomicInteger(0);
	    public volatile  static int count = 0;  

	    public static void inc() {
	 
	        //这里延迟1毫秒，使得结果明显
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
	        //同时启动1000个线程，去进行i++计算，看看实际结果
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
	        //这里每次运行的值都有可能不同,可能为1000
	        final long end = System.currentTimeMillis();
	        System.out.println("time="+(end-start));
	        System.out.println("运行结果:Counter.count=" + AutomicIntegerTest.count);
	    }
	}