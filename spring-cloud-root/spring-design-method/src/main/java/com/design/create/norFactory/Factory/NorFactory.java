package com.design.create.norFactory.Factory;

import com.design.create.norFactory.A_Delivery;
import com.design.create.norFactory.B_Delivery;
import com.design.create.norFactory.Delivery;

/**
 * @author普通工厂类
 *
 */
public class NorFactory {
	
	/**
	 * 普通单个工厂
	 * @param flag
	 * @return
	 */
	public Delivery sendSingleDelivery(int flag){
		if (flag > 0) {
			return new A_Delivery();
		}
		return new B_Delivery();
	} 
	
	//--------------------多个工厂---Start-----------------
	
	//创建 针对A类物流发送的方法
	public Delivery send_A_Delivery(){
		return new A_Delivery();
	}
	//创建 针对B类物流发送的方法
	public Delivery send_B_Delivery(){
		return new B_Delivery();
	}
	
	//--------------------多个工厂---end-----------------
	
	//----------------------静态工厂---Start-----------------
	
		//创建 针对A类物流发送的方法
		public static Delivery sendStatic_A_Delivery(){
			return new A_Delivery();
		}
		//创建 针对B类物流发送的方法
		public static Delivery sendStatic_B_Delivery(){
			return new B_Delivery();
		}
		
	//--------------------静态工厂---end-----------------------------
}
