package com.leo.collection;
import java.util.*;

public class TreeSetDemo {
	
	public static void main(String[] args)
	{
		Set<Student> stus = new TreeSet<Student>();		
		
		stus.add(new Student("lisi", 2));
		stus.add(new Student("wangmazi", 3));
		stus.add(new Student("wangwu",4));
		stus.add(new Student("mazi", 3));
		stus.add(new Student("zhangsan_leo", 1));
        Iterator it = stus.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        
        
		
	}
}

class Student implements Comparable
{
	private String name;
	private int num;
	
	public Student(String name,int num)
	{
		this.name=name;
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}	
	
	public String toString()
	{
		return this.name + this.num;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Student s = (Student)o;
		if(this.num>s.num)
			return 1;
		else if(this.num<s.num)
			return -1;
		else
		return 0;
	}
	
}
