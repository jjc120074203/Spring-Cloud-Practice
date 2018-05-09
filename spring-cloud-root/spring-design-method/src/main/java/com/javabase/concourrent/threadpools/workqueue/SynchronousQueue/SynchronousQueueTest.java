package com.javabase.concourrent.threadpools.workqueue.SynchronousQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

/**
 * 
 * 队列特点：生产者产生一个put/offer的时候，此时消费者必须进行take/poll操作,如果不 take /poll,此时必须阻塞
 * 
 * @author cjl
 *
 */
public class SynchronousQueueTest {

	public static void main(String[] args) {
		final SynchronousQueue<Integer> sq=new SynchronousQueue<>();
	
		//创建一个线程池
		ExecutorService es=Executors.newFixedThreadPool(10);
	
		for (int i = 0; i < 2; i++) {
			//创建生产者
			es.execute(new Productor(sq,i));
			//创建消费者
			es.execute(new Consumer(sq,i));
			
			//结果生存者生产一个等待消费者消费
		}
		es.shutdown();
//		new Thread(new Productor(sq,1)).start();
//		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		new Thread(new Consumer(sq,1)).start();
		
	}
	
}
