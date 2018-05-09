
package com.javabase.arithmetic;

import java.util.Iterator;

/**
 * 冒泡排序
 * 
 * @author cjl
 *
 */
public class BubblingSort {

	public int[] BubblingSort(int[] res) {
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res.length - 1 - i; j++) {
				if (res[j] > res[j + 1]) {
					int t = res[j];
					res[j] = res[j + 1];
					res[j + 1] = t;
				}
			}
		}
		return res;

	}
}