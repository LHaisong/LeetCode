package com.prac.swordtooffer;

import java.util.Arrays;

/**
 * 扑克牌中的顺子
 */
public class Offer_42PlayingCardsOrder {
    public static void main(String[]args)throws Exception{
        int[]arr=new int[5];
        judgeOrder(arr);
    }

    private static boolean judgeOrder(int[] arr) throws Exception{
        if(arr.length!=5){
            throw new Exception("牌的数量不是5......");
        }
        int numberOfZero=0;
        int numberOfGap=0;
        Arrays.sort(arr);
        for(int i=0;i<arr.length-1;i++){
            int j=i+1;
            if(arr[i]==0){
                numberOfZero++;
            }
            if(arr[j]-arr[i]>1){
                numberOfGap=arr[j]-arr[i]-1;
            }
        }
        if(numberOfGap>numberOfZero){
            return false;
        }
        return true;
    }
}
