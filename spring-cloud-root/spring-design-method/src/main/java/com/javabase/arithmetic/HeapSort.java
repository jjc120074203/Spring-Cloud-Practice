package com.javabase.arithmetic;

import java.util.Iterator;
import java.util.TreeMap;

/**
 * 堆排序
 * 
 * @author cjl
 *
 */
public class HeapSort {

	public TreeMap HeapSort(int[] array) {
		TreeMap tm = new TreeMap<>();
		// 建立堆的过程
		int len = array.length;
		for (int i = (len - 1) / 2; i >= 0; i--) {
			HeapMap(array, len, i);
		}
		int n = array.length;
		while (n > 0) {
			tm.put(n, array[0]);
			array[0] = array[n - 1];
			n--;
			HeapMap(array, n, 0);
		}
		return tm;
	}

	private void HeapMap(int[] array, int len, int i) {
		int iLeft = 2 * i + 1;
		int iRight = 2 * i + 2;

		if (iLeft >=len && iRight >= len) {
			return;
		}
		int iL = Integer.MAX_VALUE;
		int iR = Integer.MAX_VALUE;
		
		if (iLeft < len) {
			iL = array[iLeft];
		}
		if (iRight < len) {
			iR = array[iRight];
		}
		if (iL > array[i] && iR > array[i]) {
			return;
		}
		if (iL < iR) {
			swap(array, i, iLeft);
			HeapMap(array, len, iLeft);
		} else {
			swap(array, i, iRight);
			HeapMap(array, len, iRight);
		}
	}

	private void swap(int[] array, int i, int iLeft) {
		int t = array[i];
		array[i] = array[iLeft];
		array[iLeft] = t;
	}

}
