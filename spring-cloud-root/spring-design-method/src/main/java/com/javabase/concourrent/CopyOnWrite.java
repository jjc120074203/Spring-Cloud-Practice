package com.javabase.concourrent;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author CopyOnWrite 容器（读写分离的思想） 
 *  @desprition <h2>写时复制的容器 当我们添加一个元素的时候不直接往里面添加，而是先将容器进行copy 
 *   复制出一个新的容器，然后新的容器里添加元素,添加新的元素之后， 再将旧容器的引用指向新的 元素</h2>
 * 
 *      
 * @category 运用的场景： 读多写少的 场景
 * 
 *
 */
public class CopyOnWrite {
	private static CopyOnWriteArrayList<String> ca = new CopyOnWriteArrayList<String>();

	// 定一个场景 黑名单关键字 判断黑名单关键字
	// 先判断一个list是否在黑名单里面

	public static String getId(int a) {
		return ca.get(a);
	}

	public static void putId(int a) {
		ca.add(a + " ");
	}

	public static void main(String[] args) {

		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("____________________________");
				for (int i = 0; i < 1000; i++) {
					putId(i);
				}
				for (int i = 0; i < 30; i++) {
					System.out.println(getId(i));
				}
				System.out.println("____________________________");
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("____________________________");
				for (int i = 0; i < 100; i++) {
					putId(i);
				}
				for (int i = 0; i < 30; i++) {
					System.out.println(getId(i));
				}
				System.out.println("____________________________");
			}
		}).start();
	}
}