package com.design.construction.brigde.impl;

import com.design.construction.brigde.Client;

public class InsertSort implements Client {

	@Override
	public void getConection(int[] array) {
	System.out.println("-------------- InsertSort---------------");
		for (int i = 1; i < array.length; i++) {
			int temp=array[i];
			int j=i-1;
			for (;j>=0 && array[j]>temp;j--) {
				array[j+1]=array[j];
			}
			array[j+1]=temp;
		}
	}

}
