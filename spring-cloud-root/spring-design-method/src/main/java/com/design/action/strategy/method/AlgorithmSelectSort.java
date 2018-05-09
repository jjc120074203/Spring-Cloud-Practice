package com.design.action.strategy.method;

import org.springframework.stereotype.Service;

import com.design.action.strategy.AlgorithmMethod;
import com.design.action.strategy.AlgorithmSort;

/**
 * 选择排序
 * 
 * @author cjl
 *
 */
@Service("SelectSort")
public class AlgorithmSelectSort extends AlgorithmMethod implements AlgorithmSort {
	@Override
	public void Algorithm(int[] array) {
		//循环
		for (int i = 0; i < array.length - 1; i++) {
			int k = i;
			for (int j = k + 1; j < array.length; j++) {
				if (array[k] > array[j]) {
					k = j;
				}
			}
			if (i != k) {
				int temp = array[i];
				array[i] = array[k];
				array[k] = temp;
			}
		}
		AlgorithmResPrint(array, "Select Sort");
	}

}
