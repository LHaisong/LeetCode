package com.prac.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 求字符串中的最长回文子串
 * ababcd--->aba、bab
 */
public class LongestPalindrome {
    public static void main(String[]args){
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        try {
            String line=br.readLine();
            String ret=longestPalindrome(line);
            System.out.println(ret);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 本题可使用蛮力法求解，两层for循环，复杂度为O(n^2);
     * 使用动态规划求解
     * dp[i][j] 表示字符串从 j 到 i 是否是为回文串，即当 s[j] == s[i]
     * 如果 dp[i-1][j+1] 也是回文串，
     * 那么字符串从 j 到 i 也是回文串，即 dp[i][j] 为真。
     * @param line
     * @return
     */
    private static String longestPalindrome(String line) {
        int len=0,left=0,right=0;
        boolean[][]dp=new boolean[line.length()][line.length()];
        for(int i=0;i<line.length();i++){
            for(int j=i;j>=0;j--){
                if(line.charAt(i)==line.charAt(j)&&((i-j<2)||dp[i-1][j+1])){
                    dp[i][j]=true;
                }
                if(dp[i][j]&&(i-j+1)>len){
                    len=i-j+1;
                    right=i;
                    left=j;
                }
            }
        }
        return line.substring(left,right-left+1);
    }
}
