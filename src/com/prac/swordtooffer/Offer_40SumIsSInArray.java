package com.prac.swordtooffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输出数组中和为sum的两个数字
 */
public class Offer_40SumIsSInArray {
    public static void main(String[]args)throws Exception{
        int[]arr={1,3,4,5,7,11,12,15,16,18,19,24,26,27};
        int sum=30;
        int sta=0,end=arr.length-1;
        long startTime1=System.nanoTime();
        findNum(arr,sta,end,sum);
        long endTime1=System.nanoTime();
        System.out.println((endTime1-startTime1)+"ns");
        long startTime2=System.nanoTime();
        findElements(arr,sum);
        long endTime2=System.nanoTime();
        System.out.println((endTime2-startTime2)+"ns");
    }
    //先指定一个数，然后遍历,复杂度O(n^2)
    private static void findElements(int[] arr, int sum) throws Exception {
        if(arr.length<=1){
            throw new Exception("数组长度小于等于1....");
        }
        boolean end=true;
        for(int i=0;i<arr.length-1&&end;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]+arr[j]==sum){
                    System.out.println(arr[i]+" "+arr[j]);
                    end=false;
                    break;
                }
            }
        }
    }
    /**
     * 从数组的头start和尾end一起向中间靠拢
     * 如果start+end=tar out
     * 如果start+end<tar start=start+1
     * 如果start+end>tar end=end-1
     */
    public static void findNum(int[]arr,int sta,int end,int tar) throws Exception {
        if(arr.length<=1){
            throw new Exception("数组长度小于等于1....");
        }
//        if(sta>=end){
//            return;
//        }
//        if(arr[sta]+arr[end]==tar){
//            System.out.println(arr[sta]+" "+arr[end]);
//        }
//        if(arr[sta]+arr[end]>tar){
//            end--;
//            findNum(arr,sta,end,tar);
//        }
//        if(arr[sta]+arr[end]<tar) {
//            sta++;
//            findNum(arr,sta,end,tar);
//        }
        //使用循环实现
        while (sta<end){
            int curSum=arr[sta]+arr[end];
            if(curSum==tar){
                System.out.println(arr[sta]+" "+arr[end]);
                break;
            }
            if(curSum<tar)
                sta++;
            if(curSum>tar)
                end--;
        }
    }
    /**
     * 打印一个和为tar的连续序列
     * 输入15
     * 输出：12345 456 78
     */
    public static void findSequence(int[]arr,int tar){
        int sta=0,end=1,mid=(tar+1)>>1;
        List<Integer>resList=new ArrayList<>();
        int curSum=0;
        resList.add(sta);
        while (sta<mid){
            curSum=curSum+arr[sta]+arr[end];
            resList.add(end);
            if(curSum==tar){
                printResList(resList);
                resList=null;
            }
            while (curSum>tar&&sta<mid){
                curSum-=arr[sta];
                resList=removeList(resList,sta);
                sta++;
                if(curSum==tar) {
                    printResList(resList);
                }
            }
            end++;
        }
    }

    private static List removeList(List<Integer> resList, int sta) {
        resList.remove(sta);
        return resList;
    }

    private static void printResList(List<Integer> resList) {
        for(int i=0;i<resList.size();i++){
            System.out.print(resList.get(i)+" ");
        }
        System.out.println();
    }
}
