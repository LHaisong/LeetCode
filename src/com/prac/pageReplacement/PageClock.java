package com.prac.pageReplacement;

import java.util.LinkedList;

/**
 * 页面置换算法中的
 * clock置换算法
 */
public class PageClock {
    static int size=3;
    public static void main(String[]args){
        int[] arr = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1};
        implementClock(arr);
    }
    private static void implementClock(int[] arr) {
        LinkedList<Integer> list = new LinkedList<>();
        //时钟标志数组
        int[]symArr=new int[size];
        for(int i=0;i<size;i++){
            symArr[i]=1;
        }
        for (int i = 0; i < arr.length; i++) {
            if(i<size) {
                list.add(arr[i]);
            }
            boolean isFind=false;
            int j=i;
            while (!isFind) {
                for(int k=0;k<list.size();k++) {
                    //如果要置换的页面存在数组中，则将标志位置为1
                    if(list.get(k)==arr[j]){
                        symArr[k]=1;
                        isFind=true;
                    }
                    //第一个标志位为0的页是要被置换的页
                    if (symArr[k] == 0) {
                        swap(list, k, arr[k]);
                        isFind = true;
                        symArr[k] = 1;
                    }
                    //没有找到要置换的页，则将标志位为1的页置0
                    if (symArr[k] == 1) {
                        symArr[k] = 0;
                    }
                    //重新遍历链表
                    if(k==size-1){
                        k=-1;
                    }
                }
            }
        }
    }
    private static void swap(LinkedList linkedList,int i, int j) {
        int temp=(Integer) linkedList.get(i);
        int tempVal=temp;
        temp=j;
        j=tempVal;
    }
}
