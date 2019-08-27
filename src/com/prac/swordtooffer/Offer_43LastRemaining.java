package com.prac.swordtooffer;


/**
 * 0...n-1个数字按序排成一圈，
 * 每次删除第m个数字求出剩下的最后一个数字
 */
public class Offer_43LastRemaining {

    public static void main(String[]args) {
        int n = 5, m = 2;
        //lastRemaining(arr, n, m);
        System.out.println(lastRemaining(n,m));
    }
    private static int lastRemaining(int n,int m){
        if(n<1||m<1){
            return -1;
        }
        int last=0;
        for(int i=2;i<=n;i++){
            last=(last+m)%i;
        }
        return last;
    }
    private static void lastRemaining(int[]arr,int n, int m) {
        int step=0,count=n;
        int i=-1;
        while (count>0){
            i++;
            if(i==n-1) i=0;
            if(arr[i]==-1) continue;
            step++;
            if(step==m){
                arr[i]=-1;
                step=0;
                count--;
            }
        }
        System.out.println(arr[i]);
    }
}
