package com.leo.concurrent.atomic;

import java.util.concurrent.atomic.AtomicReference;

public class TestAtomicReference {

	public final static AtomicReference <String>ATOMIC_REFERENCE = new AtomicReference<String>("abc");  
	public static void main(String []args) {  
        for(int i = 0 ; i < 100 ; i++) {  
            final int num = i;  
            new Thread() {  
                public void run() {  
                    try {  
                        Thread.sleep(Math.abs((int)(Math.random() * 100)));  
                    } catch (InterruptedException e) {  
                        e.printStackTrace();  
                    }  
                    if(ATOMIC_REFERENCE.compareAndSet("abc", new String("abc"))) {  
                        System.out.println("我是线程：" + num + ",我获得了锁进行了对象修改！");  
                    }  
                }  
            }.start();  
        }  
    }  
}  	
