package com.javabase.Thread.method;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadThree implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		System.out.println("kaishi");
		return 1;
	}
	
	public static void main(String[] args) {
		ThreadThree tt=new ThreadThree();
		FutureTask<Integer> t=new FutureTask<>(tt);
		new Thread(t).start();
	}
}
