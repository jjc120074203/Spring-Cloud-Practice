package com.design.create.norFactory.Factory;

import java.util.ArrayList;
import java.util.List;

import com.design.create.norFactory.A_Delivery;
import com.design.create.norFactory.B_Delivery;
import com.design.create.norFactory.Delivery;

/**
 * @author 建造者模式
 *
 */
public class BuildFactory {

	private List<Delivery> tempList = new ArrayList<Delivery>();

	// 创建A对应的数据格式
	public void A_Provider_Builder(int a) {
		for (int i = 0; i < a; i++) {
			tempList.add(new A_Delivery());// 重复创建数据A
		}
	}

	// 创建B对应的数据格式
	public void B_Provider_Builder(int a) {
		for (int i = 0; i < a; i++) {
			tempList.add(new B_Delivery());// 重复创建数据B
		}
	}
}
