package com.prac.dynamic;

/**
 * 求数组中最大的子序列和
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 */
public class MaxSubLen {
    public static void main(String[]args) throws Exception {
        int[]nums={-2,1,-3,4,-1,2,1,-5,4};
        int res=getMaxLen(nums);
        int ret=maxSubLen(nums);
        System.out.println(res+" "+ret);
    }

    private static int getMaxLen(int[] nums) throws Exception {
        if(nums==null||nums.length==0){
            throw new Exception("空数组");
        }
        int res = nums[0];
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            if(sum<=0){
                sum=nums[i];
            }else {
                sum+=nums[i];
            }
            if(sum>res){
                res=sum;
            }
        }
        return res;
    }
    /**
     * 使用动态规划求解
     * 假设f(n)=max(f(n-1)+arr[n],arr[n])
     * f(n)为以数组中第n个数为结尾的子序列的最大和
     */
    public static int maxSubLen(int[]nums) throws Exception {
        if(nums==null||nums.length==0){
            throw new Exception("空数组");
        }
        int f_n=0,res=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            f_n=Math.max(nums[i],f_n+nums[i]);
            res=Math.max(f_n,res);
        }
        return res;
    }
}
