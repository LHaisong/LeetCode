package com.prac.swordtooffer;

import java.util.List;

/**
 * 在O（1）时间内删除节点
 */
public class Offer_13DeleteListNode {
	static Node head=null;
	static Node last=null;
	class Node{
		Node next;
		int val;
		public Node(int v){
			this.val=v;
		}
	}

	public static void main(String[]args){
		Offer_13DeleteListNode node=new Offer_13DeleteListNode();
		for(int i=0;i<8;i++){
			node.addNode(i);
		}
		node.printNode(head);
	}

	/**
	 * 第一种方法：简单易懂，但是复杂度高
	 * @param h
	 * @param dNode
	 * @return
	 */
	private static boolean deleteNode(Node h,Node dNode) {
		if(head==null||dNode==null){
			return false;
		}
		if(head==dNode&&head.next==null){
			head=null;
			return true;
		}
		Node preNode=h;
		Node temp=preNode.next;
		while (temp!=null){
			if(temp==dNode){
				Node nextNode=temp.next;
				temp=nextNode;
				temp.next=nextNode.next;
				return true;
			}
			temp=temp.next;
		}
		return false;
	}

	public void addNode(int ele){
		Node node=new Node(ele);
		if(head==null){
			head=node;
			last=head;
			return;
		}
		last.next=node;
		last=node;
	}
	public void printNode(Node head){
		Node temp=head;
		while (temp!=null){
			System.out.print(temp.val+" ");
			temp=temp.next;
		}
	}
}
