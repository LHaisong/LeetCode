package com.prac.list;
public class ListNode {
    static ListNode head=null;
    static ListNode last=null;
    int val;
    ListNode next;
    public ListNode(int val){
        this.val=val;
    }
    public void addNode(int val) {
        ListNode listNode = new ListNode(val);
        if (head == null) {
            head = listNode;
            last = listNode;
            return;
        }
        last.next = listNode;
        last = listNode;
    }
}
