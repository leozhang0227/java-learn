package com.leo.concurrent;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomic {

	static long randomTime() {
		return (long) (Math.random() * 1000);
	}

	public static void main(String[] args) {
		// ������100���ļ�
		final BlockingQueue<File> queue = new LinkedBlockingQueue<File>(100);
		// �̳߳�
		final ExecutorService exec = Executors.newFixedThreadPool(5);
		final File root = new File("e:\\dist\\blank");
		// ��ɱ�־
		final File exitFile = new File("");
		// ������
		final AtomicInteger rc = new AtomicInteger();
		// д����
		final AtomicInteger wc = new AtomicInteger();
		// ���߳�
		Runnable read = new Runnable() {
			public void run() {
				scanFile(root);
				scanFile(exitFile);
			}

			public void scanFile(File file) {
				if (file.isDirectory()) {
					File[] files = file.listFiles(new FileFilter() {
						public boolean accept(File pathname) {
							return pathname.isDirectory() || pathname.getPath().endsWith(".log");
						}
					});
					for (File one : files)
						scanFile(one);
				} else {
					try {
						int index = rc.incrementAndGet();
						System.out.println("Read0: " + index + " " + file.getPath());
						queue.put(file);
					} catch (InterruptedException e) {
					}
				}
			}
		};
		exec.submit(read);
		// �ĸ�д�߳�
		for (int index = 0; index < 4; index++) {
			// write thread
			final int num = index;
			Runnable write = new Runnable() {
				String threadName = "Write" + num;

				public void run() {
					while (true) {
						try {
							Thread.sleep(1000);
							int index = wc.incrementAndGet();
							File file = queue.take();
							// �����Ѿ��޶���
							if (file == exitFile) {
								// �ٴ����"��־"�����������߳������˳�
								queue.put(exitFile);
								break;
							}
							System.out.println(threadName + ": " + index + " " + file.getPath());
						} catch (InterruptedException e) {
						}
					}
				}

			};
			exec.submit(write);
		}
		exec.shutdown();
	}

}