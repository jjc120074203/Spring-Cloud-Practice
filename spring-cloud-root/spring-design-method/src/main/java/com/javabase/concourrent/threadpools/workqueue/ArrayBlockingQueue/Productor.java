package com.javabase.concourrent.threadpools.workqueue.ArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;

/**
 * @author issuser
 *
 */
public class Productor implements Runnable{
	private CountDownLatch consumerLatch;  
	private ArrayBlockingQueue<Integer> sq;
	
	private int id;
	
	public Productor(CountDownLatch consumerLatch, ArrayBlockingQueue<Integer> sq, int id) {
		super();
		this.consumerLatch = consumerLatch;
		this.sq = sq;
		this.id = id;
	}




	@Override
	public void run() {
		System.out.println("生产者"+id+"进行创建商品============》start");
		try {
			Thread.sleep(2000);
			// 1.put 向队列提交一个元素，如果队列满了就等待，没有满的话就继续 [无返回值]
			 sq.put(1);
			
			
			// 2.offer 向队列提交一个元素，如果不满了返回true 满返回false [有返回值]
			// boolean f=sq.offer(1);
			// if (f) {
			// System.out.println("队列没有满");
			// }else{
			// System.out.println("队列满");
			//
			// }
			
			//add 如果队列满就抛出异常
			//sq.add(1);
			consumerLatch.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("生产者"+id+"进行创建商品============》end");
	}

}
