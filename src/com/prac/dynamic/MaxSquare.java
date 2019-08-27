package com.prac.dynamic;

/**
 * 求最大正方形面积
 */
public class MaxSquare {
    public static void main(String[]args){
        int[][]arr={{1,1,1,1,0},
                    {0,1,1,1,1},
                    {1,1,1,1,1},
                    {1,1,1,0,1}};
        try {
            int ret=maxSquare(arr);
            System.out.println(ret);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用动态规划求解
     * 构造一个新的矩阵dp，dp[i][j]表示以点(i, j)为右下角的正方形的边长；状态转移方程：
     *
     * dp[i][j] = min(dp[i-1][j-1], min(dp[i-1][j], dp[i][j-1])) + 1;
     */
    private static int maxSquare(int[][] arr) throws Exception {
        int m=arr.length,n=arr[0].length;
        if(m==0||n==0)
            throw new Exception("不合法输入");
        int[][]dp=new int[m+1][n+1];
        int max=0;
        for(int i=1;i<m;i++){//1 2 3
            for(int j=1;j<n;j++){//1 2 3
                if(arr[i-1][j-1]==1){
                    dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                    max=Math.max(max,dp[i][j]);
                }
            }
        }
        return max*max;
    }
}
