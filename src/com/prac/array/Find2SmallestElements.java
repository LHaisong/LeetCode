package com.prac.array;

public class Find2SmallestElements {
	/**
	 * 查找数组中第二小的元素
	 */
	public static int find2SmallestEle(int[]arr){
		int first,second,size=arr.length;
		first=second=Integer.MAX_VALUE;
		if(size<2){
			System.out.println("invalid input");
		}else {
			for(int i=0;i<size;i++){
				if(arr[i]<first){
					second=first;
					first=arr[i];
				}
				//arr[i]在first和second之间，更新second
				if(arr[i]<second&&arr[i]!=first){
					second=arr[i];
				}
			}
		}
		return second;
	}
	public static void main(String[]args){
        int[]arr={1,8,9,2,8,12,6,5,18,3};
        System.out.println(find2SmallestEle(arr));
	}
}
