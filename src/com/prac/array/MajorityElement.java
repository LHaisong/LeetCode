package com.prac.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 求数组中的众数(出现次数>n/2)，假设存在
 */
public class MajorityElement {
    public static void main(String [] args) {
        int[]arr={2,2,1,1,1,2,2};
        getMajorityElement(arr);
        getMajorityElement1(arr);
        getMajorityElement2(arr);
    }

    /**
     * 将arr排序，取出中间那个
     * 快排O(nlogn)
     * @param arr
     */
    private static void getMajorityElement(int[] arr) {
        Arrays.sort(arr);
        System.out.println(arr[arr.length>>1]);
    }

    /**
     * 使用hash表
     * 空间时间复杂度都为 O（n）
     * @param arr
     */
    public static void getMajorityElement1(int[]arr){
        Map<Integer, Integer>map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(arr[i])){
                map.put(arr [i], 1);
            }else {
                map.replace(arr[i],map.get(arr [i])+1);
            }
        }
        /*查找map中出现次数大于n/2的众数*/
        for (Map.Entry<Integer, Integer> entry:map.entrySet()) {
            if(entry.getValue()>arr.length>>1){
                System.out.println(entry.getKey());
            }
        }
    }

    /**
     * 使用摩尔投票法
     * @param arr={2,2,1,1,1,2,2}
     */
    public static void getMajorityElement2(int[]arr){
        int count=1,res=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]==res){
                count++;
            }else {
                count--;
                if(count ==0){
                    res=arr[i];
                    count++;
                }
            }
        }
        System.out.println(res);
    }
}
