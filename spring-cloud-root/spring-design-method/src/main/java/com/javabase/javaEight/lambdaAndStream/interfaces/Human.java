
package com.javabase.javaEight.lambdaAndStream.interfaces;


/**
 * java 8允许我们给接口添加一个非抽象的方法实现，只需要使用 default关键字即可
 * 接口的默认方法与静态方法，也就是接口中可以有实现方法
 * @author issuser
 *
 */
public interface Human{
	
	public String talk();
	
	
	default  String commom(String a){
		return "We are Humans~";
	}
}