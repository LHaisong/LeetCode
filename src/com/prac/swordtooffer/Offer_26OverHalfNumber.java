package com.prac.swordtooffer;

import java.util.Random;

/**
 * 寻找数组中出现次数超过数组长度一半的数字
 * 利用快排的思想，当index在中间时
 * 的值必为出现次数大于数组长度一半的数
 */
public class Offer_26OverHalfNumber {
    public static void main(String[]args){
        int[]arr={1,2,3,2,3,2};
        findNum(arr);
    }

    private static void findNum(int[] arr) {
        int len=arr.length;
        if(len==0){
            return;
        }
        int middle=arr.length>>1;
        int start=0;
        int end=arr.length-1;
        int index=partition(arr,len,start,end);
        while (index!=middle){
            if(index>middle){
                end=index-1;
                index=partition(arr,len,start,end);
            }
            else {
                start=index+1;
                index=partition(arr,len,start,end);
            }
        }
        int result=arr[middle];
        System.out.print(result);
    }

    public static int partition(int[] arr, int len, int start, int end) {
        if(arr.length==0){
            return -1;
        }
        int index= RandomInRange(start,end);
        while (start!=end){
            if(arr[end]<=arr[index]) {
                if (arr[start] > arr[index]) {
                    swap(arr, start, end);
                    start++;
                }
            }
            end--;
        }
        return index;
    }

    private static void swap(int[] arr, int start, int index) {
        int temp=arr[index];
        arr[index]=arr[start];
        arr[start]=temp;
    }

    /**
     * 获取start-end之间的一个随机数
     * @param start
     * @param end
     * @return
     */
    private static int RandomInRange(int start, int end) {
        Random random=new Random();
        start=start-1;
        return random.nextInt(end-start+1)+start;
    }
}
