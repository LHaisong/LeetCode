package com.prac.swordtooffer;

import java.util.HashMap;

/**
 * 根据二叉树的前序遍历和中序遍历重建二叉树
 */
public class Offer_four {
	static TreeNode root;
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			this.val = x;
		}
	}

	/**
	 * 采用遍历数组的方式效率低
	 * @param pre 前序序列
	 * @param in 中序序列
	 * @return
	 * @throws Exception
	 */
//	public static TreeNode reConstructBinaryTree(int [] pre,int [] in) throws Exception {
//		if(pre==null||in==null){
//			return null;
//		}
//		if(pre.length!=in.length){
//			throw new Exception("illegal input");
//		}
//		TreeNode root=null;
//		for(int i=0;i<in.length;i++){
//			if(in[i]==pre[0]){
//				root=new TreeNode(pre[0]);
//				root.left=reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i)) ;
//				root.right=reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
//			}
//		}
//		return root;
//	}

	/**
	 * @param pre
	 * @param in
	 * @return
	 */
	public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < in.length; i++) {
			map.put(in[i], i);
		}
		return preInt(pre, 0, pre.length - 1, in, 0, in.length - 1, map);
	}

	/**
	 * @param pre 前序
	 * @param pi  起始位置
	 * @param pj  终止位置
	 * @param n  中序
	 * @param ni  起始位置
	 * @param nj  终止位置
	 * @param map
	 * @return
	 */
	private static TreeNode preInt(int[] pre, int pi, int pj, int[] n, int ni, int nj, HashMap<Integer, Integer> map) {
		if (pi > pj)
			return null;
		root = new TreeNode(pre[pi]);
		int index = map.get(pre[pi]);
		root.left = preInt(pre, pi + 1, pi + index - ni, n, ni, index - 1, map);
		root.right = preInt(pre,pi+index-ni+1,pj,n,index+1,nj,map);
		return root;
	}

	/**
	 * 非递归方式前序遍历
	 *
	 * @param node
	 * @throws Exception
	 */
	public static void preOrder(TreeNode node) {
		if(node==null){
			System.out.println("tree is empty!");
		}
		System.out.print(node.val+" ");
		preOrder(node.left);
		preOrder(node.right);
	}

	public static void main(String[] args) throws Exception {
		int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
		int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};

		reConstructBinaryTree(preOrder, inOrder);
		preOrder(root);
	}
}
