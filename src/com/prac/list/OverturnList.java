package com.prac.list;

public class OverturnList {
	static class ListNode{
		int val;
		ListNode next;
		public ListNode(int v){
			this.val=v;
			this.next=null;
		}
	}

	public ListNode solution(ListNode head){
		ListNode current=null;
		if(head==null){
			return null;
		}
		if(head.next==null){
			return head;
		}
		while(head!=null){
			ListNode temp=head.next;
			head.next=current;
			current=head;
			head=temp;
		}
		return current;
	}

	public static void main(String[]args){
		OverturnList overturnList=new OverturnList();
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(2);
		ListNode n3=new ListNode(3);
		n1.next=n2;
		n2.next=n3;
		ListNode node=overturnList.solution(n1);
		System.out.println(node.val);
	}
}
