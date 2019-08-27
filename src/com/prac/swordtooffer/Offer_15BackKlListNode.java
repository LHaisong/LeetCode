package com.prac.swordtooffer;

/**
 * 倒数第k个节点
 */
public class Offer_15BackKlListNode {

	static Node head=null;
	static Node last=null;
	static int size=0;
	static class Node{
		Node next=null;
		int val;
		public Node(int v){
			this.val=v;
		}
	}
	public static void addNode(int ele){
		Node node=new Node(ele);
		if(head==null){
			head=node;
			last=head;
			size++;
			return;
		}
		last.next=node;
		last=node;
		size++;
	}
	static Node deleteBackKNode(Node h,int k)throws Exception{
		Node first,end=h;
		/**
		 * 一定要注意临界条件的判断
		 */
		if(h==null||k==0){
			throw new Exception("参数错误！");
		}
		if(k>size){
			throw new Exception("k>size");
		}
		for(int i=0;i<k-1;i++){
			end=h.next;
		}
		first=h;
		while (end.next!=null){
			end=end.next;
			first=first.next;
		}
		return first;
	}
	public static void main(String[]args)throws Exception{
		addNode(2);
		addNode(9);
		addNode(5);
		addNode(3);
		addNode(4);
		addNode(7);
		int k=5;
		System.out.print(deleteBackKNode(head,k).val);
	}
}
