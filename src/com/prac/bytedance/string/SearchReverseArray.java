package com.prac.bytedance.string;

/**
 * 搜索旋转排序数组
 */
public class SearchReverseArray {
    public static void main(String[]args){
        int arr[]={7,8,9,0,1,2,3,4,5,6},tar=5;
        int index=getIndex(arr,tar);
        System.out.println(index);
    }

    /**
     * 二叉搜索变形
     * @param nums
     * @param tar
     * @return
     */
    private static int getIndex(int[] nums, int tar) {
        int left=0,right=nums.length-1,mid;
        if(nums.length==0)
            return -1;
        while (left<right){
            mid=(left+right)>>1;
            if (nums[mid] == tar) return mid;
            if (nums[mid] >= nums[left]) {
                if (nums[left] <= tar && nums[mid] > tar)
                    right = mid - 1;
                else
                    left = mid + 1;
            } else {
                if (nums[mid] < tar && nums[right] >= tar)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -2;
    }
}
