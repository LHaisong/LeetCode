package com.prac.array;

import java.util.HashMap;
import java.util.Map;

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

	/**
	 * 线性复杂度,使用hash表
	 * @param arr
	 * @return
	 */
	public static void getSingleNumber(int [] arr){
		if(arr.length ==0||arr==null){
			throw new IllegalArgumentException("arr为空");
		}
		if(arr.length ==1){
			System.out.println(arr [0]);
		}
		Map<Integer, Integer>map=new HashMap<>();
		for(int i=0;i<arr.length;i++){
			Integer value=map.get(arr[i]);
			map.put(arr[i],(value==null?0:value)+1);
		}
		for (Map.Entry<Integer, Integer> entry :map.entrySet()) {
		    if(entry.getValue() == 1){
		    	System.out.println(entry.getKey());
			}
		}
	}

	/**
	 * 使用异或运算
	 * @param arr
	 */

	public static void getSingleNumber2(int[] arr){
		int res=0;
		for (int i:arr) {
			res ^=i;
		}
		System.out.println(res);
	}

	public static void main(String[]args){
		int[]arr={-1,2,-1,3,2};
		getSingleNumber(arr);
		getSingleNumber2(arr);
		System.out.println(find1NoduplicateEle(arr));
	}
}
