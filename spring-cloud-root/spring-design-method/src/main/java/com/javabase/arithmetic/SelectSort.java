package com.javabase.arithmetic;

/**
 * 选择排序
 * 
 * @author cjl
 *
 */
public class SelectSort {

	public void SelectSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int k=i;
			for (int j = k+1; j < array.length; j++) {
				if (array[k]>array[j]) {
					k=j;
				}
			}
			if (i!=k) {
				int t=array[i];
				array[i]=array[k];
				array[k]=t;
			}
		}
	}

}
