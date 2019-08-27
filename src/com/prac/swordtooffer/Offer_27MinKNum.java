package com.prac.swordtooffer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 寻找数组中最小的K个数
 */
public class Offer_27MinKNum {
    public static void main(String[]args)throws Exception{
        int []arr={2,1,5,4,8,17,9,6,3,11,7};
        int k=5;
        //findMinKNum(arr,k);
        getMinKNum(arr,k);
        getMaxKNum(arr,k);
    }

    /**
     * 使用优先级队列实现查找最大的k个元素
     * @param arr
     * @param k
     */
    private static void getMaxKNum(int[] arr, int k) {
        PriorityQueue<Integer>minHeap=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            if(minHeap.size()!=k){
                minHeap.offer(arr[i]);
            }else if(minHeap.peek()<arr[i]) {
                minHeap.poll();
                minHeap.offer(arr[i]);
            }
        }
        for(Integer num:minHeap){
            System.out.print(num+" ");
        }
    }
    /**
     * 采用优先级队列的方法PriorityQueue
     * 优先级队列是使用小顶堆实现的，可对其进行转换变成大顶堆
     */
    private static void getMinKNum(int[] arr, int k){
        if(arr.length<k||k<=0){
            return ;
        }
        PriorityQueue<Integer>maxHeap=new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            //做一个简单的调整，将默认的小顶堆转换为大顶堆
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for(int i=0;i<arr.length;i++){
            if(maxHeap.size()!=k){
                maxHeap.offer(arr[i]);
            }else if(maxHeap.peek()>arr[i]){
                maxHeap.poll();
                maxHeap.offer(arr[i]);
            }
        }
        for(Integer num:maxHeap){
            System.out.print(num+" ");
        }
        System.out.println();
    }
    /**
     * 使用优先级队列查找最大的K个元素
     */

    /**
     * 采用快速排序的方法
     * @param arr
     * @param k
     * @throws Exception
     */
    private static void findMinKNum(int[] arr,int k) throws Exception {
        if(arr.length<k){
            throw new Exception("数组长度小于k，请重新输入.....");
        }
        int start=0;
        int end=arr.length-1;
        int len=arr.length;
        int index=partition(arr,len,start,end);
        while (index!=k-1){
            if(index>k-1){
                end=index-1;
                index=partition(arr,len,start,end);
            }
            else {
                start=index+1;
                index=partition(arr,len,start,end);
            }
        }
        for(int i=0;i<k;i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static int partition(int[] arr, int len, int start, int end) {
        int index=RandomInRange(start,end);
        while (start<end){
            if(arr[end]<=arr[index]){//543
                if(arr[start]>arr[index]) {
                    swap(arr,start,end);
                    start++;
                }
            }
            end--;
        }
        return index;
    }

    private static void swap(int[] arr, int start, int index) {
        int temp=arr[index];
        arr[index]=arr[start];
        arr[start]=temp;
    }

    private static int RandomInRange(int start, int end) {
        Random random=new Random();
        start=start-1;
        return random.nextInt(end-start+1)+start;
    }
}
