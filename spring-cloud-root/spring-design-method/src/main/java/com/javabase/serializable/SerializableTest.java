package com.javabase.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.atomic.AtomicInteger;

public class SerializableTest {
	
	
	public static void main(String[] args) {
		try {
			Serial();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Table t=DesSerial();
			System.out.println(t.getName());
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//ObjectOutputStream 序列化一个对象信息 转换为流
	private static void Serial() throws IOException{
		
		Table t=new Table(new AtomicInteger().incrementAndGet(), "Jack", "100");
		
		//1.编写一个对象输出流
		FileOutputStream fo=new FileOutputStream(new File("D:/spring-could/spring-cloud-root/spring-design-method/src/main/java/com/javabase/serializable/s.txt"));
		//2.将对象进行封装成一个FileOutputStream
		ObjectOutputStream res=new ObjectOutputStream(fo);
		//3.将对象进行写入
		res.writeObject(t);
		res.close();
	}
	
	//ObjectOutputStream 反序列化一个对象信息 转换为流
	private static Table DesSerial() throws IOException, ClassNotFoundException{
		
		//1.编写一个对象输入流
		FileInputStream fo=new FileInputStream(new File("D:/spring-could/spring-cloud-root/spring-design-method/src/main/java/com/javabase/serializable/s.txt"));
		ObjectInputStream ois = new ObjectInputStream(fo);
		 //2.从输入流中将对象读出来
		Table t=(Table) ois.readObject();
		//3.将对象进行写入
		ois.close();
		return t;
	}
}
