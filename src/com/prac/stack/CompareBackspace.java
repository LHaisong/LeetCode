package com.prac.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * 字符串退格
 */
public class CompareBackspace {
	public static void main(String[]args)
	{
		Scanner in=new Scanner(System.in);
		String str=in.nextLine();
		String[]arr=str.split(" ");
		//System.out.println(Arrays.toString(arr));
		System.out.println(compareBackspace(arr[0]).equals(compareBackspace(arr[1])));
	}

	private static String compareBackspace(String s) {
		Stack<Character>stack=new Stack<>();
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			if (!stack.empty()&&c=='#'){
				stack.pop();
			}
			if(c=='#'){
			}
			else {
				stack.push(c);
			}
		}
		StringBuilder sb=new StringBuilder();
		while (!stack.empty()){
			sb.append(stack.pop());
		}
		return sb.reverse().toString();
	}
}
