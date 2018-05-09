package com.javabase.reflectAndGeneric;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

import com.javabase.reflectAndGeneric.base.Animal;
import com.javabase.reflectAndGeneric.base.dog;

public class TestFeflectAndGeneric {
	
	//动态修改属性
	@Test
	public void testReflect() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		dog d=new dog("1","英文");
		System.out.println("修改前 ======>name:"+d.getName());
		//？是Animal或者Animal子类
		Class<? extends Animal> dogs=dog.class;
		Field[] fields=dogs.getDeclaredFields();
		for (Field field : fields) {
			System.out.println("获取当前类的属性:"+field.getName());
			
			//获取当前属性修饰类型
			int i=field.getModifiers();
			String m=Modifier.toString(i);
			
			System.out.println(field.getName()+"的修饰类型"+m);
		}
		// 获取当前属性值
		Field f=dogs.getDeclaredField("name"); 
		f.setAccessible(true);//设置操作权限
		//设置 当前需要设置的类值并且对属性进行赋值
		f.set(d, "数学");
		System.out.println("修改后的数据值===========》"+d.getName());
	}
}
