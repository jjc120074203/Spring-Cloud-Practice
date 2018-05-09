package com.design.create.norFactory.Factory.abstracts;

import org.springframework.stereotype.Service;

import com.design.create.norFactory.A_Delivery;
import com.design.create.norFactory.Delivery;
import com.design.create.norFactory.DeliveryProvider;

@Service("A_Provider_Factory")
public class A_Provider_Factory implements DeliveryProvider {

	//接口实现对A类物流数据的封装
	@Override
	public Delivery handleProvider() {
		return new A_Delivery();
	}

}
