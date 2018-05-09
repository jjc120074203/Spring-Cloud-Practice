package com.javabase.concourrent.threadpools.workqueue.LinkedBlockingQueue;

public class FinishFactory implements Runnable{
	@Override
	public void run() {
		System.out.println("================》当前阶段完成《=================");
	}
}
