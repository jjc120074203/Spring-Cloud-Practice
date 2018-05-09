package com.design.construction.adapter;

/**
 * 
 * @author cjl
 *
 */
public class Adapter extends CalssAdapter implements ClassIntefacer {

	// 由于继承关系 导致 CalssAdapter 中已经有InsertSort方法了，直接适配InsertSort
	// Adapter 中不需实现InsertSort，只需要实现QuickSort方法
	@Override
	public void QuickSort(int[] array, int sss, int eee) {
		QS(array, sss, eee);
	}


	@Override
	public void BubblingSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length-1-i; j++) {
				if (array[j]>array[j+1]) {
					int temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
		}
		
	}

	private void QS(int[] array, int s, int e) {
		if (s<e) {
			int index=getIndex(array, s, e);
			QS(array, 0, index-1);
			QS(array, index+1,e);
		}
	}

	private int getIndex(int[] a, int s, int e) {
		int x =a[s];
		while (s<e) {
			while (s<e && a[e]>x) {
				e--;
			}
			if (s<e) {
				a[s]=a[e];
				s++;
			}
			while (s<e && x>=a[s]) {
				s++;
			}
			if (s<e) {
				a[e]=a[s];
				e--;
			}
		}
		a[s]=x;
		return s;
	}


}
