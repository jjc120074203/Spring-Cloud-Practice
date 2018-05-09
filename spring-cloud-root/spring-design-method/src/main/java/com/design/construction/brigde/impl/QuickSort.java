package com.design.construction.brigde.impl;

import com.design.construction.brigde.Client;

public class QuickSort implements Client {

	@Override
	public void getConection(int[] arrary) {
		System.out.println("-------------- QuickSort---------------");
		QuickSort(arrary,0,arrary.length-1);
		
	}

	public void QuickSort(int[] array, int start, int end) {
		if (start < end) {
			int index = getIndex(array, start, end);
			QuickSort(array, 0, index - 1);
			QuickSort(array, index + 1, end);
		}
	}

	public int getIndex(int[] array, int start, int end) {
		// 定义基数
		int x = array[start];
		while (start < end) {
			while (start < end && array[end] > x) {
				end--;
			}
			if (start < end) {
				array[start] = array[end];
				start++;
			}
			while (start < end && x >= array[start]) {
				start++;
			}
			if (start < end) {
				array[end] = array[start];
				end--;
			}
		}
		array[start] = x;
		return start;

	}

}
