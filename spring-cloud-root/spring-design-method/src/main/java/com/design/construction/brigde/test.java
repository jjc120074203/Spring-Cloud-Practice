package com.design.construction.brigde;

import org.junit.Test;

import com.design.construction.brigde.impl.BubblingSort;
import com.design.construction.brigde.impl.HeapSort;
import com.design.construction.brigde.impl.InsertSort;
import com.design.construction.brigde.impl.QuickSort;

public class test {

	@Test
	public void testCon(){
		//定一个 桥
		AbstractBridge ab=new MyBridge();
		int[] array={1,2,9,-1,910,231,2310,123,123,2,10,-90,0};
		//定义oracle 连接
//		Client oc=new BubblingSort();
//		ab.setClient(oc);
//		ab.getConnection(array);
//		print(array);
//		
		//定义 mySql 连接
		Client mc =new InsertSort();
		ab.setClient(mc);
		ab.getConnection(array);
		print(array);
		
	}
	public void print(int[] array){
		for (int i : array) {
			System.out.println(i);
		}
		
	}
	
}
