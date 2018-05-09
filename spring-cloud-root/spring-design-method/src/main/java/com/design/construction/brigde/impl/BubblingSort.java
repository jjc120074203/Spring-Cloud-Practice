package com.design.construction.brigde.impl;

import com.design.construction.brigde.Client;

public class BubblingSort implements Client {

	@Override
	public void getConection(int[] array) {
		System.out.println("-------------- BubblingSort---------------");
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length-i-1; j++) {
				if (array[j]>array[j+1]) {
					int temp= array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
			
		}
	}

}
