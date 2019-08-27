package com.prac.swordtooffer;

/**
 * 替换空格
 * 1.直接使用String.replace()方法
 * 2.使用自己定义的方法
 */
public class Offer_two {
	public static String solution(String s) throws Exception {
		StringBuffer sb=new StringBuffer();
		String[]strs=s.split(" ");
		String result;
		if(strs.length==0){
			throw new Exception("input is illegal");
		}
		for(int i=0;i<strs.length-1;i++){
			sb=sb.append(strs[i]).append("%20");
		}
		result=sb.append(strs[strs.length-1]).toString();
		return result;
	}
	public static void main(String[]args){
		String src="we are happy";
		//src=src.replace(" ","%20");
		try {
			System.out.println(solution(src));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
