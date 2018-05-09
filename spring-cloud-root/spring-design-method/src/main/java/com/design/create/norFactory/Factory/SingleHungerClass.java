package com.design.create.norFactory.Factory;

/**
 * 
 * @author 单例模式（饿汉单例模式）
 *
 */
public class SingleHungerClass {

	//私有的构造方法
	private SingleHungerClass(){
		
	} 
	//方法1 指向自己实例的私有静态私有引用方法
	private static SingleHungerClass sc=new SingleHungerClass();
	
	//方法2
/*	private static SingleHungerClass sc=null;
	static{
		sc=new SingleHungerClass();
	}*/
	
	
	//以自己为实例返回值的静态共有方法
	public static SingleHungerClass getInstance(){
		return sc;
	}
	//序列化
	public Object readObject(){
		return sc;
	}
}
