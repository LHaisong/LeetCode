package com.prac.swordtooffer;

public class Offer_21MatrixBinarySearchTree {
    /**
     * 查找是否存在一颗二叉搜索树的
     * 后续遍历是给定的序列
     * @param arr
     * @param s
     * @param e
     * @return
     */
    static boolean judge(int[]arr,int s,int e){
        if(arr.length==0)
            return false;
        if(e<=s)
            return true;
        int root=arr[e];
        int i=s;
        for(;i<e;i++){
            if(arr[i]>root){
                break;
            }
        }
        for(int j=i;j<e;j++){
            if(arr[j]<root){
                return false;
            }
        }
        return judge(arr,0,i-1)&&judge(arr,i,e-1);
    }
    public static void main(String[]args){
        int[]arr={5,7,6,9,11,10,8};
        int[]matrix={7,4,6,5};
        int arrLen=matrix.length;
        if(judge(matrix,0,arrLen-1)){
            System.out.println("存在一个二叉搜索树的后续遍历是arr");
        }else {
            System.out.println("不存在一个二叉搜索树的后续遍历是arr");
        }
    }
}
