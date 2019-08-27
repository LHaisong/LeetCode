package com.prac.swordtooffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出数组中出现1次的元素，其他都成对出现
 */
public class Offer_39FindTheTwiceNum {
    public static void main(String[]args){
        int[]arr={2,4,3,6,3,2,5,5};
        if(arr.length<=1){
            System.out.println("输入不符合规范........");
        }else {
            findNum(arr);
        }
    }
    private static void findNum(int[] arr) {
        if(arr.length<=1){
            System.out.println("数组长度小于等于1");
        }
        int tar=0;
        /**
         * 先将数组中数全部求异或运算
         * 最终的结果为数组中只出现一次的数字的异或运算
         */

        for(int i=0;i<arr.length;i++){
            tar^=arr[i];
        }
        //记录tar中从右数第一个出现1的位置  tar=0010
        int sym=findIndexOf1(tar);
        int num1=0,num2=0;
        for(int j=0;j<arr.length;j++){
            if(isBit1(arr[j],sym)){
                num1^=arr[j];
            }
            else{
                num2^=arr[j];
            }
        }
        System.out.println(num1+" "+num2);
    }
    //将整数转换为二进制保存到list中
    public static List<Integer> integerTobinary(int tar){
        int m;
        List<Integer> list=new ArrayList<>();
        while (tar!=0){
            m=tar/2;
            list.add(tar%2);
            tar=m;
        }
        return list;
    }
    //判断从右往左数第sym位是否为1
    public static boolean isBit1(int tar,int sym){
        return (tar>>(sym-1))==1;
    }
    public static int findIndexOf1(int num){
        int index=0;
        List<Integer> list=integerTobinary(num);
        for(int i=list.size()-1;i>0;i--){
            if(list.get(i)==1){
                break;
            }
            index++;
        }
        return index;
    }
}
