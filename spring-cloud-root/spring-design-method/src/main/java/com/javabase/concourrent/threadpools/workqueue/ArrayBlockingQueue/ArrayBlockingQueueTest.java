package com.javabase.concourrent.threadpools.workqueue.ArrayBlockingQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;

/**
 * 
 * 队列特点：
 * 1.有界队列 ,初始的时候需要指定大小
 * 2.在生产者放入数据和消费者获取数据， take 、offer、put、poll都是共用使用一个ReentrantLock和两个Condition维护内部的数组.
 * 3.内部存储是数组存储, 在高并发读写的时候性能没有LinkedBlockingQueue 高，但是读的效率相对好点
 * http://blog.csdn.net/mn11201117/article/details/8671497
 * @author cjl
 *
 */
public class ArrayBlockingQueueTest {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch PconsumerLatch=new CountDownLatch(3);
		CountDownLatch CconsumerLatch=new CountDownLatch(3);
		//设置队列堆长度为3
		final ArrayBlockingQueue<Integer> sq=new ArrayBlockingQueue<>(3,true);
	
		//创建一个线程池
		ExecutorService es=Executors.newFixedThreadPool(10);
		int num=6;
		for (int i = 0; i < 1; i++) {
			//创建生产者
			es.execute(new Productor(PconsumerLatch,sq,i));
		}
		//等待生产者生产完成所有的队列
//		PconsumerLatch.await();
//		Thread.sleep(10000);
//		System.out.println("----------进入P等待睡眠----------");
//		System.out.println("----------进入P睡眠完毕----------");
		
//		System.out.println("----------生产完毕----------");
//		//消费者进行消费
		for (int i = 0; i < num; i++) {
			//创建消费者
			es.execute(new Consumer(CconsumerLatch,sq,i));
		}
		
//		CconsumerLatch.await();
//		Thread.sleep(10000);
//		System.out.println("----------进入C等待睡眠----------");
//		System.out.println("----------进入C睡眠完毕----------");
//		System.out.println("----------消费完毕----------");
		
		es.shutdown();

		
	}
	
}
