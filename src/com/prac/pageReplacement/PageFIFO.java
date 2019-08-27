package com.prac.pageReplacement;

import java.util.LinkedList;
import java.util.List;

/**
 * 页面置换算法
 * FIFO
 */
public class PageFIFO {
    //指向最先调入内存的页
    static int first=0;
    public static void main(String[] args) throws Exception{
        int[] arr = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1};
        implementFIFO(arr);
    }

    private static void implementFIFO(int[] arr) throws Exception{
        List<Integer> pageQueue = new LinkedList<>();
        //内存中最多能存在的页数
        int size = 3;
        //操作次数
        int addCount=0;
        for (int i = 0; i < arr.length; i++) {
            if (addCount<size) {
                pageQueue.add(arr[i]);
                addCount++;//123
            }else {
                List<Integer>temp=pageQueue;
                int k=0;
                while (k<size){
                    System.out.print(temp.get(k));
                    k++;
                }
                System.out.println();
                int j=i;
                if(j<arr.length&&!judgePageInQueue(pageQueue,arr[j])){
                    replacePage(pageQueue,arr[j]);
                }
            }
        }
    }

    /**
     * 页的替换操作
     * @param pageQueue
     * @param i
     * @throws Exception
     */
    private static void replacePage(List<Integer> pageQueue, int i) throws Exception {
        if(pageQueue.isEmpty()){
            throw new Exception("replace page is null");
        }
        if(first<pageQueue.size()) {
            pageQueue.remove(first);
            pageQueue.add(first,i);
            first++;
        }else {
            first=0;
            pageQueue.remove(first);
            pageQueue.add(i);
        }
    }

    /**
     * 判断下一个需要的页是否已经存在于内存中
     * @param pageQueue1
     * @param k
     * @return
     */
    private static boolean judgePageInQueue(List<Integer> pageQueue1, int k) {
        List<Integer> tempQueue = pageQueue1;
        for(int i=0;i<tempQueue.size();i++){
            int temp=tempQueue.get(i);
            if(temp==k){
                return true;
            }
        }
        return false;
    }
}

