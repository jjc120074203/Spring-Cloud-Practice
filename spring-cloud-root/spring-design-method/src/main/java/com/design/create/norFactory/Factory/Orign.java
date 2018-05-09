package com.design.create.norFactory.Factory;


/**
 * @author 定义原型bean
 *
 */
public class Orign {
	private String className;
	
	private String classType;

	
	public Orign(String className, String classType) {
		super();
		this.className = className;
		this.classType = classType;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}
	
	
}
