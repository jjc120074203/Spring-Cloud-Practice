/**
 * 
 */
/**
 * @author issuser
 *
 */
package com.design.construction.adapter;

/**
 * 
 * 类适配器
 * 
 * @author cjl
 *
 */
public class CalssAdapter {

	public void InsortSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			int j = i - 1;
			for (; j >= 0 && array[j] > temp; j--) {
				array[j + 1] = array[j];
			}
			array[j + 1] = temp;
		}
	}

}