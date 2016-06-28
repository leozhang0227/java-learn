package com.leo.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {   
    static final int N=50000;   
    static long timeList(List list){   
    long start=System.currentTimeMillis();   
    Object o = new Object();   
    for(int i=0;i<N;i++)   
        list.add(0, o);   
    return System.currentTimeMillis()-start;   
    }   
    public static void main(String[] args) {   
        System.out.println("ArrayListºÄÊ±£º"+timeList(new ArrayList()));   
        System.out.println("LinkedListºÄÊ±£º"+timeList(new LinkedList()));   
    }   
}   