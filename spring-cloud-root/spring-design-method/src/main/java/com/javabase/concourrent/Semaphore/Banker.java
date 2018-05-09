package com.javabase.concourrent.Semaphore;

import java.util.concurrent.Semaphore;

public class Banker implements Runnable{
	
	//设置信号量
	private Semaphore Semaphore;
	//客户Id
	private int id;

	
	public Semaphore getSemaphore() {
		return Semaphore;
	}

	public Banker(java.util.concurrent.Semaphore semaphore, int id) {
		super();
		Semaphore = semaphore;
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("=========>当前客户"+id+"进入办理<============");
		
		try {
			//1.获取信号量 占用
			Semaphore.acquire();

			System.out.println("客户：" + id + " 开始办理业务，start");
			
			System.out.println("还剩业务员：" + Semaphore.availablePermits()+ " 位");
			Thread.sleep(7000);
			System.out.println("客户：" + id + " 办理业务完毕，end");
			
			//2.用完就是释放信号量
			Semaphore.release();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
