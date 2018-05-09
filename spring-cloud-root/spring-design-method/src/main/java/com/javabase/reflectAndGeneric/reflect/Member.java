package com.javabase.reflectAndGeneric.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.javabase.reflectAndGeneric.base.Student;

/**
 * Constructor Field Method
 * 调用成员变量获取属性 
 * @author issuser
 *
 */
public class Member {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		Class<?> t = Student.class;
		//实例 对象
		Student st=(Student) t.newInstance();
		//打印对象成员变量
		st.printName();
		System.out.println("=============>>打印所有构造器数据<<================");
		Constructor[] ct=t.getConstructors();
		for (Constructor constructor : ct) {
			System.out.println(constructor.toString());
		}
		System.out.println("=============>>打印所有构造器数据<<================");
		
		System.out.println("=============>>打印所有变量数据<<================");
		
		Field[] fields = t.getFields();
		for (Field field : fields) {
			System.out.println(field.toString());
		}
		System.out.println("=============>>打印所有变量数据<<================");
		
		System.out.println("=============>>打印所有【方法】数据<<================");
		
		Method[] methods = t.getMethods();
        for (Method method : methods){
            System.out.println("method = "+ method.getName());
        }
		System.out.println("=============>>打印所有【方法】数据<<================");
	}
}
