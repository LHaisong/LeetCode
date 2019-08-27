package com.prac.bytedance.listandtree;


public class MergeOrderList {
    static ListNode mergeHead=null;
    public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }
    public ListNode merge(ListNode l1,ListNode l2) throws Exception {
        if(l1==null&&l2!=null){
            return l2;
        }
        if(l1!=null&&l2==null){
            return l1;
        }
        if(l1==null&&l2==null){
            throw new Exception("输入的两个链表为null");
        }
        while (l1.next!=null&&l2.next!=null){
            if(l1.val>=l2.val){
                if(mergeHead==null){
                    mergeHead=l2;
                }
                mergeHead.next=l2;
                l2=l2.next;
            }else {
                if(mergeHead==null){
                    mergeHead=l1;
                }
                mergeHead.next=l1;
                l1=l1.next;
            }
        }
        while(l1.next!=null){
            mergeHead.next=l1;
            l1=l1.next;
        }
        while(l2.next!=null){
            mergeHead.next=l2;
            l2=l2.next;
        }
        return mergeHead;
    }
}
