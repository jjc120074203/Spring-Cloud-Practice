package com.design.construction.brigde.impl;

import com.design.construction.brigde.Client;

public class ShellSort implements Client {

	@Override
	public void getConection(int[] arrary) {
		System.out.println("---------ShellSort---------");
		//分组
		for (int space = arrary.length/2; space>0; space=space/2) {
			//内层排序次数
			for (int i = 0; i < space; i++) {
				//进行插排
				for (int j = space+i; j < arrary.length; j+=space) {
					int temp=arrary[j];
					int k=j-1;
					for (; k>=0 && arrary[k]>temp;k--) {
						arrary[k+1]=arrary[k];
					}
					arrary[k+1]=temp;
				}
			}
		}
		
	}

}
