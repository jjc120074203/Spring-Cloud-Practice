
package com.javabase.arithmetic;

/**
 * 快速排序
 * <li>【顺序】 基数大于前者 ，小于等于后者</li>
 * <li>【倒序】 基数小于等于前者 ，大于后者</li>
 * <li>设置一个基础key值</li>
 * <li>从后往前找到比他小/大于等于他的数，找到这个数字，填写到前一个坑里</li>
 * <li>在从前往后找到比它大或者等于/小于等于他的数字，找到后放到填写到前面那个坑里</li>
 * 
 * 
 * 
 * 
 * @author cjl
 *
 */
public class QuickSort {

	/**
	 * 顺序逻辑
	 * 
	 * @param array
	 *            数组
	 * @param start
	 *            数组索引0
	 * @param end
	 *            数组索引最后一位array.length-1
	 * @return
	 */
	public void QuickSort(int[] array, int start, int end) {
		if (start < end) {
			int index = getIndex(array, start, end);
			QuickSort(array, 0, index - 1);
			QuickSort(array, index + 1, end);
		}
	}

	private int getIndex(int[] array, int start, int end) {
		int x = array[start];
		while (start < end) {
			while (start < end && array[end] > x) {
				end--;
			}
			if (start < end) {
				array[start] = array[end];
				start++;
			}
			while (start < end && x >= array[start]) {
				start++;
			}
			if (start < end) {
				array[end] = array[start];
				end--;
			}
		}
		array[start] = x;
		return start;
	}

}