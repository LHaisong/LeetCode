package com.prac.swordtooffer;

/**
 * 复制一个复杂链表
 */
public class Offer_23CopyComplexList {
    static Node head=null;
    static class Node{
        Node next=null;
        Node other=null;//指向其他任意指针，包括null
        int val;
        public Node(int val){
            this.val=val;
        }
    }

    /**
     * 整个过程可以分为3步：
     * 1.遍历链表，逐个复制节点用next连接起来  A-->A1-->B-->B1.......
     * 2.复制旧链表other节点给新链表节点
     * 3.拆分链表
     * @param head
     * @return
     */
    static Node cloneList(Node head) throws Exception {
        if(head==null){
            throw new Exception("空链表");
        }
        Node curNode=head;
        //第一步
        while (curNode!=null){
            Node copyNode=new Node(curNode.val);
            Node curNextNode=curNode.next;
            curNode.next=copyNode;
            copyNode.next=curNextNode;
            curNode=curNextNode;
        }
        curNode=head;
        //第二步重新遍历链表复制other节点
        while (curNode!=null){
            curNode.next.other=curNode.other==null?null:curNode.other.next;
            curNode=curNode.next.next;
        }
        curNode=head;
        Node copyHead=head.next;
        //第三步 分离链表
        while (curNode!=null){
            Node cloneNode=curNode.next;
            curNode.next=cloneNode.next;
            cloneNode.next=cloneNode.next==null?null:curNode.next.next;
            curNode=curNode.next;
        }
        return copyHead;
    }
    public static void main(String[]args)throws Exception{
        Node root=head;
        cloneList(root);
    }
}
