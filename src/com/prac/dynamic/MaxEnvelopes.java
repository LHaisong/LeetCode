package com.prac.dynamic;

import java.util.Arrays;

/**
 * 俄罗斯套娃信封问题
 */
public class MaxEnvelopes {
    public static void main(String[]args){
        int[][]envelopes={{3,4},{6,5},{6,7},{2,3},{5,4},{7,8},{10,9},{8,9}};//[6 7][6 4][5 4][2 3]
        int ret=maxEnvelopes(envelopes);
        System.out.println(ret);
    }

    /**
     * O(n^2)做法
     * @param envelopes
     * @return
     */
    private static int maxEnvelope(int[][] envelopes) {
        if(envelopes==null||envelopes.length==0){
            return 0;
        }
        int n=envelopes.length,max=1;
        int[]dp=new int[n+1];
        Arrays.fill(dp,1);
        Arrays.sort(envelopes,(a,b)->(a[0]-b[0]));
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(envelopes[i][0]>envelopes[j][0]&&envelopes[i][1]>envelopes[j][1]){
                    dp[i]=Math.max(dp[i],dp[i]+1);
                }
                max=Math.max(dp[i],max);
            }
        }
        return max;
    }

    /**
     * O(nlogn)
     * @param envelopes
     * @return
     */
    public static int maxEnvelopes(int[][]envelopes){
        if(envelopes==null||envelopes.length==0){
            return 0;
        }
        int n=envelopes.length,max=1;
        int[]dp=new int[n+1];
        Arrays.sort(envelopes,(a,b)->(a[0]==b[0]?b[1]-a[1]:a[0]-b[0]));
        for(int i=0;i<envelopes.length;i++){
            for(int j=0;j<envelopes[0].length;j++){
                System.out.print(envelopes[i][j]+" ");
            }
            System.out.println();
        }
        return 0;
    }
}
