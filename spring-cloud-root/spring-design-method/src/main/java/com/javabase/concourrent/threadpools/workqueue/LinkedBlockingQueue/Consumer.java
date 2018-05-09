package com.javabase.concourrent.threadpools.workqueue.LinkedBlockingQueue;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author issuser
 *
 */
public class Consumer implements Runnable {
	private LinkedBlockingQueue<Integer> sq;
	private int id;

	public Consumer(LinkedBlockingQueue<Integer> sq, int id) {
		this.sq = sq;
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("消费者" + id + "进行消费商品============》start");
		try {
			 sq.take();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("消费者" + id + "进行消费商品============》end");
	}

}
