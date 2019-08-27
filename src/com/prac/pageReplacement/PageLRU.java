package com.prac.pageReplacement;

import java.util.Stack;

/**
 * java实现页面置换算法
 * LRU最近最久未使用
 */
public class PageLRU {
    public static void main(String[]args){
        int[] arr = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1};
        implementLRU(arr);
    }

    private static void implementLRU(int[] arr) {
        Stack<Integer>pageStack=new Stack<>();
        int size=3;
        int addCount=0;
        for(int i=0;i<arr.length;i++){
            if(addCount<size){
                pageStack.push(arr[i]);
                addCount++;
            }else {
                Stack<Integer> tempStack = pageStack;
                while (!tempStack.empty()) {
                    System.out.print(tempStack.pop());
                }
                System.out.println();
                int k = i + 1;
                //判断下一个要调入的页是否存在内存中
                if (judgePageInMemory(pageStack, arr[k])) {
                    //重新调整栈中元素的顺序
                    pageStack = adjustOrder(pageStack, arr[k]);
                } else {
                    //替换操作
                    pageStack = replacePage(pageStack, arr[k]);
                }
            }
        }
    }

    private static Stack<Integer> replacePage(Stack<Integer> pageStack, int i) {
        Stack<Integer>tempStack=null;
        while (!pageStack.empty()){
            tempStack.push(pageStack.pop());
        }
        //将栈顶最久未使用过的页直接弹出
        tempStack.pop();
        while (!tempStack.empty()){
            pageStack.push(tempStack.pop());
        }
        pageStack.push(i);
        return pageStack;
    }

    /**
     * 调整栈中页的顺序，使得栈顶永远保存着最近使用过的页，
     * 而栈底保存的是最近最久未使用的页
     * @param pageStack
     * @param i
     * @return
     */
    private static Stack<Integer> adjustOrder(Stack<Integer> pageStack, int i) {
        Stack<Integer>tempStack=null;
        while (!pageStack.empty()){
            //如果栈顶元素是下一个需要的页直接删除
            if(pageStack.peek()==i){
                pageStack.pop();
                while (!tempStack.empty()){
                    pageStack.push(tempStack.pop());
                }
                //将最近使用的页重新压入栈顶
                pageStack.push(i);
            }
            tempStack.push(pageStack.pop());
        }
        return pageStack;
    }

    private static boolean judgePageInMemory(Stack<Integer> pageStack, int k) {
        while (!pageStack.empty()){
            int temp=pageStack.pop();
            if(temp==k){
                return true;
            }
        }
        return false;
    }
}
