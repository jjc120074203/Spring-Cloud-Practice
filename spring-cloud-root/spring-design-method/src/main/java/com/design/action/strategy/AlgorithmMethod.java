package com.design.action.strategy;

import java.util.Iterator;
import java.util.TreeMap;

public abstract class AlgorithmMethod {
	
	//算法打印
	public void AlgorithmResPrint(int[] array,String name){
		System.out.println("-------------------------"+name+"-----------------------");
		for (int i : array) {
			System.out.println(i);
		}
		System.out.println("-------------------------"+name+"-----------------------");
	}
	
	public void AlgorithmMapPrint(TreeMap tm,String name){
		System.out.println("-------------------------"+name+"-----------------------");
		//倒序遍历
		Iterator it=tm.descendingKeySet().iterator();
		while (it.hasNext()) {
			System.out.println(tm.get(it.next()));
		}
		System.out.println("-------------------------"+name+"-----------------------");

	}
}
