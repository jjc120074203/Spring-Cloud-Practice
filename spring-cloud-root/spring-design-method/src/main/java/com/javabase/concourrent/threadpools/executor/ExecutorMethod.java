package com.javabase.concourrent.threadpools.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 
 * 创建 4中线程池线程池
 * 
 * @author issuser
 *
 */
public class ExecutorMethod {

	public static void main(String[] args) {
		// 第一类:创建一个固定的线程池
		// 每三个一组同时并行运行，当达到最大3的时候，后续需要等待排队 其他线程继续等待
		// ExecutorService es=Executors.newFixedThreadPool(3);
		
		//单个运行  当达到默认1的时候，后续需要等待排队 其他线程继续等待
		//ExecutorService es = Executors.newSingleThreadExecutor();
		
		// 第二类:创建一个可变   所有线程 直接运行 存在缓存时间
//		ExecutorService es = Executors.newCachedThreadPool();
		//定时执行
		ScheduledExecutorService es=Executors.newScheduledThreadPool(3);
		// 执行线程池
		for (int i = 0; i < 7; i++) {
			if (i>4) {
				//定时延迟 延迟1 分钟进行
				es.schedule(new Task(i), 1, TimeUnit.MINUTES);
			}else{
				es.execute(new Task(i));
			}
		}

		// 关闭线程池
		es.shutdown();

	}
}
