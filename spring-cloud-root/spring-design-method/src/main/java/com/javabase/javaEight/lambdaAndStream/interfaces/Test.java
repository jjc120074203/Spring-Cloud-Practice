package com.javabase.javaEight.lambdaAndStream.interfaces;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Class<? extends Teacher>  genc=Teacher.class;
		Teacher t=genc.newInstance();
		Method m=genc.getDeclaredMethod("talk");
		Object  result=m.invoke(t, null);
		System.out.println(result);
	}
}
