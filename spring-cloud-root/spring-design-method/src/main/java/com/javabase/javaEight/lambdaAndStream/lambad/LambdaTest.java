package com.javabase.javaEight.lambdaAndStream.lambad;

import org.junit.Test;

/**
 * Lambda【ˈlæmdə】 表达式  一段带有输入参数的可执行语句块
 * 主要有 3个部分
 * 输入参数
 * 可执行语句
 * 存放外部变量的空间
 * （param2,param1）-》{statmet1;statement2;  return result }
 * 
 * @author issuser
 *
 */
public class LambdaTest {
	
	@Test
	public void SimpleTest(){
		//新启动一个线程 没有用lamda
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("新启动一个线程~~");
			}
		}).start();
		
		//采用Lamdba 进行线程处理
		new Thread(()->System.out.println("新启动另一个线程~~")).start();
	}

}
