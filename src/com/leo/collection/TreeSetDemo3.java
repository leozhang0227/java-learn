package com.leo.collection;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo3 {
	
	public static void main(String[] args)
	{
		TreeSet hashSet = new TreeSet();
		hashSet.add("a");
		hashSet.add("e");
		hashSet.add("b");
		hashSet.add("d");
		hashSet.add("c");
		
		Iterator<String> it = hashSet.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
		
		TreeSet ts = new TreeSet();
		ts.add("a");
		ts.add("e");
		ts.add("b");
		ts.add("d");
		ts.add("c");
		
		Iterator<String> it1 = ts.iterator();
		while(it1.hasNext())
		{
			System.out.println(it1.next());
		}
		TreeSet ts1 = new TreeSet();
        ts1.add("z");
        ts1.add("a");
        ts1.add("d");
        ts1.add("b");
        ts1.add("c");
        Iterator<String> it2 = ts1.iterator();
        while (it2.hasNext()) {
            System.out.println(it2.next());
        }
	}

}
