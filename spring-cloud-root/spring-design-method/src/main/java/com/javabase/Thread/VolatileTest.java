package com.javabase.Thread;

import org.junit.Test;

public class VolatileTest{
	
	int a=1;
	int b=2;
	
	//赋值操作
	public  void change(){
		a=3;
		b=a;
	}
	 
	//打印操作
	public  void print(){
		System.out.println("b:"+b+",a:"+a);
	}
	
	@Test
	public void testNorMal(){
		VolatileTest vt=new VolatileTest();
		
	 for (int i = 0; i < 100000; i++) {
		 new Thread(new Runnable() {
				@Override
				public void run() {
					 try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 vt.change();
				}
			}).start();
			
			
			new Thread(new Runnable() {
				@Override
				public void run() {
					 try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 vt.print();
				}
			}).start();
	}	
		
		
	}
}