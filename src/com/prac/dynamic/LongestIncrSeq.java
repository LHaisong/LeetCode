package com.prac.dynamic;

import java.util.Arrays;

/**
 * 最长递增子序列
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 */
public class LongestIncrSeq {
    public static void main(String[]args){
        int[]seq={1,3,5,2,7,7,8};
        int ret=longestIncrSubSeq1(seq);
        System.out.println(ret);
    }

    /**
     *复杂度O(n^2)
     * @param seq 目标序列
     * @return 长度
     */
    private static int longestIncrSubSeq(int[] seq) {
        if(seq==null||seq.length==0){
            return -1;
        }
        int[] dp = new int[seq.length];
        int res=1;
        Arrays.fill(dp,1);
        for(int i=1;i<seq.length;i++){
            for(int j=0;j<i;j++){
                if(seq[i]>seq[j]){
                    if(dp[j]+1>dp[i]){// 1 2 3 1
                        dp[i]=Math.max(dp[i],dp[j]+1);
                    }
                }
            }
            res=Math.max(res,dp[i]);
        }
        return res;
    }

    /**
     * 使用二分查找的辅助方法
     * @param seq 目标序列
     * @return 长度
     */
    private static int longestIncrSubSeq1(int[]seq){
        if(seq.length==0||seq==null){
            return -1;
        }
        int[]help=new int[seq.length];
        seq[0]=help[0];
        int end=0;
        for(int i=1;i<seq.length;i++){
           /* 如果seq中当前遍历的数大于help数组中的最后一个数，直接添加
            否则需要在help数组中找到合适的插入位置*/
            if(seq[i]>=help[end]){
                help[++end]=seq[i];
            }else {
                int pos=findInsertPos(help,seq[i],0,end);
                help[pos]=seq[i];
            }
        }
        return end+1;
    }

    /**
     * 二分查找在help数组中第一个大于tar的位置
     * @param help 帮助数组
     * @param tar 目标值
     * @param start 开始位置
     * @param end 结束位置
     * @return 大于目标的第一个值的位置
     */
    private static int findInsertPos(int[] help, int tar, int start, int end) {
        while (start<end){
            int mid=(start+end)>>1;
            if(help[mid]>tar)
                end=mid;
            if(help[mid]<tar)
                start=mid+1;
            if(help[mid]==tar)
                return mid;
        }
        return start;
    }
}
