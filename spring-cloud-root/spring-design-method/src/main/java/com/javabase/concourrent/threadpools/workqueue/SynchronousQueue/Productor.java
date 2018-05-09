package com.javabase.concourrent.threadpools.workqueue.SynchronousQueue;

import java.util.concurrent.SynchronousQueue;

/**
 * @author issuser
 *
 */
public class Productor implements Runnable{

	private SynchronousQueue<Integer> sq;
	
	private int id;
	
	public Productor(SynchronousQueue<Integer> sq, int id) {
		this.sq = sq;
		this.id = id;
	}

	
	@Override
	public void run() {
		System.out.println("生产者"+id+"进行创建商品============》start");
		try {
			Thread.sleep(7000);
			//向队列提交一个元素
			sq.put(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("生产者"+id+"进行创建商品============》end");
	}

}
