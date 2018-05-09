package com.design.construction.brigde.impl;

import com.design.construction.brigde.Client;

public class HeapSort implements Client {

	@Override
	public void getConection(int[] arrary) {
		System.out.println("-------------- HeapSort---------------");
		int len = arrary.length;
		// 创建堆
		for (int i = (len - 1) / 2; i >= 0; i--) {
			heapTree(arrary, len, i);
		}
		// 排列顺序
		int n = arrary.length;
		while (n > 0) {
			System.out.println(arrary[0]);
			arrary[0] = arrary[n - 1];
			n--;
			// 只整理头结点
			heapTree(arrary, n, 0);
		}

	}

	/**
	 * 
	 * @param arrary
	 *            数组排序代码
	 * @param length
	 *            数组长度有效值
	 * @param i
	 *            当前节点数据
	 */
	private void heapTree(int[] arrary, int length, int k) {
		int left = 2 * k + 1;

		int right = 2 * k + 2;

		if (left >= length && right >= length) {
			return;
		}

		int tL = Integer.MAX_VALUE;
		int tR = Integer.MAX_VALUE;

		if (left < length) {
			tL = arrary[left];
		}
		if (right < length) {
			tR = arrary[right];
		}

		if (arrary[k] < tL && arrary[k] < tR) {
			return;
		}

		if (tL < tR) {
			swap(arrary, k, left);
			heapTree(arrary, length, left);
		} else {
			swap(arrary, k, right);
			heapTree(arrary, length, right);
		}

	}

	private void swap(int[] arrary, int i, int idxLeft) {
		int temp = arrary[i];
		arrary[i] = arrary[idxLeft];
		arrary[idxLeft] = temp;
	}

}
