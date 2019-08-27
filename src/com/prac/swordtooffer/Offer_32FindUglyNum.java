package com.prac.swordtooffer;

public class Offer_32FindUglyNum {
    public static void main(String[]args){
        int n=32;
        //返回第n个丑数，只包含2 3 5这三个因子
        //findUglyNum(n);
        System.out.println("第"+n+"个丑数："+findUglyNum2(n));
    }
    //蛮力法
    private static void findUglyNum(int count) {
        int c=1;
        int num=2;
        while (c<count){
            if(isUgly(num)){
                c++;
            }else {
                num++;
            }
        }
        System.out.println(num);
    }
    public static boolean isUgly(int n){
        while (n % 2 == 2) {
            n /= 2;
        }
        while (n % 3 == 3) {
            n /= 3;
        }
        while (n % 5 == 5) {
            n /= 5;
        }
        return (n==1) ? true : false;
    }
    /**
     * 以空间换时间的解法
     */
    public static int findUglyNum2(int index){
        if(index<0){
            return -1;
        }
        int[]ugly=new int[index];
        ugly[0]=1;
        int t2=0,t3=0,t5=0;
        for(int i=1;i<index;i++){
            ugly[i]=getMin(ugly[t2]*2,ugly[t3]*3,ugly[t5]*5);
            if(ugly[i]==ugly[t2]*2)
                t2++;
            if(ugly[i]==ugly[t3]*3)
                t3++;
            if(ugly[i]==ugly[t5]*5)
                t5++;
        }
        return ugly[index-1];
    }

    private static int getMin(int i, int j, int k) {
        int res=Math.min(i,j);
        res=Math.min(res,k);
        return res;
    }
}
