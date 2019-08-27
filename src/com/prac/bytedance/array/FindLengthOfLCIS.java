package com.prac.bytedance.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 查找连续递增的序列
 */
public class FindLengthOfLCIS {
    public static void main(String[]args){
        int[]arr={1,3,5,6,7};
        int res=findLengthOfLCIS(arr);
        System.out.println(res);
    }

    private static int findLengthOfLCIS(int[] arr) {
        List<Integer>res=new ArrayList<>();
        int len=0,cnt=0,cur=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
           if(cur<arr[i])
               cnt++;
           else
               cnt=1;
           len=Math.max(len,cnt);
           cur=arr[i];
        }
        return len;
    }
}
