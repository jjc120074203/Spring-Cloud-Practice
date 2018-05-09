package com.javabase.concourrent.threadpools.threadpoolexecutor;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 自定义拒绝策略
 * @author issuser
 *
 */
public class RejectedExecutionHandlerimpl implements RejectedExecutionHandler{

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println(r.toString()+"线程被拒绝了================>");
	}

}
