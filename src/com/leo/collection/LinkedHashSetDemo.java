package com.leo.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetDemo {
	
	private static Set<Integer> mSetInt = new HashSet<Integer>();
	private static Set<Integer> mLinkedSetInt = new LinkedHashSet<Integer>();
	
	private static Set<String> mSetString = new HashSet<String>();
	private static Set<String> mLinkedSetString = new LinkedHashSet<String>();
	
	public static void main(String[] args)
	{
		for(int i=0;i<50;i++)
		{
			mSetInt.add(i);
			mLinkedSetInt.add(i);
			mSetString.add(String.valueOf(i));
			mLinkedSetString.add(String.valueOf(i));			
		}
		 Iterator<Integer> setIntIt = mSetInt.iterator();  
	        System.out.println("The sequence of HashSet for Integer:");  
	        while(setIntIt.hasNext()) {  
	            System.out.print(setIntIt.next() + " ");  
	        }  
	        System.out.println();  
	          
	        System.out.println("The sequence of HashSet for String:");  
	        Iterator<String> setStringIt = mSetString.iterator();  
	        while(setStringIt.hasNext()) {  
	            System.out.print(setStringIt.next() + " ");  
	        }  
	        System.out.println();  
	          
	        System.out.println("The sequence of LinkedHashSet for Integer:");  
	        Iterator<Integer> linkedSetIntIt = mLinkedSetInt.iterator();  
	        while(linkedSetIntIt.hasNext()) {  
	            System.out.print(linkedSetIntIt.next() + " ");  
	        }  
	        System.out.println();  
	          
	        System.out.println("The sequence of LinkedHashSet for String:");  
	        Iterator<String> linkedSetStringIt = mLinkedSetString.iterator();  
	        while(linkedSetStringIt.hasNext()) {  
	            System.out.print(linkedSetStringIt.next() + " ");  
	        }  
	        System.out.println();  
	}
	
	

}
