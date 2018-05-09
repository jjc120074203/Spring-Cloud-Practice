package org.spring.cloud.common.utils;

/**
 * <p>
 * Description:多线程测试类 测试并发
 * </p>
 * 
 * @author chenjl
 * @date 2017-03-09
 * @version 1.0
 */
public class ThreadTest {
	public static void main(String[] args) {
		// 测试多线程调用订单号生成工具
		try {
			for (int i = 0; i < 10; i++) {
				Thread t1 = new Thread(new Runnable() {
					public void run() {
						// 测试方法 start
						CodeNumBuilder makeOrder = new CodeNumBuilder();  
	                   String b  =makeOrder.makeOrderNum("SC","yyyyMMddHHmmssSSS"); 
	                   System.out.println(b);
						// 测试方法 end
					}
				}, "at" + i);
				t1.start();

				Thread t2 = new Thread(new Runnable() {
					public void run() {
						// 测试方法 start
						CodeNumBuilder makeOrder = new CodeNumBuilder();  
                     String a=   makeOrder.makeOrderNum("CSO","yyyyMMddHHmmssSSS"); 
                     System.out.println(a);
						// 测试方法 end
					}
				}, "bt" + i);
				t2.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
