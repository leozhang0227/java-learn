package com.leo.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * FutureTask  ����һ��������Ҫ����ĳ���߳�ȥ����ʱ��������FutureTask
 * FutureTaskʵ����Runnable�ӿڣ���˿���ͨ��Thread�������򽻸�ExecutorService����
 * ���ṩ��һ�� get() ��������������ִ�еĽ����������ִ�н���֮ǰ�÷���������ֱ������ִ���꣬�����ؽ����
 * �൱��ͬ���ˡ�
 * @author Administrator
 *
 */
public class FutureTaskTest {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService pool = Executors.newCachedThreadPool();
		
		FutureTask<String> task = new FutureTask<String>(new Callable<String>() {

			@Override
			public String call() throws Exception {
				Thread.sleep(5000);
				return Thread.currentThread().getName();
			}
		});
		
		pool.execute(task);
		
		String result = task.get();
		
		
		System.out.println(result);  
		pool.shutdown();  //��Ҫע����ǣ�����̳߳��л��ж��������ִ�У��÷��������̳߳��������߳�ִ����Ϻ�رա�
                                  //���Ҫ���Ϲر��̳߳أ�������shutdownNow();������ʵ�֡�
}

}