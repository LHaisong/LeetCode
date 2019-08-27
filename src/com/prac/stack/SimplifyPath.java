package com.prac.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SimplifyPath {
	/**
	 * 简化文件路径
	 * @param args
	 */
	public static void main(String[]args){
		String str="/a/../../b/../c//.//";
		System.out.println(simplifyPath(str));
	}
	private static String simplifyPath(String str) {
		Stack<String>stack=new Stack<>();
		String[]strArr=str.split("/");
		for(String s:strArr){
			if(!stack.empty()&&s.equals("..")){
				stack.pop();
			}
			else if(!s.equals(".")&&!s.equals("")&&!s.equals("..")){
				stack.push(s);
			}
		}
		if(stack.empty())
			return "/";
		List<String> list = new ArrayList(stack);
		return "/" + String.join("/", list);
	}
}
