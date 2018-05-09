package com.design.create.norFactory.Factory;

import java.util.ArrayList;
import java.util.List;

/**
 * 原型模式
 * @author  cjl
 * 
 * 1.继承Cloneable
 * 2.复写clone()
 *
 */
public class OrignFactory implements Cloneable{

	private String classFactoryName;
	
	private String classFactoryType;
	
	private  Orign orign;
	
	private List<String> list=new ArrayList<String>();
	

  //克隆 自己
	@Override
	public OrignFactory clone() throws CloneNotSupportedException {
		return (OrignFactory) super.clone();
	}

	public String getClassFactoryName() {
		return classFactoryName;
	}

	public void setClassFactoryName(String classFactoryName) {
		this.classFactoryName = classFactoryName;
	}

	public String getClassFactoryType() {
		return classFactoryType;
	}

	public void setClassFactoryType(String classFactoryType) {
		this.classFactoryType = classFactoryType;
	}

	public Orign getOrign() {
		return orign;
	}

	public void setOrign(Orign orign) {
		this.orign = orign;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	//展示clone 数据
	@Override
	public String toString() {
		return "className:"+this.classFactoryName+",classType:"+classFactoryType+",Orign-Name"
				+orign.getClassName() +",Orign-Type"+orign.getClassType()
				+ ",list-size:"+list.size();
	}

	public OrignFactory() {
	
	}

	public OrignFactory(String classFactoryName, String classFactoryType, Orign orign, List<String> list) {
		super();
		this.classFactoryName = classFactoryName;
		this.classFactoryType = classFactoryType;
		this.orign = orign;
		this.list = list;
	}
	
}
