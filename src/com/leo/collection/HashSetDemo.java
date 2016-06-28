package com.leo.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashSetDemo {

    public static void main(String[] args) {
    	
    	HashSet ts = new HashSet();
        ts.add("ee");
        ts.add("dd");
        ts.add("bb");
        ts.add("cc");
        ts.add("aa");
        Iterator it = ts.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    
    	
        //Set<String> set=new HashSet<String>();
    	Set<String> set=new LinkedHashSet<String>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("c");
        set.add("d");
        
        //使用Iterator输出集合
        Iterator<String> iter=set.iterator();
        while(iter.hasNext())
        {
            System.out.print(iter.next()+" ");
        }
        System.out.println();
        //使用For Each输出结合
        for(String e:set)
        {
            System.out.print(e+" ");
        }
        System.out.println();
        
        //使用toString输出集合
        System.out.println(set);
    }
}