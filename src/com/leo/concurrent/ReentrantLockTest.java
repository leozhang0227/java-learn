package com.leo.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
	static class NumberWrapper {
		public int value = 1;
	}
	public static void main(String[] args) throws InterruptedException {
        final ExecutorService exec = Executors.newFixedThreadPool(4);
        final ReentrantLock lock = new ReentrantLock();
        final Condition con = lock.newCondition();
        final int time = 5;
        final Runnable add = new Runnable() {
          public void run() {
            System.out.println("Pre " + lock);
            lock.lock();            
            try {
              con.await(time, TimeUnit.SECONDS);
            	//Thread.sleep(5000);
            } catch (InterruptedException e) {
              e.printStackTrace();
            } finally {
              System.out.println("Post " + lock.toString());
              lock.unlock();              
            }
          }
        };
        for(int index = 0; index < 4; index++)
          exec.submit(add);
        exec.shutdown();
      }
	/*public static void main(String[] args) {
		//��ʼ����������
		final Lock lock = new ReentrantLock();
		
		//��һ����������Ļ�������3
		final Condition reachThreeCondition = lock.newCondition();
		//�ڶ�����������Ļ�������6
		final Condition reachSixCondition = lock.newCondition();
		
		//NumberWrapperֻ��Ϊ�˷�װһ�����֣�һ�߿��Խ����ֶ���������������Ϊfinal
		//ע�����ﲻҪ��Integer, Integer �ǲ��ɱ����
		final NumberWrapper num = new NumberWrapper();
		//��ʼ��A�߳�
		Thread threadA = new Thread(new Runnable() {
			@Override
			public void run() {
				
				//��Ҫ�Ȼ����
				lock.lock();
				try {
					System.out.println("threadA start write");
					//A�߳������ǰ3����
					while (num.value <= 3) {
						System.out.println(num.value);
						num.value++;
					}
					//�����3ʱҪsignal������B�߳̿��Կ�ʼ��
					reachThreeCondition.signal();					
					
					//�ȴ����6������
					reachSixCondition.await();
					System.out.println("threadA start write");
					//���ʣ������
					while (num.value <= 9) {
						System.out.println(num.value);
						num.value++;
					}

				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}

		});


		Thread threadB = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					lock.lock();					
					//while (num.value <= 3) {
						//�ȴ�3�����ϵ��ź�
						reachThreeCondition.await();
					//}
					//�Ѿ��յ��źţ���ʼ���4��5��6
					System.out.println("threadB start write");
					while (num.value <= 6) {
						System.out.println(num.value);
						num.value++;
					}
					//4��5��6�����ϣ�����A�߳�6�������
					reachSixCondition.signal();
				}catch (InterruptedException e) {
					e.printStackTrace(); }
				finally {
					lock.unlock();
				}
			}

		});


		//���������߳�
		threadB.start();
		threadA.start();
	}*/
}

