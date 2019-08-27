package com.prac.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * 计算前缀表达式
 */
public class CalculatePostFix {
	static int solution(String str)
	{
		Stack<Integer>stack=new Stack<>();
		for(int i=0;i<str.length();i++)
		{
			char c=str.charAt(i);
			if(Character.isDigit(c))
			{
				stack.push(c-'0');
			}
			else
				{
				int val1=stack.pop();
				int val2=stack.pop();
				switch (c)
				{
					case '+':
						stack.push(val1+val2);break;
					case '-':
						stack.push(val2-val1);break;
					case '*':
						stack.push(val2*val1);break;
					case '/':
						stack.push(val2/val1);break;
				}
			}
		}//231*+9-
		return stack.pop();
	}
	public static void main(String[]args)
	{
		Scanner in=new Scanner(System.in);
		String str;
		while (in.hasNextLine())
		{
			str=in.nextLine();
			System.out.println("后缀表达式计算结果为："+solution(str));
		}
	}
}
