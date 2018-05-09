package com.design.action.strategy;

import java.io.IOException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.design.action.strategy.method.AlgorithmBubblingSort;
import com.design.action.strategy.method.AlgorithmHeapSort;
import com.design.action.strategy.method.AlgorithmInsertSort;
import com.design.action.strategy.method.AlgorithmQuickSort;
import com.design.action.strategy.method.AlgorithmSelectSort;
import com.design.action.strategy.method.AlgorithmShellSort;
public class testAlgorithm {

	@Autowired
	@Qualifier(value = "InsertSort")
	private AlgorithmSort InsertSort;

	@Autowired
	@Qualifier(value = "ShellSort")
	private AlgorithmSort ShellSort;

	@Autowired
	@Qualifier(value = "QuickSort")
	private AlgorithmSort QuickSort;

	@Autowired
	@Qualifier(value = "BubblingSort")
	private AlgorithmSort BubblingSort;
	@Autowired
	@Qualifier(value = "HeapSort")
	private AlgorithmSort HeapSort;
	@Autowired
	@Qualifier(value = "SelectSort")
	private AlgorithmSort SelectSort;

	@Test
	public void testMain() throws IOException {
		AlgorithmSort InsertSort=new AlgorithmInsertSort();
		AlgorithmSort ShellSort=new AlgorithmShellSort();
		AlgorithmSort QuickSort=new AlgorithmQuickSort();
		AlgorithmSort BubblingSort=new AlgorithmBubblingSort();
		AlgorithmSort HeapSort=new AlgorithmHeapSort();
		AlgorithmSort SelectSort=new AlgorithmSelectSort();
		int a=1;
//		int[] base={12,14,81,11,13,-1,-12,0,291,-12,-101,-123,-2,12151,12312,78899};
		int[] base={1,2,9,-1,910,231,2310,123,123,2,10,-90,0};
		switch (a) {
		case 1:
//			InsertSort.Algorithm(base);
//			ShellSort.Algorithm(base);
//			QuickSort.Algorithm(base);
//			BubblingSort.Algorithm(base);
			HeapSort.Algorithm(base);
//			SelectSort.Algorithm(base);
			break;

		default:
			break;
		}
		
		
	}
	
}
