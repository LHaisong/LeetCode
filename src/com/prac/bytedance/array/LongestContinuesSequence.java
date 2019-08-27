package com.prac.bytedance.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个数组，求其中最长的连续序列
 * 例：[200,1,2,100,4,3]---->[1,2,3,4]  len=4
 */
public class LongestContinuesSequence {
    public static void main(String[]args) throws Exception {
        int[]arr={ 1 , 23 , 2 , 300 , 3 , 9 ,4 , 5 , 90 };
        longestSeq(arr);
        getLongestSeq(arr);
    }

    /**
     * 使用快排？
     * 先对数组进行排序，再取最长的子序列
     * 时间复杂度O(nlogn),空间复杂度O(1)
     * @param arr
     */
    private static void longestSeq(int[] arr) throws Exception {
        Arrays.sort(arr);
        int len=1,longest=0;
        if(arr==null||arr.length==0){
            throw new Exception("非法输入");
        }
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]+1==arr[i+1]){
                len++;
                longest=Math.max(len,longest);
            }else {
                len=1;
            }
        }
        for(int i=0;i<arr.length-longest;i++){
            if (arr[i] + longest-1 == arr[i+longest-1]) {
                for(int j=i;j<i+longest;j++){
                    System.out.print(arr[j]+" ");
                }
            }
        }
        System.out.println("\n\r"+longest);
    }
    /**
     * 使用HashSet存放数组数据，每次查看当前数据的前一个数和后一个数是否存在
     */
    public static void getLongestSeq(int[]arr) throws Exception {
        Set<Integer>numsSet=new HashSet<>();
        int res=0;
        if(arr==null||arr.length==0){
            throw new Exception("非法输入");
        }
        for(int tar:arr){
            numsSet.add(tar);
        }
        for(int num:arr) {
            if (numsSet.remove(num)){
                int pre=num-1,next=num+1;
                while (numsSet.remove(pre)) pre--;
                while (numsSet.remove(next)) next++;
                res=Math.max(res,next-pre-1);
            }
        }
        System.out.println(res);
    }
}
