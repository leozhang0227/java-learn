package com.leo.collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo2 {

	public static void main(String[] args) {
        TreeSet ts = new TreeSet(new Student2.StuendComparator());
        ts.add(new Student2("zhangsan", 2));
        ts.add(new Student2("lisi", 1));
        ts.add(new Student2("wangmazi", 3));
        ts.add(new Student2("mazi", 3));
        Iterator it = ts.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

class Student2 
{
	private String name;
	private int num;
	public Student2(String name,int num)
	{
		this.name = name;
		this.num = num;
	}
	public String toString()
	{
		return name +" "+ num;
	}
	static class StuendComparator implements Comparator
	{

		@Override
		public int compare(Object o1, Object o2) {
			Student2 stu1 = (Student2)o1;
			Student2 stu2 = (Student2)o2;
			
			int result = stu1.num > stu2.num?1:(stu1.num==stu2.num?0:-1);
			//if(result==0)
			//{
			//	return stu1.name.compareTo(stu2.name);
			//}
			return result;
		}
		
	}
		
}