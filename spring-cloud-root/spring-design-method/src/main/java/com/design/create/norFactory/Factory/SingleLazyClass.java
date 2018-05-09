package com.design.create.norFactory.Factory;

/**
 * 懒汉单例模式
 * @author cjl
 *
 */
public class SingleLazyClass {
	//定义一个私有构造函数
	private SingleLazyClass(){
		
	}
	//定义一个指向自己实例的 的静态引用
	private static SingleLazyClass slc= new SingleLazyClass();
	
	// 方法 1定义一个以自己为返回值静态实例的静态方法 (获取当前事例方法的时候 才会获取对象)
	private static synchronized SingleLazyClass getInstance(){
		if (slc==null) {
			return new SingleLazyClass();
		}
		return slc;
	}
	// 方法 2 优化方法1 这样不需要需要每次获取的方法的时候都获取对对象上锁。第一次的上锁就行
	private  static  SingleLazyClass getBetterInstnace(){
		if (slc==null) {
			synchronized(slc){
				if (slc==null) {
					slc=new SingleLazyClass();
				}
			}
		}
		return slc;
	}
}
