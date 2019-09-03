package com.prac.list;
public class ListNode {
    static ListNode head=null;
    static ListNode last=null;
    int val;
    ListNode next;
    public ListNode(int val){
        this.val=val;
        next = null;
    }
}
