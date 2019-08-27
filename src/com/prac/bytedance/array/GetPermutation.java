package com.prac.bytedance.array;


import java.util.ArrayList;
import java.util.List;

/**
 * 求n个数的全排列，按大小排序返回第k个排列
 * 先求全排列，返回第k个数
 */
public class GetPermutation {
    public static void main(String[]args){
        int n=4,k=9;
        getPermutation(n,k);
    }

    private static void getPermutation(int n, int k) {
        int []arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=i+1;
        }
        getKthPerm(arr,0,n-1,k);
//        int[]resArr=res.get(k-1);
//        for(int i=0;i<n;i++){
//            System.out.print(resArr[i]);
//        }
        System.out.println(res.get(k-1));
    }
    static List<String>res=new ArrayList<>();
    static StringBuffer sb=new StringBuffer();
    private static void getKthPerm(int[] arr,int l,int r,int k) {
        if(l==r) {
            for(int j=0;j<arr.length;j++) {
                sb.append(arr[j]);
            }
//            System.out.println();
            res.add(sb.toString());
            sb.setLength(0);
        }
        else{
            for(int i=l;i<=r;i++) {
                swap(arr,l,i);//0 0
                getKthPerm(arr,l+1,r,k);//
                swap(arr,l,i);//0
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
