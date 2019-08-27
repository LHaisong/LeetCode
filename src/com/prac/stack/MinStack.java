package com.prac.stack;

import java.util.LinkedList;
import java.util.Queue;

public class MinStack {
	MinStack s1=new MinStack();
	MinStack s2=new MinStack();
	Queue<Integer>q1=new LinkedList<>();
	Queue<Integer>q2=new LinkedList<>();
	private int size;
	public MinStack(){
		this.size=0;
	}

	/**
	 * 出方法q2一定为null
	 * @param x
	 */
	public void push(int x) {
		size++;
		q2.add(x);
        while(!q1.isEmpty()){
        	q2.add(q1.poll());
		}
        Queue<Integer>q=q1;
        q1=q2;
        q2=q;
	}

	public int pop() {
		if(q1.isEmpty())
			return -1;
		return q1.poll();
	}

	public int top() {
		if(q1.isEmpty())
			return -1;
		return q1.peek();
	}

	public int getMin() {
		while (!q1.isEmpty()) {
			int temp = s1.pop();
			while (!s2.isEmpty() && s2.top() < temp) {
				s1.push(s2.pop());
			}
			s2.push(temp);
		}
		return s2.top();
	}

	public boolean isEmpty(){
		return q1.isEmpty();
	}
}
