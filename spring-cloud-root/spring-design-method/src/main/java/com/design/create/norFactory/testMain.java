package com.design.create.norFactory;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.design.create.norFactory.Factory.BuildFactory;
import com.design.create.norFactory.Factory.NorFactory;
import com.design.create.norFactory.Factory.Orign;
import com.design.create.norFactory.Factory.OrignFactory;
import com.design.create.norFactory.Factory.abstracts.A_Provider_Factory;
import com.design.create.norFactory.Factory.abstracts.B_Provider_Factory;

public class testMain {

	// 调用普通工厂
	public void testSigle() {
		NorFactory nor = new NorFactory();
		Delivery send = nor.sendSingleDelivery(3);
		// 调用
		System.out.println(send.Delivery());
	}

	// 调用多个工厂
	public void testMul() {
		NorFactory nor = new NorFactory();
		Delivery sendA = nor.send_A_Delivery();
		System.out.println(sendA.Delivery());
		Delivery sendB = nor.send_B_Delivery();
		System.out.println(sendB.Delivery());
	}

	// 调用静态工厂
	public void testStatic() {
		Delivery sendA = NorFactory.sendStatic_A_Delivery();
		System.out.println(sendA.Delivery());
		Delivery sendB = NorFactory.sendStatic_B_Delivery();
		System.out.println(sendB.Delivery());
	}

	// @Test
	// 调用抽象工厂
	public void testAbstact() {
		/*
		 * 采用注解注释
		 * 
		 * @Autowired
		 * 
		 * @Qualifier("XXXXname") private DeliveryProvider DeliveryProvider;
		 */
		DeliveryProvider DpA = new A_Provider_Factory();
		Delivery Dps = DpA.handleProvider();
		System.out.println(Dps.Delivery());
		// 采用注解注释
		DeliveryProvider DpB = new B_Provider_Factory();
		Delivery Dpsb = DpB.handleProvider();
		System.out.println(Dpsb.Delivery());
	}

	// @Test
	// 调用抽象工厂
	public void testBuilder() {
		BuildFactory bf = new BuildFactory();
		bf.A_Provider_Builder(4);
		bf.B_Provider_Builder(3);
	}
	@Test
	// 调用抽象工厂
	public void testOrgin() throws CloneNotSupportedException {
		Orign or1=new Orign("O1","O2");
		 List<String> list=new ArrayList<String>();
		 list.add("1");
		 list.add("2");
		 list.add("3");
		 list.add("4");
		OrignFactory nof=new OrignFactory("OF1","OF2",or1,list);
		System.out.println(nof.toString());
		System.out.println("-------------复制------------------");
		OrignFactory nof2=nof.clone();
		System.out.println(nof2.toString());
		Orign or2=new Orign("O3","O4");
		System.out.println("---------------从新赋值----------------");
		nof2.setOrign(or2);
		nof2.getList().remove(3);
		System.out.println(nof2.toString());
	}
	
	
}
