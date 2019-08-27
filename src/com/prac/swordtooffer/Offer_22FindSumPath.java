package com.prac.swordtooffer;

import com.prac.tree.BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

/**
 * 在一颗树中找到和为指定值的路径
 */
public class Offer_22FindSumPath {
    public Node root=null;
    //
    public int size;
    //
    public int[]data;
    /**
     * 结点类
     */
    class Node {
        //
        public int value;
        //
        public Node left;
        //
        public Node right;

        //
        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    /**
     * 建立已广义表的形式存储的二叉树
     * 遍历二叉树
     * @param exp
     * @return
     */
    public Node createTree(String exp) {
        Node[] nodes = new Node[3];
        Node b, p = null;
        int top = -1, k = 0, j = 0;
        char[] exps = exp.toCharArray();
        char data = exps[j];
        b = null;
        while (j < exps.length - 1) {
            switch (data) {
                case '(':
                    top++;
                    nodes[top] = p;
                    k = 1;
                    break;
                case ')':
                    top--;
                    break;
                case ',':
                    k = 2;
                    break;
                default:
                    p = new Node(data-'0');
                    if (root == null) {
                        root = p;
                    } else {
                        switch (k) {
                            case 1:
                                nodes[top].left=p;
                                break;
                            case 2:
                                nodes[top].right=p;
                                break;
                        }
                    }
            }
            j++;
            data = exps[j];
        }
        return root;
    }
    /**
     *前序遍历
     */
    public void preOrder(Node node){
        if(node!=null){
            System.out.print(node.value+" ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    /**
     * 二叉树的广度优先遍历
     * @param root
     * 辅助数据结构queen
     */
    public void LevelOrder(Node root) {
        ArrayDeque<Node> queen = new ArrayDeque<>();
        if (root == null) {
            System.out.println("Tree is empty!");
        }
        //加入根节点
        queen.add(root);
        while (!queen.isEmpty()) {
            Node node=queen.remove();
            System.out.print(node.value);
            if (node.left != null) {
                queen.add(node.left);
            }
            if (node.right != null) {
                queen.add(node.right);
            }
        }
    }
    // 全局变量，用于存储得到的每一个路径
    static ArrayList<ArrayList<Integer>> resultsList = new ArrayList<ArrayList<Integer>>();
    static ArrayList<ArrayList<Integer>> findPath(Node root,int sum){
        if(root==null){
            System.out.println("树为空");
        }
        if(root.value>sum){
            System.out.println("不存在此路径");
        }
        int cursum=0;
        int index=0;
        int[]pathTar=new int[1000];
        path(root,sum,cursum,pathTar,index);
        return resultsList;
    }
    static void path(Node root,int sum,int curSum,int[]path,int index){
        if(root==null){
            return;
        }
        curSum+=root.value;
        path[index]=root.value;
        index++;
        if(curSum==sum&&root.right==null&&root.left==null){
            ArrayList<Integer>list=new ArrayList<>();
            for(int i=0;i<index;i++){
                list.add(path[i]);
            }
            resultsList.add(list);
            return;
        }
        if(curSum<sum&&root.left!=null){
            path(root.left,sum,curSum,path,index);
        }
        if(curSum<sum&&root.right!=null){
            path(root.right,sum,curSum,path,index);
        }
    }
    public static void main(String[]args){
        String str="5(4(8(2,9),),3(7,6(1,)))";
        int sum=15;
        Offer_22FindSumPath bTree = new Offer_22FindSumPath();
        bTree.createTree(str);
        System.out.println("-----------递归前序遍历------------");
        bTree.LevelOrder(bTree.root);
        ArrayList<ArrayList<Integer>> list=findPath(bTree.root,sum);
        System.out.print(list);
    }
}
