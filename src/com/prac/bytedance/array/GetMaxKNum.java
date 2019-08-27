package com.prac.bytedance.array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class GetMaxKNum {
    public static void main(String[]args){
        int arr[]={8,9,7,6,1,3,4,5,10};//1345678910
        int k=5;
        getKthMaxNum(arr,k);
    }
    private static void getMaxKNum(int[] arr, int k) {
        PriorityQueue<Integer>priority=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            if(priority.size()!=k){
                priority.offer(arr[i]);
            }else {
                priority.peek();
                priority.offer(arr[i]);
            }
        }
        System.out.println(priority.toArray()[priority.size()-k]);
    }

    /**
     * 利用快排
     * @param arr
     * @param k
     */
    private static void getKthMaxNum(int[]arr,int k){
        int left=0,right=arr.length-1;
        int[]copy=arr;
        int index=partition(copy,left,right);
        while (index!=k-1){
            if(index<k-1){
                left=index+1;
                index=partition(copy,left,right);
            }else {
                right=index-1;
                index=partition(copy,left,right);
            }
        }
        System.out.print(copy[k-1]);
    }

    private static int partition(int[] arr, int left, int right) {
        int index=left,l=left+1,r=right;
        while (l<=r){
            if(arr[l]<arr[index]&&arr[index]<arr[r]){
                swap(arr,l++,r--);
            }
            if(arr[l]>arr[index])
                l++;
            if(arr[r]<arr[index])
                r--;
        }
        swap(arr,left,r);
        return index;
    }
    private static void swap(int[] arr, int start, int index) {
        int temp=arr[index];
        arr[index]=arr[start];
        arr[start]=temp;
    }
    private static int RandomInRange(int start, int end) {
        Random random=new Random();
        start=start-1;
        return random.nextInt(end-start+1)+start;
    }
}