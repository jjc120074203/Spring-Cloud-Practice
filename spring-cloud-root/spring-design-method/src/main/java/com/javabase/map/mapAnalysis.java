
package com.javabase.map;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * HashMap 并发问题
 * @author issuser
 *
 */
public class mapAnalysis{
	
	private Map map=new ConcurrentHashMap();

	public mapAnalysis(){
		Thread t1=new Thread(){
			public void run(){
				for (int i = 1; i <=50000; i++) {
					map.put(new Integer(i), i);
				}
				System.out.println("线程1正在启动。。。。");
			}
		};
		
		Thread t2 = new Thread(){
			public void run(){
				for (int i = 1; i <=50000; i++) {
					map.put(new Integer(i), i);
				}
				System.out.println("线程2正在启动。。。。");
			}
		};
		Thread t3 = new Thread(){
			public void run(){
				for (int i = 1; i <=50000; i++) {
					map.put(new Integer(i), i);
				}
				System.out.println("线程3正在启动。。。。");
			}
		};
		Thread t4 = new Thread(){
			public void run(){
				for (int i = 1; i <=50000; i++) {
					map.put(new Integer(i), i);
				}
				System.out.println("线程4正在启动。。。。");
			}
		};
		Thread t5 = new Thread(){
			public void run(){
				for (int i = 1; i <=50000; i++) {
					map.get(new Integer(i));
				}
				System.out.println("线程5正在启动。。。。");
			}
		};
		
		Thread t6 = new Thread(){
			public void run(){
				for (int i = 1; i <=50000; i++) {
					map.get(new Integer(i));
				}
				System.out.println("线程6正在启动。。。。");
			}
		};
		Thread t7 = new Thread(){
			public void run(){
				for (int i = 1; i <=50000; i++) {
					map.get(new Integer(i));
				}
				System.out.println("线程7正在启动。。。。");
			}
		};
		Thread t8 = new Thread(){
			public void run(){
				for (int i = 1; i <=50000; i++) {
					map.get(new Integer(i));
				}
				System.out.println("线程8正在启动。。。。");
			}
		};
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
	}
	
	public static void main(String[] args) {
		new mapAnalysis();
	}
}