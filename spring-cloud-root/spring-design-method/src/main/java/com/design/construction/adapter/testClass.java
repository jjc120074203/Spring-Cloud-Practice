package com.design.construction.adapter;

public class testClass {

	public static void main(String[] args) {
		int[] aaa = { 3, 7, 5, -1, 2, 3, 4, 9, -1, 10, 11 };
		Adapter a = new Adapter();
		a.InsortSort(aaa);
//		a.BubblingSort(aaa);
//		a.QuickSort(aaa, 0, aaa.length-1);
		for (int i : aaa) {
			System.out.println(i);
		}
	}
}
