package com.design.construction.brigde;

public class MyBridge extends AbstractBridge{
	
	//重写空方法
	public void getConnection(int[] array){
		getClient().getConection(array);
	}
}
