package com.prac.array;
public class Find1NoDuplicateEle {
	/**
	 * 找到第一个没有重复的元素
	 * @param arr
	 * @return
	 */
	public static int find1NoduplicateEle(int[]arr){
		for(int i=0;i<arr.length;i++) {
			int j;
			for (j = 0; j < arr.length; j++) {
				if (i != j && arr[i] == arr[j]) {
					break;
				}
			}if (j == arr.length)
			     return arr[i];
		}
		return -1;
	}
	public static void main(String[]args){
		int[]arr={-1,2,-1,3,2};
		System.out.println(find1NoduplicateEle(arr));
	}
}
