package com.prac.bytedance.array;

/**
 * LeetCode 接雨水
 * https://blog.csdn.net/xygy8860/article/details/46841579
 */
public class Rainwater {
    public static void main(String[]args){
        int[]height={0,1,0,2,1,0,1,3,2,1,2,1};
        try {
            System.out.println(countWater(height));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int countWater(int[] height) throws Exception {
        if(height==null||height.length==0){
            throw new Exception("请输入正确的数组");
        }
        if(height.length<=1){
            return 0;
        }
        int ans=0,i=0,j=height.length-1,secHeight=0;
        while (i<j){
            if(height[i]<height[j]){
                secHeight=Math.max(secHeight,height[i]);
                ans=ans+secHeight-height[i];
                i++;
            }else {
                secHeight=Math.max(secHeight,height[j]);
                ans+=secHeight-height[j];
                j--;
            }
        }
        return ans;
    }
}
