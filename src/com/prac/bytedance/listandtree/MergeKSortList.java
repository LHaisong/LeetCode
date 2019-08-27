package com.prac.bytedance.listandtree;
/**
 * 合并K个排序链表，分析时间复杂度和空间复杂度
 */
public class MergeKSortList {
    public static class ListNode {
        ListNode head = null;
        ListNode last = null;
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
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

        public static ListNode mergeKLists(ListNode[] listNodes) throws Exception {
            ListNode mergeNode=null;
            for(int i=0;i<listNodes.length;i++){
                ListNode h=listNodes[i];
                mergeNode=merge(mergeNode,h);
            }
            return mergeNode;
        }

        public static ListNode merge(ListNode h1, ListNode h2) throws Exception {
            ListNode mergeHead=null;
            if (h1 == null && h2 == null) {
                throw new Exception("输入不符合规范");
            }
            if (h1 == null && h2 != null) {
                return h2;
            }
            if (h1 != null && h2 == null) {
                return h1;
            }
            while (h1 != null && h2 != null) {
                if (h1.val < h2.val) {
                    mergeHead=h1;
                    h1=h1.next;
                }
                if(h1.val>=h2.val){
                    mergeHead=h2;
                    h2=h2.next;
                }
                mergeHead=mergeHead.next;
            }
            while (h1!=null){
                mergeHead=h1;
                h1=h1.next;
                mergeHead=mergeHead.next;
            }
            while (h2!=null){
                mergeHead=h2;
                h2=h2.next;
                mergeHead=mergeHead.next;
            }
            return mergeHead;
        }
    }
}
