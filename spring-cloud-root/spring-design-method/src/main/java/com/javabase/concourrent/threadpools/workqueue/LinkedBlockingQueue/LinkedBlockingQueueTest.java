package com.javabase.concourrent.threadpools.workqueue.LinkedBlockingQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * 
 * 队列特点：
 * 1.无界队列，初始时候可以指定大小可以不止定，默认Integer.Max_Value  
 * 2.在生产者放入数据和消费者获取数据 .采用的锁是分离的  生产用的putlock ,消费用的takeLock
 * 3.内部存储是数组链表, 在高并发读写的时候性能没有LinkedBlockingQueue 高，但是读的效率相对好点
 * 4.内部存储是数组链表。在生产和消费时候，需要把枚举对象转为Node<E>插入移除的时候，会产生额外的Node对象。
 * http://blog.csdn.net/mn11201117/article/details/8671497
 * @author cjl
 *
 */
public class LinkedBlockingQueueTest {

	public static void main(String[] args) throws InterruptedException {
		//设置队列堆长度为
		final LinkedBlockingQueue<Integer> sq=new LinkedBlockingQueue<>();
		
		//创建一个线程池
		ExecutorService es=Executors.newFixedThreadPool(10);
		int num=3;
		for (int i = 1; i < 3; i++) {
			//创建生产者
			es.execute(new Productor(sq,i));
		}
		
//		//消费者进行消费
		for (int i = 1; i < 3; i++) {
			//创建消费者
			es.execute(new Consumer(sq,i));
		}
		
		
		es.shutdown();

		
	}
	
}
