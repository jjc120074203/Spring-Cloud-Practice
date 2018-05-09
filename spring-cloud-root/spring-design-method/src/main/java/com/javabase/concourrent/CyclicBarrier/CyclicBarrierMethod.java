package com.javabase.concourrent.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * 
 * CyclicBarrier 【栏栅】    加数计数器 
 * 可循环屏障  一组线程到达一个同步点【屏障】的时候  被阻塞了，直到其他线程都到达该同步点的时候，才继续执行。
 * 主要  强调一组线程之前的相互等待  主要有一个没有完成的话，其他的相互等待。
 * CyclicBarrier  
 *
 * @author issuser
 *
 */
public class CyclicBarrierMethod implements Runnable{
		// 场景: 游戏加载 ，10个玩家 需要加载100% 的时候 ，才能正常的进行5v5比赛。 如果有一个玩家掉线了，其他玩家就行等待。
		
		private  CyclicBarrier CyclicBarrier;

		public CyclicBarrierMethod(java.util.concurrent.CyclicBarrier cyclicBarrier) {
			CyclicBarrier = cyclicBarrier;
		} 

		@Override
		public void run() {
			System.out.println("玩家"+Thread.currentThread().getId()+"开始加载游戏....");
			
			try {
				Thread.sleep(5000);
			System.out.println("玩家"+Thread.currentThread().getId()+"加载完成");
			
			//设置屏障 所有线程都到达barrier状态再同时执行后续任务
			CyclicBarrier.await();
//			CyclicBarrier.await(5000, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	
	
	
}
