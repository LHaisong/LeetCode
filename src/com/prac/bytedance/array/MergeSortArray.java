package com.prac.bytedance.array;

public class MergeSortArray {
	/**
	 * 合并两个有序数组
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	static int[] mergeSortArray(int []arr1,int[]arr2){
		int len=arr1.length+arr2.length;
		int[]temp=new int[len];
		int index1=0,index2=0,index=0;
		while(index1<arr1.length&&index2<arr2.length){
				if (arr1[index1] < arr2[index2]) {
					temp[index++] = arr1[index1++];
			}
				else  {
					temp[index++] = arr2[index2++];
				}
			}
		while (index1<arr1.length){
			temp[index++]=arr1[index1++];
		}
		while (index2<arr2.length){
			temp[index++]=arr2[index2++];
		}
		return temp;
	}
	public static void main(String[]args){
		int[]a1={2,4,6};
		int[]a2={1,3,8,9,9};
		int[]res=mergeSortArray(a1,a2);
		for(int i=0;i<a1.length+a2.length;i++){
			System.out.print(res[i]+" ");
		}
	}
}
