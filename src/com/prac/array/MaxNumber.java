package com.prac.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 数组中元素组成的最大数
 */
public class MaxNumber {
    public static void main(String[]args){
        int[]arr={0,5,0};
        getMax(arr);
    }
    public static void getMax(int []arr){
        String[]strs=new String[arr.length];
        for(int i = 0; i <arr.length;i++){
            strs[i]=Integer.toString(arr[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) return s2.compareTo(s1);
                return (s2+s1).compareTo(s1+s2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<strs.length;i++){
            sb.append(strs[i]);
        }
        if(Integer.parseInt(sb.toString())==0){
            System.out.println(0);
        }else {
            System.out.println(sb.toString());
        }
    }
}
