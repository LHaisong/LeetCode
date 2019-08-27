package com.prac.swordtooffer;

/**
 * 数字在排序数字中出现的次数
 */
public class Offer_36NumInOrderedArr {
    public static void main(String[]args){
        int[]arr={1,2,3,3,3,3,4,5,6};
        int num=3;
        count1(arr,num);
        //count2(arr,num);
        count3(arr,num);
    }

    /**
     * 蛮力法求解
     * @param arr
     * @param n
     */
    private static void count1(int[] arr,int n) {
        if(arr.length==0){
            System.out.println("数组长度为0，重新输入...");
        }
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==n){
                count++;
                int j=i+1;
                for(;j<arr.length;j++){
                    if(arr[j]==n){
                        count++;
                    }else {
                        break;
                    }
                }
                i=j;
            }
        }
        System.out.println(count);
    }

    /**
     *使用二分查找先找到第一个n，然后与中间的数字做比较，
     * 确定最后一个k在前半段还是后半段
     * @param arr
     */
    private static void count2(int[] arr,int n) {
        if(arr.length==0){
            System.out.println("数组长度为0，重新输入.....");
        }
        int first= findFisrstNum(arr,0,arr.length-1,n);
        int last=findLastNum(arr,0,arr.length-1,n);
        if(first>-1&&last>-1)
            System.out.println((last-first+1));
    }
    //找到第一个n
    public static int findFisrstNum(int[]arr, int sta, int end, int n){
        if(sta>end){
            return -1;
        }
        int midIndex=(sta+end)>>1;
        int midData=arr[midIndex];
        if(midData==n){
            if(midIndex>0&&arr[midIndex-1]!=n||midIndex==0){
                return midIndex;
            }else {
                end=midIndex-1;
            }
        }
        if(midData>n){
            end=midIndex-1;
        }
        if(midData<n){
            sta=midIndex+1;
        }
        return findFisrstNum(arr,sta,end,n);
    }
    //找到数组中的最后一个n
    public static int findLastNum(int[]arr,int sta,int end,int n){
        if(sta>end){
            return -1;
        }
        int midIndex=(sta+end)>>1;
        int midData=arr[midIndex];
        if(midData==n){
            if(midIndex<arr.length-1&&arr[midIndex+1]!=n||midIndex==arr.length-1){
                return midIndex;
            }else {
                sta=midIndex+1;
            }
        }
        if(midData>n){
            end=midIndex-1;
        }
        if(midData<n){
            sta=midIndex+1;
        }
        return findFisrstNum(arr,sta,end,n);
    }

    /**
     * 数组中的数字都是整数，可以将查找在[target-0.5,target+0.5]之间数字的个数
     */
    public static void count3(int[]arr,int n){
        int sum=getNum(arr,n-0.5)-getNum(arr,n+0.5);
        System.out.println(sum);
    }

    private static int getNum(int[] arr, double tar) {
        int sta=0,end=arr.length-1;
        while (sta<=end){
            int mid=(end-sta)>>1;
            if(arr[mid]<tar){
                sta=mid+1;
            }
            if(arr[mid]>tar){
                end=mid-1;
            }
        }
        return sta;
    }
}
