package com.prac.swordtooffer;

/**
 * 二维数组中的查找，
 * 由于数组的行列是有序的，
 * 所以可以从数组的右上角进行判断，减少查询次数
 */
public class Offer_one {
	public static void main(String[]args){
		int[][]arr= {{1,2,3,4},
				      {2,6,8,9},
				       {3,7,14,19}};
		int num=11;
		long start=System.nanoTime();
		if(solution(arr,num)){
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
		long end=System.nanoTime();
		System.out.println("耗时："+(end-start)+"ns");
	}

	private static boolean solution(int[][] arr, int num) {
		for(int i=0;i<arr.length;){
			int j=arr[0].length-1;
			if(arr[i][j]>num){
				for (int x = arr[i].length - 1; x > 0; x--) {
					if (arr[i][x] == num) {
						return true;
					}
				}
				return false;
			}
			i++;
		}
		return false;
	}
}
