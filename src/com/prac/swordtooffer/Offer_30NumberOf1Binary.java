package com.prac.swordtooffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 求一个数的二进制中1的个数
 */
public class Offer_30NumberOf1Binary {
    public static void main(String[]args){
        int n=Integer.MAX_VALUE;
        long startTime1=System.nanoTime();
        System.out.println(CountNum1(n));
        long endTime1=System.nanoTime();
        System.out.println(endTime1-startTime1);
        long startTime2=System.nanoTime();
        System.out.println(countNum1(n));
        long endTime2=System.nanoTime();
        System.out.println(endTime2-startTime2);
    }
//第一种方法
    private static int CountNum1(int n) {
        int sum=0;
        while (n!=0){
            sum++;
            n=(n-1)&n;
        }
        return sum;
    }
//第二种方法O(n)
    public static int countNum1(int n){
        int m;
        int sum=0;
        List<Integer>list=new ArrayList<>();
        while (n!=0){
            m=n/2;
            list.add(n%2);
            n=m;
        }
        for(int i=0;i<list.size();i++){
            if(list.get(i)==1){
                sum++;
            }
        }
        return sum;
    }
}
