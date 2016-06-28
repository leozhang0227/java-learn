package com.leo;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class StreamChange {
	
	
	/**
	 * string to input stream
	 * @param str
	 * @return
	 */
	public static InputStream string2InputStream(String str)
	{
		InputStream in = new ByteArrayInputStream(str.getBytes());
		return in;
	}
	
	/**
	 * file to input stream
	 * @throws FileNotFoundException 
	 * 
	 */
	public static InputStream file2InputStream(File file) throws FileNotFoundException
	{
		InputStream in = new FileInputStream(file);
		return in;
	}
	
	/**
	 * input steam to string
	 * method1
	 * @throws IOException 
	 */
	public static String inputStream2String1(InputStream is) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(is));
		StringBuffer buffer = new StringBuffer();
		String line = "";
		while((line = in.readLine())!=null){
			buffer.append(line);
		}
		return buffer.toString();
	}
	
	/**
	 * input steam to string
	 * method1
	 * @throws IOException 
	 */
	public static String inputStream2String2(InputStream is) throws IOException
	{
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] b = new byte[1024];
		int i = -1;
		while((i=is.read(b))>0){
			out.write(b, 0, i);			
		}
		return out.toString();
	}
	
	/**
	 * input stream to file
	 * @throws IOException 
	 */
	public static File inputStream2File(InputStream is, File file) throws IOException
	{
		OutputStream os = new FileOutputStream(file);
		int byteRead = 0;
		byte[] buffer = new byte[8192];
		while((byteRead=is.read(buffer,0,8192))!=-1)
		{
			os.write(buffer, 0, byteRead);			
		}
		os.close();
		is.close();
		return file;
	}
	
}
