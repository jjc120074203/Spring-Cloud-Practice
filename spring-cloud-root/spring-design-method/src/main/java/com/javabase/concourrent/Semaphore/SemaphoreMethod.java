package com.javabase.concourrent.Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore 信号量 
 * 用于控制多个线程对公共资源的访问控制
 * 类似一个阀   
 * 1.先设置 当前初始信号量A  availablePermits可以查询
 * 2.线程1占用时候获取信号量值 acquire（）A-1 ,如果A=0 时 此线程进入等待！
 * 3.线程1 用完之后release 释放 信号量 A+1 
 * 类似与一个
 * @author issuser
 *
 */
public class SemaphoreMethod {
	
	private final  int THREADNUM=10;
		//设置业务场景:
	   //10 个人去办理业务 ，柜台只有两个，同时办理接口，然后任意一个办理完成了，马上办理下一个。
	  	
	public void testSemaphore(){
		//创建一个线程池
		ExecutorService  threadPool =Executors.newFixedThreadPool(THREADNUM);
		
		//初始信号量  允许最大的线程数量为2
		Semaphore sp=new Semaphore(2);
		int count =0;
		System.out.println("空闲业务人员有："+sp.availablePermits()+"位");
		
		for (int i = 1; i <=THREADNUM; i++) {
			Banker bak=new Banker(sp, i);
			//执行线程
			threadPool.execute(bak);
		}
		threadPool.shutdown();
		System.out.println("空闲业务员有："+sp.availablePermits()+" 位");
	}
	
	
}
