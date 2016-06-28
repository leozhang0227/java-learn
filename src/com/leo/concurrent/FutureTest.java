package com.leo.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTest {

	public static void main(String[] args) throws InterruptedException,ExecutionException{   
		       /* final ExecutorService exec = Executors.newFixedThreadPool(5);   
		           
		        Callable call = new Callable(){   
		            public String call() throws Exception{   
		                Thread.sleep(1000 * 5);   
		                return "Other less important but longtime things.";   
		            }   
		        };   
		        Future task = exec.submit(call);   
		        //重要的事情   
		        Thread.sleep(1000 * 3);   
		        System.out.println("Let's do important things.");   
		        //其他不重要的事情   
		        String obj = (String)task.get();   
		        System.out.println(obj);   
		        //关闭线程池   
		        exec.shutdown();   */
		System.out.println( inverse(12345) );
	}

	public static int inverse(int a ){
		
		int x = a % 10;
		System.out.println("x="+x);
		if( a / 10 == 0){
			Integer m = new Integer(new Integer(x).toString());
			System.out.println("m="+m);
			return m;
		}
		else{
			Integer n = new Integer(new Integer(x).toString() + inverse(a/10));
			System.out.println("n="+n);
			return n;
		}
		
		
	}
		


		    }   



