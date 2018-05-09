package com.javabase.arithmetic;

/**
 * 
 * 插入排序
 * 
 * @author cjl
 *
 */
public class InsertSort {

	public void insertSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int x=array[i];
			int l=i-1;
			for(;l>=0&& array[l]>x;l--){
				array[l+1]=array[l];
			}
			array[l+1]=x;
		}
	}

}
