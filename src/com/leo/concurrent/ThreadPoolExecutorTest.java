package com.leo.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {

	public static void main(String[] args) {     
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 5, 200, TimeUnit.MILLISECONDS,  
                new ArrayBlockingQueue<Runnable>(3)); 
          
        for(int i=0;i<8;i++){ 
            MyTask myTask = new MyTask(i); 
            executor.execute(myTask); 
            System.out.println("�̳߳����߳���Ŀ��"+executor.getPoolSize()+"�������еȴ�ִ�е�������Ŀ��"+ 
            executor.getQueue().size()+"����ִ������������Ŀ��"+executor.getCompletedTaskCount()); 
        } 
        executor.shutdown(); 
    }  
} 
 
 
class MyTask implements Runnable { 
   private int taskNum; 
     
   public MyTask(int num) { 
       this.taskNum = num; 
   } 
     
   @Override
   public void run() { 
       System.out.println("����ִ��task "+taskNum); 
       try { 
           Thread.currentThread().sleep(4000); 
       } catch (InterruptedException e) { 
           e.printStackTrace(); 
       } 
       System.out.println("task "+taskNum+"ִ�����"); 
   } 
}
