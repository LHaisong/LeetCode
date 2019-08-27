package com.prac.swordtooffer;

import java.util.Map;

public class Offer_38JudgeBalancedBinaryTree {
    static class Node{
        Node left;
        Node right;
        int val;
        public Node(int val){
            this.val=val;
        }
    }
    /**
     * 以后序遍历的方式自底向上遍历先求子树是否平衡
     * @param root
     * @return
     */
    static boolean isBalanced(Node root){
        if(root==null){
            return false;
        }
        return getDepth(root)!=-1;
    }
    /**
     * 获取二叉树中子树的深度
     * @param root
     * @return
     */
    public static int getDepth(Node root){
        if(root==null){
            return -1;
        }
        int left=getDepth(root.right);
        if(left==-1){
            return -1;
        }
        int right=getDepth(root.right);
        if(right==-1){
            return -1;
        }
        return Math.abs(left-right)>1?-1: Math.max(left,right)+1;
    }
}
