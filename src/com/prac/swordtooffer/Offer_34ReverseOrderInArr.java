package com.prac.swordtooffer;

/**
 * 求一个数组中逆序对的总数
 */
public class Offer_34ReverseOrderInArr {
    public static void main(String[]args)throws Exception{
        int[]arr={2,7,4,6,9,8,5};//74 76 75 65 98 95 85
        countReverseOrder(arr);
        System.out.println(inReversePairs(arr));
    }

    /**
     * 蛮力法，两次遍历复杂度O(n^2)
     * @param arr
     */
    private static void countReverseOrder(int[] arr) throws Exception {
        if(arr.length==0){
            throw new Exception("数组为null....");
        }
        int sum=0;
        for(int i=0;i<arr.length-1;i++){
            int j=i+1;
            for(;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }
    /**
     * 采用递归求解O(nlogn),归并排序的思想
     */
    public static int inReversePairs(int[]arr){
        if(arr.length<=1||arr==null){
            return -1;
        }
        int[]copy=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            copy[i]=arr[i];
        }
        int count=inReversePairsCore(arr,copy,0,arr.length);
        return count;
    }

    private static int inReversePairsCore(int[] arr, int[] copy, int low, int high) {
        if(low==high)
            return 0;
        int mid=(low+high)>>1;
        int leftCount=inReversePairsCore(arr,copy,low,mid);
        int rightCount=inReversePairsCore(arr,copy,mid+1,high);
        int i=mid,j=high,count=0,copyIndex=high;
        while (i>=low&&j>=mid)
        {
            if(arr[i]>arr[j])
            {
                count=count+j-mid;
                copy[copyIndex--]=arr[i--];
            }else {
                copy[copyIndex--]=arr[j--];
            }
        }
        //左边有冗余
        for(;i>=low;i--)
        {
            copy[copyIndex--]=arr[i];
        }
        //右边有冗余
        for (;j>mid;j--)
        {
            copy[copyIndex--]=arr[j];
        }
        for(int s=low;s<=high;s++)
        {
            arr[s]=copy[s];
        }
        return (leftCount+rightCount+count);
    }
}
