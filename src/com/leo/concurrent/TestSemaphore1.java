package com.leo.concurrent;

import java.util.concurrent.Semaphore;

public class TestSemaphore1 {
	
	public static void main(String[]args){
		int n =8; // 8 worker
		Semaphore s = new Semaphore(5);//5 machines
		for(int i =0 ;i<8; i++)
		{
			new Worker(i,s).start();
		}
	}
	
	static class Worker extends Thread{
		private int num=0;
		private Semaphore semaphore=null;
		Worker(int num,Semaphore semaphore)
		{
			this.num=num;
			this.semaphore= semaphore;
		}
		@Override
		public void run() {
			try {
				semaphore.acquire();
				System.out.println("The worker" + this.num +"is working...");
				Thread.sleep(2000);
				System.out.println("The worker" + this.num +"release the machine");
				semaphore.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
