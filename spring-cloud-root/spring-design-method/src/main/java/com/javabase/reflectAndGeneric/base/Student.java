package com.javabase.reflectAndGeneric.base;

public class Student extends BaseEntity {
	public int age = 30;
	public String name = "byhieg";
	private Integer score = 60;

	public void printName() {
		System.out.println(name);
	}
	public void printAll() {
		System.out.println(age+"--"+name);
	}
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	// 创建3个构造器 start
	public Student() {

	}

	public Student(String name) {

	}

	public Student(int age, Integer score) {

	}

	// 创建3个构造器 end
	
	
	@Override
	public void doSomething() {
		super.doSomething();
	}

	@Override
	public void run() {
		System.out.println("run......");
	}
}
