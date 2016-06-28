package com.leo.concurrent;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {
	
	public static void main(String[] args)
	{
		final CountDownLatch latch = new CountDownLatch(2);
		new Thread(){

			@Override
			public void run() {
				 try {
					 System.out.println("���߳�"+Thread.currentThread().getName()+"����ִ��"); 
               
					Thread.sleep(3000);
				
                System.out.println("���߳�"+Thread.currentThread().getName()+"ִ�����"); 
                latch.countDown();
				 } catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
			}
			
		}.start();
		new Thread(){

			@Override
			public void run() {
				 try {
					 System.out.println("���߳�"+Thread.currentThread().getName()+"����ִ��"); 
               
					Thread.sleep(3000);
				
                System.out.println("���߳�"+Thread.currentThread().getName()+"ִ�����"); 
                latch.countDown();
				 } catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
			}
			
		}.start();
		
		System.out.println("�ȴ�2�����߳�ִ�����..."); 
        try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        System.out.println("2�����߳��Ѿ�ִ�����"); 
        System.out.println("����ִ�����߳�"); 
		
	}
	/*
	     public static void main(String[] args) {     
	         final CountDownLatch latch = new CountDownLatch(2); 
	           
	         new Thread(){ 
	             public void run() { 
	                 try { 
	                     System.out.println("���߳�"+Thread.currentThread().getName()+"����ִ��"); 
	                    Thread.sleep(3000); 
	                    System.out.println("���߳�"+Thread.currentThread().getName()+"ִ�����"); 
	                    System.out.println("kankan1"); 
	                    latch.countDown(); 
	                    
	                } catch (InterruptedException e) { 
	                    e.printStackTrace(); 
	                } 
	             }; 
	         }.start(); 
	           
	         new Thread(){ 
	             public void run() { 
	                 try { 
	                     System.out.println("���߳�"+Thread.currentThread().getName()+"����ִ��"); 
	                     Thread.sleep(3000); 
	                     System.out.println("���߳�"+Thread.currentThread().getName()+"ִ�����"); 
	                     System.out.println("kankan2"); 
	                     latch.countDown(); 
	                     
	                } catch (InterruptedException e) { 
	                    e.printStackTrace(); 
	                } 
	             }; 
	         }.start(); 
	           
	         try { 
	             System.out.println("�ȴ�2�����߳�ִ�����..."); 
	            latch.await(); 
	            System.out.println("2�����߳��Ѿ�ִ�����"); 
	            System.out.println("����ִ�����߳�"); 
	        } catch (InterruptedException e) { 
	            e.printStackTrace(); 
	        } 
	     }  */
	}


