package com.leo.concurrent;

import java.util.concurrent.Semaphore;

public class TestSemaphore {
	
	public static void main(String[] args)
	{
		int N=8;
		Semaphore semaphore = new Semaphore(5);
		for(int i=0;i<N;i++)
		{				
			new Worker(i,semaphore).start();
		}
	}
	
	static class Worker extends Thread{ 
        private int num; 
        private Semaphore semaphore; 
        public Worker(int num,Semaphore semaphore){ 
            this.num = num; 
            this.semaphore = semaphore; 
        } 
          
        @Override
        public void run() { 
            try { 
                semaphore.acquire(); 
                System.out.println("����"+this.num+"ռ��һ������������..."); 
                Thread.sleep(2000); 
                System.out.println("����"+this.num+"�ͷų�����"); 
                semaphore.release();             
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            } 
        } 
    } 


}
