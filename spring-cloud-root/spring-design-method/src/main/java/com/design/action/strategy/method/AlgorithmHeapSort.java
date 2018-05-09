package com.design.action.strategy.method;

import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.design.action.strategy.AlgorithmMethod;
import com.design.action.strategy.AlgorithmSort;

@Service("HeapSort")
public class AlgorithmHeapSort extends AlgorithmMethod implements AlgorithmSort {

	@Override
	public void Algorithm(int[] array) {
		TreeMap tm = new TreeMap<>();
		int len = array.length;
		// 1. 建立基础堆结构
		for (int i = (len - 1) / 2; i >= 0; i--) {
			heapTree(array, len, i);
		}

		// 2.获取的那个区值
		int len1 = array.length;
		while (len1 > 0) {
			tm.put(len1, array[0]);
			array[0] = array[len1 - 1];
			len1--;
			heapTree(array, len1, 0);
		}
		AlgorithmMapPrint(tm, "HeapSort");
	}

	/**
	 * 整理堆排序 内容
	 * 
	 * @param array
	 * @param len
	 * @param i
	 */
	private void heapTree(int[] array, int len, int i) {
		int indexLeft = 2 * i + 1;
		int indexRight = 2 * i + 2;

		// 判断左右孩子Inde长度大于数组长度的话，当前index 对应的元素就是叶子节点
		if (indexLeft >= len && indexRight >= len) {
			return;
		}

		int tempL = Integer.MAX_VALUE;
		int tempR = Integer.MAX_VALUE;

		// 赋值
		if (indexLeft < len) {
			tempL = array[indexLeft];
		}
		if (indexRight < len) {
			tempR = array[indexRight];
		}
		// 判断 父节点的值是否小于当前叶子节点 数值 ，如果满足就说明满足小顶堆结构
		if (tempL > array[i] && tempR > array[i]) {
			return;
		}
		// 比较 叶子节点的大小，把最小的与父类节点进行交换
		if (tempL < tempR) {
			swap(array, i, indexLeft);
			heapTree(array, len, indexLeft);
		} else {
			swap(array, i, indexRight);
			heapTree(array, len, indexRight);
		}
	}

	private void swap(int[] array, int i, int indexLeft) {
		int t = array[i];
		array[i] = array[indexLeft];
		array[indexLeft] = t;
	}

}
