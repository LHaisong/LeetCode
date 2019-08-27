package com.prac.dynamic;

/**
 * LeetCode.62
 * 不同的路径
 */
public class UniquePaths {
    public static void main(String[] args) {
        int m = 3, n = 7;
        int[][]tra=new int[m][n];
        int ret = uniquePaths(m, n);
        int res=uniquePath(tra,m-1,n-1);
        System.out.println(res+" "+ret);
    }

    private static int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    private static int uniquePath(int[][]tra,int m, int n) {
        if(m<0||n<0){
            return 0;
        }
        if (m == 0 || n == 0) {
            return 1;
        }
        int ret=0;
        tra[m][n]+=1;
        if((m>=1&&n>=1)&&tra[m][n]<=1) {
            ret += uniquePath(tra,m, n - 1) + uniquePath(tra,m - 1, n) + 2;
        }
        return ret;
    }
}
