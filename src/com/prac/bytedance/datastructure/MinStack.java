package com.prac.bytedance.datastructure;


import java.util.ArrayList;
import java.util.List;

/**
 * 支持top(),pop(),push()操作，
 * 并且能在常数时间内获得栈中的最小值
 * 使用数组实现
 */
public class MinStack {
    public static List<Integer> elementList;
    public static int minEle=Integer.MAX_VALUE;
    public static int eleCount=-1;
    public MinStack(){
        elementList=new ArrayList<>();
    }
    /**
     * 将元素压入栈中
     * @param val
     * @return
     */
    public static void push(int val){
        elementList.add(val);
        eleCount++;
        if(val<minEle){
            minEle=val;
        }
    }

    /**
     * 获取栈顶元素
     * @return
     */
    public static int top() throws Exception {
        if(eleCount==-1){
            throw new Exception("stack 为null");
        }
        return elementList.get(eleCount);
    }

    /**
     * 弹出栈顶元素
     * @return
     */
    public static int pop() throws Exception {
        int val;
        if(eleCount==-1){
            throw new Exception("stack 为null");
        }else {
            val=elementList.get(eleCount);
            elementList.remove(eleCount--);
        }
        return val;
    }
    /**
     * 获取栈中最小的元素
     */
    public static int getMin(){
        return minEle;
    }
    public boolean isEmpty(){
        boolean isEmpty=false;
        if(eleCount==-1){
            isEmpty=true;
        }
        return isEmpty;
    }

}
class Test{
    public static void main(String[]args) throws Exception {
        MinStack minStack=new MinStack();
        minStack.push(2);
        minStack.push(3);
        minStack.push(-5);
        minStack.push(0);
        minStack.push(1);
        int val=minStack.top();
        int min=minStack.getMin();
        System.out.println(val);
        System.out.println(min);
        while (!minStack.isEmpty()){
            System.out.print(minStack.pop()+" ");
        }
    }
}
