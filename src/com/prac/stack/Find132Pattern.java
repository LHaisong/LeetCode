package com.prac.stack;

import java.util.Stack;

/**
 * 寻找一个数组中是否存在i<j<k时 arr[i]<arr[k]<arr[j]
 */
public class Find132Pattern {
	static int third=Integer.MIN_VALUE;
	public static boolean find132Pattern(int[]num)
	{
		Stack<Integer>stack=new Stack<>();
		for(int i=num.length-1;i>0;i--){
			if(num[i]<third)
				return true;
			while (!stack.empty()&&num[i]>stack.peek())
			{
				third=stack.pop();
			}
			stack.push(num[i]);
		}
		return false;
	}
	public static void main(String[]args){
		int[]num={1,2,3,5,6,8};
		System.out.println(find132Pattern(num));
	}
}
