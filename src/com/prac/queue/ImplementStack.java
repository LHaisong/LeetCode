package com.prac.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用队列实现栈
 */
public class ImplementStack {
	static Queue<Integer> queue1=new LinkedList<>();
	static Queue<Integer> queue2=new LinkedList<>();
    static int cur_size;
    public ImplementStack()
	{
    	cur_size=0;
	}
	public static int pop(){
		if(queue1.isEmpty())
			return -1;
		return queue1.poll();
	}

	public static void push(int ele)
	{
        cur_size++;
        queue2.add(ele);
        while (!queue1.isEmpty())
        {
        	queue2.add(queue1.peek());
        	queue1.remove();
		}//这一步过后queue1为null
        Queue<Integer> q=queue1;
        queue1=queue2;
        queue2=q;//这一步过后queue2为null
	}
	public boolean isEmpty()
	{
        if(queue1.isEmpty())
        	return true;
        return false;
	}

	public int size()
	{
		return cur_size;
	}
}

class Test
{
	public static void main(String[]args)
	{
	    ImplementStack stack=new ImplementStack();
	    stack.push(5);
	    stack.push(6);
	    while (!stack.isEmpty())
		{
			System.out.println(stack.pop());
		}
	    System.out.println(stack.size());
	}
}
