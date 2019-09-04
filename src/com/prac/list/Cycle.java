package com.prac.list;
import java.util.HashMap;

import java.util.Map;

/**
 * 判断链表是否存在环
 */
public class Cycle {
    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode fast=head,slow=head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
    public static void main(String[]args) throws Exception {
        ListNode node=new ListNode();
        node.head=null;
        node.add(1);
        node.add(2);
        node.add(3);
        node.add(4);
        ListNode node1=node.get(2);
        ListNode node2=node.get(4);
        node.setNext(node2,node1);
        if(hasCycle(node.head)){
            System.out.println("存在环");
        }else {
            System.out.println("不存在环");
        }
    }
}
