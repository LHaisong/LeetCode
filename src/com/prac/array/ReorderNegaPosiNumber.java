package com.prac.array;

public class ReorderNegaPosiNumber {
	static int[] reorderNegPosiNumber(int[]arr){
		int temp=0;
		for(int i=0;i<arr.length;i++){
			int j;
			switch (i%2){
				case 0:
					if(arr[i]<0){
						for(j=arr.length-1;j>i;j--){
							if(arr[j]>0){
								temp=arr[i];
								arr[i]=arr[j];
								arr[j]=temp;
								break;
							}
						}
					}
					break;
				case 1:
					if(arr[i]>0){
						for(j=arr.length-1;j>i;j--){
							if(arr[j]<0){
								temp=arr[i];
								arr[i]=arr[j];
								arr[j]=temp;
								break;
							}
						}
					}
					break;
			}
		}
		return arr;
	}
	public static void main(String[]args){
		int[]test={-1,-2,3,-4,5,6,7,-8,9,10,-5,-9,-8};
		int[] res=reorderNegPosiNumber(test);
		for(int i=0;i<test.length;i++){
			System.out.print(res[i]+" ");
		}
	}
}
