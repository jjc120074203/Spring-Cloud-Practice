package com.javabase.concourrent.threadpools.workqueue.SynchronousQueue;

import java.util.concurrent.SynchronousQueue;

/**
 * @author issuser
 *
 */
public class Consumer implements Runnable{

	private SynchronousQueue<Integer> sq;
	private int id;
	
	public Consumer(SynchronousQueue<Integer> sq, int id) {
		this.sq = sq;
		this.id = id;
	}

	
	@Override
	public void run() {
		System.out.println("消费者"+id+"进行消费商品============》start");
		try {
			Thread.sleep(7000);
			//向队列使用一个元素
			sq.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("消费者"+id+"进行消费商品============》end");
	}

}
