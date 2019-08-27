package com.prac.bytedance.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组，输出数组中和为0的全部3个数，不能有重复
 * nums = [-1, 0, 1, 2, -1, -4,-2]
 * [-1,0,1],[-1,2,-1]
 */
public class ThreeSum {
    public static void main(String[]args){
        int[]nums={-1, 0, 1, 2, -1, -4};
        int tar=0;
        List<List<Integer>>res=threeSum(nums,tar);
        for(List list:res){
            System.out.println(list);
        }
    }

    /**
     * 蛮力法，不能解决重复放入问题
     * @param nums
     * @param tar
     * @return
     */
    private static List<List<Integer>> getThreeSum(int[] nums,int tar) {
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>rs=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length-2;k++){
                    if(nums[i]+nums[j]+nums[k]==tar){
                        rs.add(nums[i]);rs.add(nums[j]);rs.add(nums[k]);
                        res.add(rs);
                        rs=null;
                    }
                }
            }
        }
        return res;
    }
    //-4 -1 -1 0 1 2
    public static List<List<Integer>> threeSum(int[] num,int tar) {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = tar - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    }
                    if (num[lo] + num[hi] < sum)
                        lo++;
                    if (num[lo] + num[hi] > sum)
                        hi--;
                }
            }
        }
        return res;
    }
}
