package com.prac.swordtooffer;

/**
 * 将二叉搜索树转换为双向链表
 */
public class Offer_24BinarySearchTreeToQueue {
    TreeNode root=null;
    static class TreeNode{
        TreeNode left=null;
        TreeNode right=null;
        int val;
        TreeNode(int val){
            this.val=val;
        }
    }
    static TreeNode transfer(TreeNode root) throws Exception {
        if(root==null){
            throw new Exception("树为null");
        }
        if(root.left==null&&root.right==null){
            return root;
        }
        //将左子树转换为双向链表
        TreeNode left=transfer(root.left);
        TreeNode p=left;
        //获取左子树双向链表最后一个节点
        while (p!=null&&p.right!=null){
            p=p.right;
        }
        //左子树不为null的话讲root加到后面
        if(left!=null){
            p.right=root;
            root.left=p;
        }
        //将右子树构造为双向链表
        TreeNode right=transfer(root.right);
        if(right!=null){
            right.left=root;
            root.right=right;
        }
        return left!=null?left:root;
    }
    public static void main(String[]args)throws Exception{
        transfer(new Offer_24BinarySearchTreeToQueue().root);
    }
}
