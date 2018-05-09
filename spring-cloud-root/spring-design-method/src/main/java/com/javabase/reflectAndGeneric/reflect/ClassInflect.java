package com.javabase.reflectAndGeneric.reflect;

import java.util.ArrayList;
import java.util.List;

import com.javabase.reflectAndGeneric.base.Animal;
import com.javabase.reflectAndGeneric.base.Student;
import com.javabase.reflectAndGeneric.base.Things;
import com.javabase.reflectAndGeneric.base.cat;
import com.javabase.reflectAndGeneric.base.dog;

/**
 * Class 
 * 获取class 对象的三种方法方法
 * @author issuser
 *
 */
public class ClassInflect {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		//泛型方式 start
		
		//? extends Animal  ？只能是任何继承Animal父类的子类
	    Class<? extends Animal> stdog=dog.class;
	    Class<? extends Animal> stcat=cat.class;
	    System.out.println(stdog.getName());
	    System.out.println(stcat.getName());
	    
	    //？只能是来自来自dog的父类的类 dog -->animal ---Things
	    Class<? super dog> stThings=Things.class;
	    Class<? super dog> stAnimal=Animal.class;
	    System.out.println(stThings.getName());
	    System.out.println(stAnimal.getName());
	   //泛型方式 end 
	    
	    List<? extends Number> ls=new ArrayList<>();
		//获取class对象  方法一
		Class<?> st=Student.class;
		System.out.println(st.getName());
		
		//获取class对象方法 ForName(全限定类名)
		 Class<?> st1=Class.forName("com.javabase.reflect.base.Things");
		 
		// 创建实例获取对象 属性
		 Student s= (Student) st.newInstance();
		 s.printName();
	}
}
