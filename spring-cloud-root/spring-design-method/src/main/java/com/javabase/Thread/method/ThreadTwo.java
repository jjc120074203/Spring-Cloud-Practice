package com.javabase.Thread.method;

/**
 * 实现Runnable方式
 * 创建 Runnable实现类的实例，
 * 并依此实例作为Thread的target来创建Thread对象，该Thread对象才是真正的线程对象。
 * @author issuser
 *
 */
public class ThreadTwo implements Runnable{
	@Override
	public void run() {
		for (int j = 0; j < 3; j++) {
			System.out.println(Thread.currentThread().getName()+" "+j);    
		}
	}

	public static void main(String[] args) {
		ThreadTwo tt=new ThreadTwo();
		for (int i = 0; i < 20; i++) {
			new Thread(tt, "线程1").start();
			new Thread(tt, "线程2").start();
		}
	}
}
