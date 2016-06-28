package com.interview;

public class StringSubstraction {
	public static void main(String[] args)
	{
		String s1 = "They are students";
		String s2 = "aeiou";
		System.out.println(strSub(s1,s2));
		String s3 ="abc.123.88.part";
		String s4 = "1234.33.99.part";
		System.out.println(getSubStr(s3,2));
		System.out.println(getSubStr(s4,2));
	}
	public static String getSubStr(String str, int num) 
	{  String result = "";  int i = 0;  
	while(i < num) 
	{   int lastFirst = str.lastIndexOf('.');   
	result = str.substring(lastFirst);
	str = str.substring(0, lastFirst);   i++;  }  
	return result.substring(1); 
	} 
	
	public static String strSub(String s1, String s2)
	{
		String result = "";
		for(int i=0;i<s1.length();i++)
		{
			if(s2.indexOf(s1.charAt(i))==-1)
			{
				result= result+s1.charAt(i);
			}
		}
		return result;
	}

}
