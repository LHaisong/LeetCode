package com.leetcode.stack;

import java.util.Stack;

public class SortStack {
	/**
	 * 给一栈数据排序
	 * @param input
	 * @return
	 */
	static Stack<Integer> solution(Stack<Integer> input)
	{
		Stack<Integer>temStack=new Stack<>();
		while (!input.empty())
		{
			int res=input.pop();
			while (!temStack.empty()&&temStack.peek()>res)
			{
				input.push(temStack.pop());
			}
			temStack.push(res);
		}
		return temStack;
	}
	public static void main(String[]args)
	{
		Stack<Integer> stack=new Stack<>();
		stack.push(15);
		stack.push(29);
		stack.push(18);
		stack.push(39);
		stack.push(26);
		stack.push(98);
		stack.push(8);
		stack.push(24);
		Stack<Integer>resStack=solution(stack);
		while(!resStack.empty())
		{
		    System.out.print(resStack.pop()+" ");
		}
	}
}
