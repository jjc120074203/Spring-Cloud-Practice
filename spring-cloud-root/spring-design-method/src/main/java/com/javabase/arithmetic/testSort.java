package com.javabase.arithmetic;

import java.util.Iterator;
import java.util.TreeMap;

import org.junit.Test;

public class testSort {

	 @Test
	public void BubblingSort() {
		 System.out.println("___________________BubblingSort____________________________");
		int[] re = { 1, 98, 7, 10, -1, 9, -1, 23 };
		BubblingSort bs = new BubblingSort();
		for (int i = 0; i < bs.BubblingSort(re).length; i++) {
			System.out.println(bs.BubblingSort(re)[i]);
		}
		System.out.println("_______________________BubblingSort________________________");
	}

	 @Test
	public void QuickSort() {
		 System.out.println("_____________________QuickSort__________________________");
		int[] re = { 10, 512, -7, 10, -1, 91, -1, 23, 3, 9 };
		QuickSort qs = new QuickSort();
		qs.QuickSort(re, 0, re.length - 1);
		// qs.QuickSortDesc(re, 0, re.length-1);
		for (int i = 0; i < re.length; i++) {
			System.out.println(re[i]);
		}
		System.out.println("________________________QuickSort_______________________");
	}

	 @Test
	public void InsertSort() {
		System.out.println("________________________InsertSort_______________________");
		int[] aaa = { 3, 7, 5, -1, 2, 3, 4 };
		InsertSort is = new InsertSort();
		is.insertSort(aaa);
		for (int j = 0; j < aaa.length; j++) {
			System.out.println(aaa[j]);
		}
		System.out.println("__________________________InsertSort_____________________");
	}

	 @Test
	public void ShellSort() {
		System.out.println("________________________ShellSort_______________________");
		int[] aaa = { -10, 20, 2, 91, 3, 7, 5, 0, -1, 2, 3, 4, -12 };
		ShellSort is = new ShellSort();
		is.ShellSort(aaa);
		for (int j = 0; j < aaa.length; j++) {
			System.out.println(aaa[j]);
		}
		System.out.println("________________________ShellSort_______________________");
	}

	 @Test
	public void HeapSort() {
		 System.out.println("________________________HeapSort_______________________");
		int[] array = { 8, 7, 6, 6, 10, -1, 0, 2, 20, 13, -2, -3, -5, 9018, 123 };
		HeapSort sh = new HeapSort();
		TreeMap tm = new TreeMap<>();
		tm = sh.HeapSort(array);
		Iterator it = tm.descendingKeySet().iterator();
		while (it.hasNext()) {
			System.out.println(tm.get(it.next()));
		}
		System.out.println("_________________________HeapSort______________________");
	}

	 @Test
	public void SelectSort() {
		 System.out.println("_________________________SelectSort______________________");
		int[] array = { 8, 7, 6, 6, 10, -1, 0, 2, 20, 13, -2, -3, -5 };
		SelectSort ss = new SelectSort();
		ss.SelectSort(array);
		for (int j = 0; j < array.length; j++) {
			System.out.println(array[j]);
		}
		System.out.println("________________________SelectSort_______________________");
	}
//	@Test
//	public void tes() {
//		// 新建
//		File re = new File("D://简历/");
//		re.mkdirs();
//		File fa[] = re.listFiles();
//		for (int i = 0; i < fa.length; i++) {
//			File fs = fa[i];
//			int len=fs.getName().length();
//			System.out.println(fs.getName().substring(0, len-4));
//			File rsss = new File("D://简历/"+fs.getName().substring(0, len-4));
//			rsss.mkdirs();
//		}
//
//	}
}
