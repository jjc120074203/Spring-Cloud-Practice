package com.design.action.strategy.method;

import org.springframework.stereotype.Service;

import com.design.action.strategy.AlgorithmMethod;
import com.design.action.strategy.AlgorithmSort;

/**
 * 插入排序
 * @author issuser
 *
 */
@Service("InsertSort")
public class AlgorithmInsertSort extends AlgorithmMethod implements AlgorithmSort {

	@Override
	public void Algorithm(int[] array) {
		for (int i = 1; i < array.length; i++) {//数组次数 数组指针指向第二个元素
			int  x=array[i];
			int j=i-1;
			for (; j>=0 && array[j]>x; j--) {
				//前者 大于后者   ，前者交换后者
				array[j+1]=array[j];
			}
			array[j+1]=x;
		}
		AlgorithmResPrint(array,"InsertSort");
	}

}
