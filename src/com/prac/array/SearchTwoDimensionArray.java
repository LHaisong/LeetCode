package com.prac.array;

public class SearchTwoDimensionArray {
    public static void main(String[] args) throws Exception {
        int[][] arr = {
                {1,  4,  7,  11, 15},
                {2,  5,  8,  12, 19},
                {3,  6,  9,  16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int tar=35;
        searchResult(arr,tar);
    }

    /**
     * 使用二分法查找，从右上角开始
     * 当前数字大于tar时左移，小于时右移
     * @param arr
     * @param tar
     */
    private static void searchResult(int[][] arr, int tar) throws Exception {
        if(arr==null||arr.length ==0){
            throw new Exception("输入参数错误");
        }
        int rLen=arr.length,cLen=arr[0].length;
        int x=0,y=cLen-1;
        while (x<rLen&&y>=0){
            if(arr[x][y]==tar){
                System.out.println(tar + " x:"+x+" y:"+y);
                return;
            }
            if(arr [x] [y]>tar){
                y--;
            }else {
                x++;
            }
        }
        System.out.println(tar + "不存在");
    }
}
