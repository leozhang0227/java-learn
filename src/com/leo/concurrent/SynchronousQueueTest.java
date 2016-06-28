package com.leo.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueTest {

	class Producer implements Runnable    {
		private BlockingQueue<String> queue;
		List<String> objects = Arrays.asList("one", "two", "three");

		public Producer(BlockingQueue<String> q) {
			this.queue = q;
		}

		@Override
		public void run() {
			try {
				for (String s : objects) {
					System.out.printf("put:%s%n",s);
					queue.put(s);// �������ݷ��������
					
				}
				//queue.put("Done");// ����ɵı�־
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	class Consumer implements Runnable {
		private BlockingQueue<String> queue;

		public Consumer(BlockingQueue<String> q) {
			this.queue = q;
		}

		@Override
		public void run() {
			String obj = null;
			try {
				while (!((obj = queue.take()).equals("Done"))) {
					System.out.println("read==="+obj);//�Ӷ����ж�ȡ����
					Thread.sleep(3000);     //����sleep��֤��Producer��put����ȥ��
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		BlockingQueue<String> q=new SynchronousQueue<String>();
		SynchronousQueueTest t=new SynchronousQueueTest();
		new Thread(t.new Producer(q)).start();
		new Thread(t.new Consumer(q)).start();
	}

}