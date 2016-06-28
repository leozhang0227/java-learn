package com.leo.concurrent;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockQueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(3);
		final Random random = new Random();
		class Producer implements Runnable{
			@Override 
			public void run(){
				while(true)
				{
					try {   
	                    int i=random.nextInt(100); 
	                    System.out.println("i=="+i);
	                    queue.put(i);//�����дﵽ����ʱ�򣬻��Զ������   
	                    if(queue.size()==3)   
	                    {   
	                        System.out.println("full");   
	                    }   
	                } catch (InterruptedException e) {   
	                    e.printStackTrace();   
	                }  
				}
			}
		}
		class Consumer implements Runnable{
			@Override 
			public void run(){
				 while(true){   
             try {   
                 int i = queue.take();   
                 System.out.println("j=="+i);
                 Thread.sleep(1000);   
             } catch (InterruptedException e) {   
                e.printStackTrace();   
            }   
         }   

			}
		}
		
		new Thread(new Producer()).start();
		new Thread(new Consumer()).start();
		

	}
	
	
	

}
