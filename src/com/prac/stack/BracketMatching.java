package com.leetcode.stack;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class BracketMatching {
	/**
	 * 字符串中的括号匹配
	 * @param str
	 * @return
	 */
	static boolean solution(String str){
		Stack<Character>s=new Stack<>();
		char[]chars=str.toCharArray();
		for(int i=0;i<chars.length;i++){
			if(chars[i]=='('||chars[i]=='{'||chars[i]=='['){
				s.push(chars[i]);
			}
			if(chars[i]==')'||chars[i]=='}'||chars[i]==']'){
				if(s.lastElement()!=null){
					s.pop();
				}
				return false;
			}
		}
		if(s.lastElement()!=null){
			return false;
		}
		return true;
	}
	//"(")((sd)s
	public static void main(String[]args)throws IOException {
		Scanner in=new Scanner(System.in);
		String str=in.nextLine();
		   	if(solution(str)){
		   		System.out.println("括号可正常匹配");
			}else {
				System.out.println("括号不能正常匹配");
		}
	}
}
