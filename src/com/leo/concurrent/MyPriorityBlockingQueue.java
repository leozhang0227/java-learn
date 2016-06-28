package com.leo.concurrent;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

public class MyPriorityBlockingQueue {
	public static void main(String[] args) {
		JobPriorityComparator comparator = new JobPriorityComparator();
		PriorityBlockingQueue<Job> queue = new PriorityBlockingQueue<Job>(10,comparator);
		
		queue.put(new Job(5));
		queue.put(new Job(9));
		
		for(Job job:queue)
		{
			System.out.println(job.toString());
		}
		queue.put(new Job(10));
		System.out.println("after 10 put in");
		for(Job job:queue)
		{
			System.out.println(job.toString());
		}
		try {
			queue.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("after take head");
		for(Job job:queue)
		{
			System.out.println(job.toString());
		}
		
		
}

}
class Job {
	int priority;
	Job(int priority)
	{
		this.priority = priority;
	}
	public String toString()
	{
		return "Job[Priority="+priority+"]";
	}
}

class JobPriorityComparator implements Comparator<Job> {

	@Override
	public int compare(Job o1, Job o2) {
		if(o1.priority<o2.priority)
		{
			return 1;
		}else if(o1.priority>o2.priority)
		{
			return -1;
		}else
		return 0;
	}
}

