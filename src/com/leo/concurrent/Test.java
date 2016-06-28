package com.leo.concurrent;

import java.io.IOException;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {
	//测试 测试 
	public static void main(String[] args) throws IOException, InterruptedException {
	/*	ExecutorService service = Executors.newFixedThreadPool(4);
		for (int i = 0; i < 4; i++) {
			Runnable run = new Runnable() {
				@Override
				public void run() {
					System.out.println("thread start");
				}
			};
			service.execute(run);
		}
		service.shutdown();
		service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
		System.out.println("all thread complete");*/	
		
		
		
		
		
		         final CountDownLatch latch = new CountDownLatch(2); 
		           
		         new Thread(){ 
		             public void run() { 
		                 try { 
		                     System.out.println("���߳�"+Thread.currentThread().getName()+"����ִ��"); 
		                    Thread.sleep(3000); 
		                    System.out.println("���߳�"+Thread.currentThread().getName()+"ִ�����"); 
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
		        
		        
		        
		        /*
		
		
		int N = 4; 
        CyclicBarrier barrier  = new CyclicBarrier(N,new Runnable() { 
            @Override
            public void run() { 
                System.out.println("��ǰ�߳�"+Thread.currentThread().getName());     
            } 
        }); 
          
        for(int i=0;i<N;i++) 
            new Writer(barrier).start(); 
    }  
    static class Writer extends Thread{ 
        private CyclicBarrier cyclicBarrier; 
        public Writer(CyclicBarrier cyclicBarrier) { 
            this.cyclicBarrier = cyclicBarrier; 
        } 
  
        @Override
        public void run() { 
            System.out.println("�߳�"+Thread.currentThread().getName()+"����д�����..."); 
            try { 
                Thread.sleep(10000);      //��˯����ģ��д����ݲ��� 
                System.out.println("�߳�"+Thread.currentThread().getName()+"д�������ϣ��ȴ������߳�д�����"); 
                cyclicBarrier.await(); 
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            }catch(BrokenBarrierException e){ 
                e.printStackTrace(); 
            } 
            System.out.println("�����߳�д����ϣ���������������..."); 
        } 
  */
		     }  
		     
		  
		
	
}