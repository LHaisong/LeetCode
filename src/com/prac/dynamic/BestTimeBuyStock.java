package com.prac.dynamic;

/**
 * 买股票的最佳时机
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 */
public class BestTimeBuyStock {
    public static void main(String[]args){
        int[]arr={7,1,5,3,6,4};
        int[]a={7,6,4,3,1};
        try {
            bestTimeBuyStock0(a);
            bestTimeBuyStock1(arr);
            bestTimeBuyStock2(arr);
            bestTimeBuyStock3(arr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 采用蛮力法，求数组中顺序差最大的一组数
     * 复杂度O(n^2)
     * @param arr
     */
    private static void bestTimeBuyStock0(int[] arr) throws Exception {
        if(arr.length<1){
            throw new Exception("数组长度不能小于1");
        }
        int m=-1,n=-1,max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]-arr[j]<0){
                    if(arr[j]-arr[i]>max){
                        max=arr[j]-arr[i];
                        m=i;n=j;
                    }
                }
            }
        }
        if(m!=-1) {
            System.out.println("第" + (m + 1) + "天买入" + "\n第" + (n + 1) + "天卖出\n" +
                    "最大利润为:" + (arr[n] - arr[m]));
        }else {
            System.out.println("不能完成交易,利润为0");
        }
    }
    /**
     * 使用动态规划求解
     */
    private static void bestTimeBuyStock1(int[] arr) throws Exception {
        if(arr.length<1){
            throw new Exception("数组长度不能小于1");
        }
        int profit=0,min=arr[0];//7,1,5,3,6,4
        for(int i=0;i<arr.length;i++){
            min=Math.min(min,arr[i]);
            profit=Math.max(profit,arr[i]-min);
        }
        System.out.println(profit);
    }
    private static void bestTimeBuyStock2(int[] arr) throws Exception {
        if (arr.length < 1) {
            throw new Exception("数组长度不能小于1");
        }
        int[]dp=new int[arr.length+1];
        int min=Integer.MAX_VALUE;
        dp[0]=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min)
                min=arr[i];
            dp[i+1]=Math.max(dp[i],arr[i]-min);
        }
        System.out.println(dp[dp.length-1]);
    }
    /**
     * 如果可以多次买卖股票，设计一个算法求解最大的利润值
     * 在买之前需要将前一次买的股票卖掉
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     * 使用贪心算法，求局部最优解
     */
    private static void bestTimeBuyStock3(int[] arr) throws Exception {
        if (arr.length < 1) {
            throw new Exception("数组长度不能小于1");
        }
        int profit=0,temp;
        for(int i=1;i<arr.length;i++){
            temp=arr[i]-arr[i-1];
            if(temp>0)
                profit+=temp;
        }
        System.out.println(profit);
    }
}
