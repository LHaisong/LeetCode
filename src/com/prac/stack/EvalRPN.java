package com.prac.stack;

import java.util.Stack;

/**
 * LeetCode150
 * 逆波兰表达式求值,根本原理在于求后缀表达式的值
 */
public class EvalRPN {
	public static void main(String[]args){
		String[]strings={"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
		System.out.println(solution(strings));
	}

	private static int solution(String[] strings) {
		Stack<Integer>stack=new Stack<>();

		int v1,v2;
		for(int i=0;i<strings.length;i++){
			String c=strings[i];
			if(!c.equals("+")&&!c.equals("-")&&!c.equals("*")&&!c.equals("/")){
				stack.push(Integer.valueOf(strings[i]));
			}else {
				switch (strings[i]) {
					case "*":
						v1 = stack.pop();
						v2 = stack.pop();
						stack.push(v1 * v2);
						break;
					case "/":
						v1 = stack.pop();
						v2 = stack.pop();
						stack.push(v2 / v1);
						break;
					case "+":
						v1 = stack.pop();
						v2 = stack.pop();
						stack.push(v2 + v1);
						break;
					case "-":
						v1 = stack.pop();
						v2 = stack.pop();
						stack.push(v2 - v1);
						break;
				}
			}
		}
		return stack.pop();
	}
}
