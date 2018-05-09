package com.javabase.concourrent.CyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class test {
	
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		final int PLAYERNUMBER=10;
		StartGame sg=new StartGame();
		
		//所有线程执行完毕之后，在自动执行 StartGame方法
		CyclicBarrier cb=new CyclicBarrier(PLAYERNUMBER, sg);
		for (int i = 0; i < PLAYERNUMBER; i++) {
			//启动线程(传入参数进行阻塞)
			CyclicBarrierMethod cbm=new CyclicBarrierMethod(cb);
			new Thread(cbm).start();
			
		}
	}
	
}
