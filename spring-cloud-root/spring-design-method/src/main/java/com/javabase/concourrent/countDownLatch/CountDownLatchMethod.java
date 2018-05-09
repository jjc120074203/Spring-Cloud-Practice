package com.javabase.concourrent.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * 
 * CountDownLatch 闭锁 （减数计数器）
 *   一个线程 （或者多个线程）等待 另外一个线程（或者多个线程）执行完毕才可以进行执行。
 *  就是也就是说主线程在等待所有其它的子线程完成后再往下执行。 强调一组线程等待另一组线程
 *  它的计数器 不能被修改  ，await方法会只一个阻塞当前主线程知道其他子线程完成之后才可以进行执行。
 * @author cjl
 *
 */
public class CountDownLatchMethod {
	/* 实现一个场景，10个玩家比赛，当他们都到达终点的时候，计算排名 */

	public static void testCountDownLatch() {
		int num = 10;

		final CountDownLatch _latch = new CountDownLatch(num);
		for (int i = 0; i < num; i++) {
			//启动 10 个线程
			new Thread(new Runnable() {
				@Override
				public void run() {
					
					System.out.println("线程" + Thread.currentThread().getId() + "开始出发");
					try {
						Thread.sleep(7000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("线程" + Thread.currentThread().getId() + "已到达终点");
					
					_latch.countDown();//通知机制 每当他完成之后 计数值减一
					
				}
				
			}).start();
		
		}
		//-------------------------------------------------------------------------------
		
		try {
			//
			_latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("10个线程已经执行完毕！开始计算排名");
	}

}
