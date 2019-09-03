package com.prac.list;

/**
 * ListNode类
 */
public class ListNode {
    static ListNode head=null;
    static ListNode last=null;
    int val;
    ListNode next;
    public ListNode(int val){
        this.val=val;
        next = null;
    }
    ListNode(){

    }
    /**
     * 新增节点
     * @param val
     */
    public void add(int val){
        ListNode node=new ListNode(val);
        if(head==null){
            head=node;
            return;
        }
        ListNode curNode=head;
        while (curNode.next!=null){
            curNode=curNode.next;
        }
        curNode.next=node;
    }

    /**
     * 删除值为val的节点
     * @param val
     * @param head
     * @throws Exception
     */
    public boolean delete(int val,ListNode head) throws Exception {
        if(head==null){
            throw new Exception("链表为null");
        }
        boolean deleted=false;
        if(head.val==val){
            head=head.next;
        }
        ListNode curNode=head.next,next,prev=head;
        while (curNode.next!=null){
            next=curNode.next;
            if(curNode.val==val){
                prev.next=next;
                deleted=true;
                break;
            }
            prev=curNode;
            curNode=curNode.next;
        }
        return deleted;
    }

    /**
     * 打印链表
     * @param head
     */
    public void print(ListNode head){
        if(head==null){
            throw new IllegalArgumentException("链表为null");
        }
        ListNode curNode=head;
        while (curNode.next!=null){
            System.out.print(curNode.val+" ");
            curNode=curNode.next;
        }
        System.out.println(curNode.val);
    }

    /**
     * 获取值为val的节点
     * @param val
     * @return
     */
    public ListNode get(int val){
        ListNode node=head,resNode=null;
        if(node==null){
            throw new IllegalArgumentException("链表为null");
        }
        while (node!=null){
            if(node.val==val){
                return node;
            }
            node=node.next;
        }
        return resNode;
    }

    public void setNext(ListNode curNode,ListNode next){
        if(curNode!=null&&next!=null){
            curNode.next=next;
        }
    }
}
