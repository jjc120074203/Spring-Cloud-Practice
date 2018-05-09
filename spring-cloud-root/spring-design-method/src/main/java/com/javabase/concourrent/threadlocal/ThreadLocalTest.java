package com.javabase.concourrent.threadlocal;

import java.util.Random;

/**
 * ThreadLocal 本地线程变量。 在每一个线程中创建一个副本 ，每一个线程都可以独立的访问自己副本。 使用场景
 * ：当很多线程需要多次使用同一个对象，并且需要该对象具有相同初始化值的时候最适合使用ThreadLocal。 ThreadLocal 每次线程Thread
 * 内部都会有一个TreadLocalMap 类型的ThreadLocals 变量。 ThreadLocals就是就是一个副本，并且
 * TreadLocalMap 中Entry WeakReference<ThreadLocals> WeakReference 是一个弱引用
 * 当前引用对象没有强引用的时候就会被自动释放
 * 
 * @author issuser
 *
 */
public class ThreadLocalTest {
	ThreadLocal<Long> res = new ThreadLocal<Long>();
	
	public Long getLong(){
		return res.get();
	}
	
	
	public static void main(String[] args) {
		   String randomString = "0000"+new Random().nextInt(9999);
//           String order_suffix = CommUtil.formatTime("yyyyMMddHHmmss", new Date())
//                   + randomString.substring(randomString.length() - 4);
//           System.out.println(order_suffix);
	}

}
