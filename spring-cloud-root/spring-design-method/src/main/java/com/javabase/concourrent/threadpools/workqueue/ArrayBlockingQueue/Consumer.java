package com.javabase.concourrent.threadpools.workqueue.ArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;

/**
 * @author issuser
 *
 */
public class Consumer implements Runnable {

	private CountDownLatch consumerLatch;
	private ArrayBlockingQueue<Integer> sq;
	private int id;

	public Consumer(CountDownLatch consumerLatch, ArrayBlockingQueue<Integer> sq, int id) {
		super();
		this.consumerLatch = consumerLatch;
		this.sq = sq;
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("消费者" + id + "进行消费商品============》start");
		try {
			// 1.take 向队列使删除元素 ,如果队列空 一直等待
			// sq.take();
			// 2.poll ：如果没有元素，直接返回null；如果有元素，出队
			// sq.poll();

			// 3 .remove 移除队列元素 队列空异常
			// sq.remove();

			Thread.sleep(2000);
			// 计数
			 consumerLatch.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("消费者" + id + "进行消费商品============》end");
	}

}
