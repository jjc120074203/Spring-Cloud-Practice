
package com.javabase.concourrent.threadpools.threadpoolexecutor;

public class TestThread implements Runnable{
	private String name;
	
	public TestThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(name+"<=======开始处理任务=====>");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name+"<======任务处理完毕=====>");
	}
	
}