package com.prac.list;
import java.util.HashMap;

import java.util.Map;

/**
 * 判断链表是否存在环
 */
public class Cycle {
    public boolean hasCycle(ListNode head) {
        boolean hasCycle=false;
        if(head==null){
            throw new IllegalArgumentException("链表为null");
        }
        ListNode next,cHead=head;
        int pos=-1,cPos=-1;
        Map<ListNode,ListNode>nodeMap=new HashMap<>();
        while ((next=cHead.next)!=null){
            if(nodeMap.containsValue(next)||(next.next!=null&&next.next==head)){
                cPos++;
                hasCycle=true;
            }else {
                nodeMap.put(head,next);
            }
            cHead=next;
        }
        return pos == cPos;
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
        node.print(node.head);
    }
}
