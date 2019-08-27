package com.prac.bytedance.listandtree;

public class ReverseList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 递归的方式
     * @param head
     * @return
     */
    public ListNode Reverse(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode newHead=Reverse(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }
    public ListNode reverse(ListNode head){
       if(head==null){
           return null;
       }
       ListNode newHead=null;
       ListNode temp=null;
       while (head!=null){
           temp=head.next;
           head.next=newHead;
           newHead=head;
           head=temp;
       }
       return newHead;
    }
}
