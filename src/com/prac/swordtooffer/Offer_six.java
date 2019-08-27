package com.prac.swordtooffer;

/**
 * 旋转数组最小的数字
 * 主体思想采用二叉搜索
 */
public class Offer_six {
	static int solution(int[]arr){
		if(arr.length==0){
			return 0;
		}
		int left=0,right=arr.length-1;
		int mid=0;
		while (arr[left]>=arr[right]){
			if(right-left==1){
				break;
			}
			mid=left+(right-left)/2;
			//存在重复元素只能顺序查找
			if(arr[left]==arr[right]&&arr[left]==arr[mid]){
				return findMin(arr);
			}
			if(arr[mid]>=arr[left]){
				left=mid;
			}
			else
			{
				right=mid;
			}
		}
		return arr[mid];
	}

	private static int findMin(int[] arr) {
		int temp=Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++){
			if(arr[i]<temp){
				temp=arr[i];
			}
		}
		return temp;
	}

	public static void main(String[]args){
		int[]arr={2,2,2,2,1,2};
		System.out.print(solution(arr));
	}
}
