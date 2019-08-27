package com.prac.swordtooffer;

/**
 * 字符串的全排列，采用分治法求解
 */
public class Offer_25StringPerm {
    static int m=0;
    static void perm(String s){
        char[]chars=s.toCharArray();
        permRes(chars,0,chars.length-1);
    }

    private static void permRes(char[] chars, int sta, int end) {
        if(sta==end){
            for(int i=0;i<=end;i++){
                System.out.print(chars[i]);
            }
            System.out.println();
        }
        for(int k=sta;k<=end;k++){
            swap(chars,sta,k);
            System.out.println(sta+" "+k);
            permRes(chars,sta+1,end);
            swap(chars,sta,k);
        }
    }

    private static void swap(char[] chars, int sta, int k) {
        if(sta!=k) {
            char temp = chars[sta];
            chars[sta] = chars[k];
            chars[k] = temp;
        }
    }

    public static void main(String[]args){
        String str="abc";
        perm(str);
    }
}
