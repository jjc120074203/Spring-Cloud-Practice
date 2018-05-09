package com.javabase.concourrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 原理
 * CAS  操作  (Compare And Set)  预期值A 、内存中的值V、修改值 B
 * 原理 就是: 且仅当预期值A和内存中的值V相同，则将内存V值修改为B，否则返回V。
 * 优势：在并发场景大大提高了效率。自增、并发问题效率
 * 这是一种非阻塞算法。什么意思？ 一个线程的失败或者挂起是不会影响其他线程的失败或者挂起。
 * 与synchronized 相反 就是说呢  不会hang 住代码 一会堵塞请求 ，性能好与同步锁
 * 
 *  可能会造成ABA问题：
 *  CAS 要取出内存中某时刻的数据，而在下时刻比较并替换 
 *  如下场景：1.线程1先将 内存中的V值  同时 线程2 也获取到内存中得V值，比较之后 线程2对V值进行修改 为V1,
 *  线程2 又将 V1 修改成V 2 . 线程1 对比的时候还是用内存中得值进行比较成功了，
 *  
 *  替换出现时间差问题 https://www.cnblogs.com/549294286/p/3766717.html
 *  
 *
 */
public class Atomic {

	private static int it = 0;

	private static AtomicInteger i = new AtomicInteger();

	private static int get() {
		return i.incrementAndGet();
	}

	

	//--------------------------------

	synchronized static int getIt() {
		return it++;
	}
	
//	test
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			System.out.println(get());
			System.out.println(getIt());
			
		}
	}
}
