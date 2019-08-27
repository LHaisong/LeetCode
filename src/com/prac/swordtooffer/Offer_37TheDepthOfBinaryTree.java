package com.prac.swordtooffer;

/**
 * 求一颗二叉树的深度
 */
public class Offer_37TheDepthOfBinaryTree {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;
        }
    }

    /**
     * 运用递归的思想：
     * 如果root左子节点不为null，右子节点为null，则深度为左子树的深度+1
     * 如果root左子节点为null，右子节点不为null，则深度为右子树的深度+1
     * 如果左子节点右子节点都不为null，则为两者较大值+1
     * @param root
     * @return
     */
    public static int getDepth(TreeNode root){
        if(root==null){
            return -1;
        }
        int leftDepth=getDepth(root.left);
        int rightDepth=getDepth(root.right);
        return (leftDepth>rightDepth)?(leftDepth+1):(rightDepth+1);
    }
    /**
     * 延伸：判断一颗二叉树是不是平衡二叉树
     * 自顶向下遍历，会出现重复遍历
     * @return
     */
    public static boolean isBalance(TreeNode root){
        if(root==null){
            return true;
        }
        int leftDepth=getDepth(root.left);
        int rightDepth=getDepth(root.right);
        int x=leftDepth-rightDepth;
        if(x>-1||x<-1){
            return false;
        }
        return isBalance(root.left)&&isBalance(root.right);
    }
}
