package com.prac.swordtooffer;

import com.prac.bytedance.listandtree.ReverseList;

/**
 * 链表反转
 */
public class Offer_16ReverseNode {

	static Node head;
	static Node last;

	static class Node {
		int val;
		Node next = null;

		public Node(int v) {
			this.val = v;
		}
	}

	public static void addNode(int ele) {
		Node node = new Node(ele);
		if (head == null) {
			head = node;
			last = head;
			return;
		}
		last.next = node;
		last = node;
	}

	static Node reverse(Node head) {
		if (head == null) {
			return null;
		}
		Node curNode = head;
		Node reverseNode = null;
		Node preNode = null;
		Node temp=null;
		while (curNode != null) {
			temp=curNode.next;//先把未翻转前的下一节点取出来
			curNode.next=preNode;//从head节点开始反转后当前节点的前一个节点(翻转后头结点的下一个节点为空)
			if (temp == null) {
				reverseNode = curNode;//当前反转节点
			}
			preNode=curNode;
		    curNode=temp;
		}
		return reverseNode;
	}

	/**
	 * 递归的方式
	 * @param head
	 * @return
	 */
	public static Node Reverse(Node head){
		if(head==null||head.next==null){
			return head;
		}
		Node newHead=Reverse(head.next);
		head.next.next=head;
		head.next=null;
		return newHead;
	}
	public static void main(String[]args){
		addNode(2);
		addNode(9);
		addNode(5);
		addNode(3);
		addNode(4);
		addNode(7);
//		Node node=reverse(head);
//		while (node!=null){
//			System.out.print(node.val+" ");
//			node=node.next;
//		}
//		System.out.println();
		Node newHead=Reverse(head);
		while (newHead!=null){
			System.out.print(newHead.val+" ");
			newHead=newHead.next;
		}
	}
}
