package com.javabase.arithmetic;

/**
 * 希尔排序根据 分组插入排序，该方法又称缩小增量排序
 * 
 * @author cjl
 *
 */
public class ShellSort {

	public void ShellSort(int ar[]) {
		int len=ar.length;
		
		for (int space = len/2; space >0; space=space/2) {
			for (int i = 0; i < space; i++) {
				for (int j = i+space; j < ar.length; j++) {
					int x=ar[j];
					int k=j-1;
					for (; k>=0 && ar[k]>x; k--) {
						ar[k+1]=ar[k];
					}
					ar[k+1]=x;
				}
			}
		}
	}

}
