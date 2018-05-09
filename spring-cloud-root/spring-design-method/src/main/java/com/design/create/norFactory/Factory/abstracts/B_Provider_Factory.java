package com.design.create.norFactory.Factory.abstracts;

import org.springframework.stereotype.Service;

import com.design.create.norFactory.B_Delivery;
import com.design.create.norFactory.Delivery;
import com.design.create.norFactory.DeliveryProvider;

@Service("B_Provider_Factory")
public class B_Provider_Factory implements DeliveryProvider {

	//接口实现对B类物流数据的封装
	@Override
	public Delivery handleProvider() {
		return new B_Delivery();
	}

}
