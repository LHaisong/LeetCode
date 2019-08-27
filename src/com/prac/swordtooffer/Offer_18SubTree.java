package com.prac.swordtooffer;

/**
 * 判断一颗树是不是另一棵树的子树
 */
public class Offer_18SubTree {
	static TreeNode root=null;
	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val){
			this.val=val;
		}
	}
	public static void addTreeNode(int val){
		TreeNode node=new TreeNode(val);
		if(root==null){
			root=node;
		}
		TreeNode temp=root;
		if(temp.left==null){
			temp.left=node;
		}
		if(temp.right==null){
			temp.right=node;
		}
	}
	static boolean judgeSubTree(TreeNode mainRoot,TreeNode subRoot){
		boolean result=false;
		if(mainRoot==null){
			return false;
		}
		if(subRoot==null){
			return true;
		}
		if(mainRoot.val!=subRoot.val){
			return false;
		}
		while (mainRoot.left!=null||mainRoot.right!=null){
			if(mainRoot.val==subRoot.val){
				result=judgeSubTree(mainRoot.left,subRoot.left)&&judgeSubTree(mainRoot.right,subRoot.right);
			}
			if(!result){
				result=judgeSubTree(mainRoot.left,subRoot);
			}
			if(!result){
				result =judgeSubTree(mainRoot.right,subRoot);
			}
			return result;
		}
		return result;
	}
	public static void main(String[]args){
		addTreeNode(8);
		addTreeNode(8);
		addTreeNode(4);
		addTreeNode(9);
		addTreeNode(2);
		addTreeNode(3);

	}
}
