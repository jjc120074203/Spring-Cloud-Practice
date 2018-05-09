package com.design.action.strategy.method;

import org.springframework.stereotype.Service;

import com.design.action.strategy.AlgorithmMethod;
import com.design.action.strategy.AlgorithmSort;

/**
 * 希尔排序
 * 
 * @author cjl
 *
 */
@Service("ShellSort")
public class AlgorithmShellSort extends AlgorithmMethod implements AlgorithmSort {

	@Override
	public void Algorithm(int[] array) {
		// 最小增量插排
		int len = array.length;
		// 1.下面计算分组数
		for (int group = len / 2; group > 0; group = group / 2) {
			// 2.循环组数
			for (int i = 0; i < group; i++) {
				// 对每个游标进插入排序
				for (int j = i+group; j < array.length; j+=group) {
					int temp=array[j];
					int k=j-1;
					for (; k>0 && array[k]>temp; k--) {
						array[k+1]=array[k];
					}
					array[k+1]=temp;
				}
			}
		}
		AlgorithmResPrint(array,"ShellSort");

	}

}
