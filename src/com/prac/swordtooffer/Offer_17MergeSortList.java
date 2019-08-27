package com.prac.swordtooffer;


public class Offer_17MergeSortList {

	static Node head=null;
	static Node last=null;
	static Node mergeHead=null;
	static class Node{
		int val;
		Node next;
		public Node(int val){
			this.val=val;
		}
	}
	public void addNode(int val){
		Node node=new Node(val);
		if(head==null){
			head=node;
			last=node;
			return ;
		}
		last.next=node;
		last=node;
	}

	/**
	 * 合并两个有序链表
	 * mergeHead合并后的头结点
	 * @param h1 链表头结点
	 * @param h2 链表头结点
	 * @return
	 * @throws Exception 两个链表都为null时报异常
	 */
	public static Node mergeList(Node h1,Node h2) throws Exception {
		Node p1Node=h1;
		Node p2Node=h2;
		if(p1Node==null&&p2Node==null){
			throw new Exception("两个链表都为null!");
		}
		if(p1Node==null){
			return p2Node;
		}
		if(p2Node==null){
			return p1Node;
		}
		while (p1Node.next!=null&&p2Node.next!=null){
			if(p1Node.val>p2Node.val){
				if(mergeHead==null){
					mergeHead=p2Node;
				}
				mergeHead.next=p2Node;
				p2Node=p2Node.next;
			}
			if(mergeHead==null){
				mergeHead=p2Node;
			}
			mergeHead.next=p1Node;
			p1Node=p1Node.next;
		}
		while (p1Node.next!=null){
			mergeHead.next=p1Node;
			p1Node=p1Node.next;
		}
		while (p2Node.next!=null){
			mergeHead.next=p2Node;
			p2Node=p2Node.next;
		}
		return mergeHead;
	}

	/**
	 * 递归版本
	 * @param h1
	 * @param h2
	 * @return
	 * @throws Exception
	 */
	static Node recmergeList(Node h1,Node h2) throws Exception {
		Node p1Node=h1;
		Node p2Node=h2;
		if(p1Node==null&&p2Node==null){
			throw new Exception("两个链表都为null!");
		}
		if(p1Node==null){
			return p2Node;
		}
		if(p2Node==null){
			return p1Node;
		}
		if(p1Node.val<p2Node.val){
			mergeHead.next=recmergeList(p1Node.next,p2Node);
			return mergeHead;
		}
		else {
			mergeHead.next=recmergeList(p1Node,p2Node.next);
			return mergeHead;
		}
	}
	public static void main(String[]args)throws Exception{
		Offer_17MergeSortList of1=new Offer_17MergeSortList();
		Offer_17MergeSortList of2=new Offer_17MergeSortList();
		of1.addNode(2);
		of1.addNode(4);
		of1.addNode(6);
		of2.addNode(1);
		of2.addNode(3);
		of2.addNode(5);
		//System.out.print(mergeList(head1,head2));
	}
}
