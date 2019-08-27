package com.prac.swordtooffer;

import java.util.ArrayDeque;
import java.util.Queue;

public class Offer_19MirriorBinaryTree {
	static TreeNode root=null;
	static class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		public TreeNode(int val,TreeNode le,TreeNode ri){
			this.val=val;
			this.right=ri;
			this.left=le;
		}
	}
	static void addNode(int val){
		TreeNode node=new TreeNode(val,null,null);
		if(root==null){
			root=node;
		}
		TreeNode temp=root;
		while (true){
			if(temp.left!=null){
				temp=temp.right;
				if(temp==null){
					temp=node;
				}
			}else {
				temp.left=node;
				break;
			}
			temp=temp.left;
		}
	}
	/**
	 * 前序遍历树，如果遍历的节点存在子树，则求镜像
	 * @param treeNode 树的根节点
	 */
	static void mirriorBinaryTree(TreeNode treeNode){
		if(treeNode==null){
			return ;
		}
		TreeNode tempNode=treeNode;
		while (tempNode.left!=null||tempNode.right!=null) {
			TreeNode temp = tempNode.left;
			tempNode.left = tempNode.right;
			tempNode.right = temp;
			if (tempNode.left != null) {
				mirriorBinaryTree(tempNode.left);
			}
			if (tempNode.right != null) {
				mirriorBinaryTree(tempNode.right);
			}
		}
	}



	static void levelTrace(TreeNode node){
		Queue<TreeNode>queue=new ArrayDeque<>();
		if(node==null){
			return;
		}
		queue.add(node);
		while (!queue.isEmpty()){
			TreeNode temp= queue.remove();
			System.out.print(temp.val+" ");
			if (temp.left!=null){
				queue.add(temp.left);
			}
			if(temp.right!=null){
				queue.add(temp.right);
			}
		}
	}
	public static void main(String[]args){
		addNode(5);
		addNode(4);
		addNode(3);
		addNode(5);
		addNode(6);
		addNode(7);
		levelTrace(root);
		//mirriorBinaryTree(root);
	}
}
