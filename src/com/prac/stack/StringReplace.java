package com.prac.stack;

/**
 * LeetCode 1003
 * 检测替换后的字符串是否有效
 */
public class StringReplace {

	public static void main(String[]args){
		String s="aabcbc";
		System.out.println(isValid(s));
		System.out.println(isValid1(s));
	}

	private static boolean isValid(String s) {
		while (s.contains("abc")){
			s.replace(s,"");
		}
		if(s.equals("")){
			return true;
		}
		return false;
	}

	private static boolean isValid1(String s) {

		return false;
	}
}
