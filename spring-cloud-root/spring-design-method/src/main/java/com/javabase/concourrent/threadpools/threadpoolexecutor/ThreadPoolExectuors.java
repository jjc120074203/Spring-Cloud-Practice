package com.javabase.concourrent.threadpools.threadpoolexecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * http://blog.csdn.net/lipc_/article/details/52025993
 * http://blog.csdn.net/wangwenhui11/article/details/6760474
 * 
 * 
 * @author issuser
 *
 */
public class ThreadPoolExectuors {
	//设置核心对线程大小
	private final static int CORE_POOL_SIZE=2;
	//设置最大线程大小
	private final static int MAX_IMUMPOOL_SIZE=10;
	//定义队列 有界队列 
	private final static BlockingQueue<Runnable> res= new ArrayBlockingQueue<>(10);
	
	public static void main(String[] args) throws InterruptedException {
		long beginTime=System.currentTimeMillis();
		//构建线程池
		ThreadPoolExecutor tpe=new ThreadPoolExecutor(
				CORE_POOL_SIZE,
				MAX_IMUMPOOL_SIZE, 
				1, //keepAlive
				TimeUnit.MINUTES, 
				res, //工作队列
				Executors.defaultThreadFactory(), 
//				new ThreadPoolExecutor.CallerRunsPolicy());
				new RejectedExecutionHandlerimpl());
		
		//创建线程
		for (int i = 1; i <=100; i++) {
			String n="线程"+i;
			System.out.println(n+"移交给线程池........");
			tpe.execute(new TestThread(n));
		   Thread.sleep(1000);   
		}
		
		long end=System.currentTimeMillis();
		
		System.out.println("消耗时间:"+(end-beginTime)+"ms");
		tpe.shutdown();
	}



}
