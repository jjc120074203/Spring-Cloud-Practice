package com.javabase.concourrent.threadpools.workqueue.LinkedBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author issuser
 *
 */
public class Productor implements Runnable{
	
	private LinkedBlockingQueue<Integer> sq;
	
	private int id;

	public Productor( LinkedBlockingQueue<Integer> sq, int id) {
		this.sq = sq;
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("生产者"+id+"进行创建商品============》start");
		try {
			Thread.sleep(2000);
			sq.put(1);
			System.out.println("当前队列元素:"+sq.peek());
//			cb.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("生产者"+id+"进行创建商品============》end");
	}

}
