package com.javabase.concourrent.threadpools.executor;

/**
 * 
 * 
 * @author issuser
 *
 */
public class Task implements Runnable {
	private int id;

	public Task(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println(id+"线程正在运行................");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
