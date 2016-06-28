package com.leo.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class TestSynchronousQueue {

	class Producer implements Runnable {
		private BlockingQueue<String> queue;
		List<String> objects = Arrays.asList("one", "two", "three");

		public Producer(BlockingQueue<String> q) {
			this.queue = q;
		}

		@Override
		public void run() {
			try {
				for (String s : objects) {
					queue.put(s);// �������ݷ��������
					System.out.printf("put:%s%n",s);
				}
				queue.put("Done");// ����ɵı�־
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
					System.out.println("take object is:"+obj);//�Ӷ����ж�ȡ����
					Thread.sleep(3000);     //����sleep��֤��Producer��put����ȥ��
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		BlockingQueue<String> q=new SynchronousQueue<String>();
		TestSynchronousQueue t=new TestSynchronousQueue();
		new Thread(t.new Producer(q)).start();
		new Thread(t.new Consumer(q)).start();
	}

}

