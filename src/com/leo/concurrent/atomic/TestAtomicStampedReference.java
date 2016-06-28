package com.leo.concurrent.atomic;

import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class TestAtomicStampedReference {

	public final static AtomicStampedReference <String>ATOMIC_REFERENCE = new AtomicStampedReference<String>("abc" , 0);  
	public final static AtomicMarkableReference <String> ATOMIC_MARKABLE = new AtomicMarkableReference<String>("abc" , false);  
    
    public static void main(String []args) {  
      /*  for(int i = 0 ; i < 100 ; i++) {  
            final int num = i;  
            final int stamp = ATOMIC_REFERENCE.getStamp();  
            new Thread() {  
                public void run() {  
                    try {  
                        Thread.sleep(Math.abs((int)(Math.random() * 100)));  
                    } catch (InterruptedException e) {  
                        e.printStackTrace();  
                    }  
                    if(ATOMIC_REFERENCE.compareAndSet("abc" , "abc2" , stamp , stamp + 1)) {  
                        System.out.println("我是线程：" + num + ",我获得了锁进行了对象修改！");  
                        System.out.println("stamp="+ATOMIC_REFERENCE.getStamp());
                    }  
                }  
            }.start();  
        }  
        new Thread() {  
            public void run() {  
                int stamp = ATOMIC_REFERENCE.getStamp();  
                while(!ATOMIC_REFERENCE.compareAndSet("abc2", "abc" , stamp , stamp + 1));  
                System.out.println("已经改回为原始值！");  
                System.out.println("stamp="+ATOMIC_REFERENCE.getStamp());
            }  
        }.start();  */
    	
    	for(int i = 0 ; i < 100 ; i++) {  
            final int num = i;              
            new Thread() {  
                public void run() {  
                    try {  
                        Thread.sleep(Math.abs((int)(Math.random() * 100)));  
                    } catch (InterruptedException e) {  
                        e.printStackTrace();  
                    }  
                    if(ATOMIC_MARKABLE.compareAndSet("abc" , "abc2" , false , true)) {  
                        System.out.println("我是线程：" + num + ",我获得了锁进行了对象修改！");  
                        //System.out.println("stamp="+ATOMIC_MARKABLE.getStamp());
                    }  
                }  
            }.start();  
        }  
        new Thread() {  
            public void run() {  
                
                while(!ATOMIC_MARKABLE.compareAndSet("abc2", "abc" , true , false));  
                System.out.println("已经改回为原始值！");  
               // System.out.println("stamp="+ATOMIC_REFERENCE.getStamp());
            }  
        }.start();
    } 
}
