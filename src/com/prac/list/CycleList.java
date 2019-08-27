package com.prac.list;

public class CycleList<T> {
    static class Node<E>{
        E item;
        Node<E> next,prev;
        Node(E element) {
            this.item = element;
            this.next=null;
            this.prev=null;
        }
    }
    static Node head,tail,p;
    int size=0;
    public CycleList(){
        this.head=null;
        tail=head;
        p=head;
    }
    public int length(){
        return size;
    }
    public void addEle(T ele){
        Node temp=new Node(ele);
        if(head==null){
            head=temp;
            tail=head;
            p=head;
            size++;
        }else {
            temp.next=head;
            head.prev=temp;
            head=temp;
            tail.next=head;
            p=head;
            size++;
        }
    }
    public T getEle(int index) throws Exception {
        int indexNum=0;
        Node node=head;
        if(index>size){
            throw new Exception("输入的index大于链表长度，不合法");
        }
        /**
         * 这如果用二分法效率会更高
         */
        if(index<(size>>1)) {
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        }else {
            for(int i=size-1;i>index;i--){
                node=tail.prev;
            }
        }
        return (T) node.item;
    }
    public void remove(int index) throws Exception {
        if(index>size){
            throw new Exception("输入的index大于链表长度，不合法");
        }
        Node node=head;
        int removeIndex=0;
        while (removeIndex!=index){
            node=node.next;
            removeIndex++;
        }
        if(node==head){
            head=head.next;
            tail.next=head;
        }
        if(node==tail){
            Node temp=tail.prev;
            temp.next=head;
            tail=temp;
        }
        Node prev=node.prev;
        prev.next=node.next;
        node=null;
    }
    public boolean isEmpty(){
        if(head!=null){
            return false;
        }
        return true;
    }
}
