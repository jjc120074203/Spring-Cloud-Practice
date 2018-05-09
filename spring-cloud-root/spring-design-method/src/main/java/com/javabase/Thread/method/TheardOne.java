package com.javabase.Thread.method;

/**
 * 继承的方式实现线程以及调用
 * 创建线程的时候 创建Thread子类的实例，即创建了线程对象。
 * @author issuser
 *
 */
public class TheardOne extends Thread{

	public TheardOne(String ThreadName) {
		 super(ThreadName);
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"采用继承的方式进行。。。。。。。。。。。。。");
	}

//	test
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			
				new TheardOne("线程一-----》").start();
				new TheardOne("线程一-----》").sleep(100);
				
				new TheardOne("线程二-----》").start();
				new TheardOne("线程二-----》").sleep(100);
				
		}
	}
}
