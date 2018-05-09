package com.design.construction.brigde;

public abstract class AbstractBridge {
	private Client client;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	//定义一个空方法 
	public void getConnection(int[] array){
		System.out.println("-----方法被重新写----");
	}

}
