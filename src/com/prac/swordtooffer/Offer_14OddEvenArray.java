package com.prac.swordtooffer;

import java.util.Arrays;

/**
 * 将数组中的奇数排到偶数前面
 */
public class Offer_14OddEvenArray {

	public static void main(String[]args){
		int[]arr={2,3,6,8,9,7,4,5,1};
		System.out.print(Arrays.toString(adjust(arr)));
	}

	private static int[] adjust(int[] arr) {
		int i=0,j=arr.length-1;
		if(arr.length==1){
			return arr;
		}
		while (i<j){
			if(arr[i]%2==0&&i<j){
				if(arr[j]%2==1){
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
					i++;
				}
				j--;
			}
			else {
				i++;
			}
		}
		return arr;
	}
}
