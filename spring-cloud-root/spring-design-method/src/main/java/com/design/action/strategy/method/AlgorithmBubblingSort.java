package com.design.action.strategy.method;

import org.springframework.stereotype.Service;

import com.design.action.strategy.AlgorithmMethod;
import com.design.action.strategy.AlgorithmSort;

/**
 * 冒泡算法
 * @author cjl
 *
 */
@Service("BubblingSort")
public class AlgorithmBubblingSort extends AlgorithmMethod implements AlgorithmSort{
	
	@Override
	public void Algorithm(int[] array) {
		for (int i = 0; i < array.length; i++) {//排序次数
			for (int j = 0; j < array.length-i-1; j++) {//对比交换
				if (array[j]>array[j+1]) {
					int temp  = array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
			
		}
		AlgorithmResPrint(array,"BubblingSort");
	}

}
