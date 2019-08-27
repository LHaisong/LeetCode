package com.prac.swordtooffer;

/**
 * 求解连续子数组最大和
 * 时间复杂度O(n)
 */
public class Offer_28MaxContinuousSubArr {
    public static void main(String[]args){
        int[]arr={1,-2,3,10,-4,7,2,-5};
        findSubArrSum(arr);
    }
    private static void findSubArrSum(int[] arr) {
        if(arr.length==0){
            System.out.println("数组长度为0，重新输入.........");
        }
        int sum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(sum<=0){
                sum=arr[i];
            }else {
                sum+=arr[i];
            }
            if(sum>maxSum){
                maxSum=sum;
            }
        }
        System.out.println(maxSum);
    }
}
