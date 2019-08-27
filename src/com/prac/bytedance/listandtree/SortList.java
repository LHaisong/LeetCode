package com.prac.bytedance.listandtree;


import com.prac.swordtooffer.Offer_17MergeSortList;

/**
 * 对链表进行排序
 */
public class SortList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static void main(String[]args){
        Offer_17MergeSortList of1=new Offer_17MergeSortList();
        of1.addNode(1);
        of1.addNode(5);
        of1.addNode(6);
        of1.addNode(3);
        of1.addNode(2);
        of1.addNode(4);
    }

    /**
     * 使用归并排序
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode pre=head,mid=head,tail=head;
        while (tail!=null||tail.next!=null){
            pre=mid;
            mid=mid.next;
            tail=tail.next.next;
        }
        pre.next=null;
        return merge(sortList(head),sortList(mid));
    }

    private static ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummy=new ListNode(-1);
        ListNode cur=dummy;
        while (h1!=null&&h2!=null){
            if(h1.val<h2.val){
                cur.next=h1;
                h1=h1.next;
            }else {
                cur.next=h2;
                h2=h2.next;
            }
            cur=cur.next;
        }
        if(h1!=null) cur.next=h1;
        if(h2!=null) cur.next=h2;
        return dummy.next;
    }
}
