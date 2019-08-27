package com.prac.swordtooffer;

import java.util.Stack;

/**
 * 用两个栈实现队列
 */
public class Offer_five {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void push(int node) {
		stack1.push(node);
	}

	public int pop() throws Exception {
		if(stack1.empty())
			throw new Exception("queue is empty!");
		while (!stack1.empty()){
			stack2.push(stack1.pop());
		}
		int top=stack2.pop();
		while (!stack2.empty()){
			stack1.push(stack2.pop());
		}
		return top;
	}
	public boolean isEmpty(){
		if(stack1.empty())
			return true;
		return false;
	}
}
class Test{
	public static void main(String[]args) throws Exception {
		Offer_five of = new Offer_five();
		for (int i = 0; i < 5; i++) {
			of.push(i);
		}
		while (!of.isEmpty()) {
			System.out.print(of.pop() + " ");
		}
	}
}
