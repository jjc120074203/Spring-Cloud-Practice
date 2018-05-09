package com.design.create.norFactory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.design.create.norFactory.Delivery;
import com.design.create.norFactory.DeliveryProvider;

/**
 * @author 工厂test
 *
 */
@RestController
public class FactoryController {

	@Autowired
	@Qualifier("A_Provider_Factory")//当前一个接口实现多个类 指定Spring 注解要加载的bean
	private DeliveryProvider DeliveryProviderA;
	
	@Autowired
	@Qualifier("B_Provider_Factory")//指定Spring 注解要加载的bean
	private DeliveryProvider DeliveryProviderB;
	
	/**
	 * 抽象工厂
	 * @param a
	 * @return
	 */
	@GetMapping("/testAbstractFactory")
	public String testAbstractFactory(int a){
		if (a>0) {
			//定义A类抽象工厂实现方法
			Delivery da=DeliveryProviderA.handleProvider();
			return da.Delivery();
		}
		Delivery dB=DeliveryProviderB.handleProvider();
		return dB.Delivery();
	}
}
