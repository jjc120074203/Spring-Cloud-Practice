package com.design.action.strategy.method;

import org.springframework.stereotype.Service;

import com.design.action.strategy.AlgorithmMethod;
import com.design.action.strategy.AlgorithmSort;

/**
 * 快速排序
 * @author issuser
 *
 */
@Service("QuickSort")
public class AlgorithmQuickSort extends AlgorithmMethod implements AlgorithmSort {

	@Override
	public void Algorithm(int[] array) {
		int len= array.length;
		QuickSort(array, 0, len-1);
		//打印
		AlgorithmResPrint(array,"QuickSort");
	}
	
	private void QuickSort(int[] array, int start,int end){
		if (start<end) {
			int index=getIndex(array,start,end);
			QuickSort(array, 0, index-1);
			QuickSort(array, index+1, end);
		}
	}

	private int getIndex(int[] array, int start, int end) {
		int  temp=array[start];
		while (start<end) {
			while (start<end && array[end]>temp) {
				end--;
			}
			if (start<end) {
				array[start]=array[end];
				start++;
			}
			while (start<end && temp>=array[start]) {
				start++;
			}
			if (start<end) {
				array[end]=array[start];
				end--;
			}
		}
		array[start]=temp;
		return start;
	}

}
