package com.prac.bytedance.listandtree;

/**
 * 用链表存储两个数(逆序)，计算出他们的和
 */
public class TwoSum {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode solution(ListNode h1,ListNode h2){
        ListNode newHead=null;
        boolean sym=false;
        while (h1.next!=null&&h2.next!=null){
            int v1=h1.val,v2=h2.val;
            if((v1+v2)<10){
                if(!sym) {
                    newHead.val = (v1 + v2);
                }else {
                    int temp=(v1 + v2)+1;
                    if(temp==10){
                        newHead.val=0;
                        sym=true;
                    }
                }
            }else {
                if(sym) {
                    newHead.val = (v1 + v2) - 10+1;
                }else {
                    newHead.val = (v1 + v2)-10;
                }
                sym=true;
            }
            h1=h1.next;h2=h2.next;newHead=newHead.next;
        }
        while (h1.next!=null){
            h1=h1.next;
            if(sym){
                int val=h1.val+1;
                if(val<10){
                    sym=false;
                    newHead.val=val;
                }else {
                    newHead.val=val-10;
                }
            }
            newHead=newHead.next;
            h1=h1.next;
        }
        return newHead;
    }

    public static ListNode addTwoNumbers(ListNode h1,ListNode h2) throws Exception {
        if(h1==null&&h2==null){
            throw new Exception("非法输入");
        }
        ListNode temp=null;
        ListNode newHead=null;
        int carry=0;//表示进位
        while (h1!=null||h2!=null||carry!=0){
            int sum=(h1==null?0:h1.val)+(h2==null?0:h2.val)+carry;
            carry=sum/10;
            ListNode node=new ListNode(sum);
            if(temp==null){
                temp=node;
                newHead=temp;
            }else {
                temp.next=node;
                temp=temp.next;
            }
            h1=h1==null?null:h1.next;
            h2=h2==null?null:h2.next;
        }
        return newHead;
    }
}
