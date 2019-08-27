package com.prac.list;

public class MergeOrderedList {
	static class ListNode{
		ListNode next;
		int val;
		public ListNode(int val){
			this.val=val;
			this.next=null;
		}
	}

	public static ListNode merge(ListNode head1,ListNode head2){
		ListNode temp=null;
		while (head1!=null) {
			if(head2==null){
				return head1;
			} else {
				if(head1.val<head2.val&&head1.next!=null){
					temp=head1;
					head1=head1.next;
				}else if(head1.val>head2.val&&head2.next!=null) {
					temp=head2;
					head2=head2.next;
				}
			}
		}
		return temp;
	}

	public static void main(String[]args){
		ListNode node1_1=new ListNode(1);
		ListNode node1_2=new ListNode(3);
		ListNode node1_3=new ListNode(5);
		ListNode node2_1=new ListNode(2);
		ListNode node2_2=new ListNode(4);
		ListNode node2_3=new ListNode(6);
		node1_1.next=node1_2;
		node1_2.next=node1_3;
		node2_1.next=node2_2;
		node2_2.next=node2_3;
	}
}
