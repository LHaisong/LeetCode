package com.prac.swordtooffer;

/**
 * 打印从1到n位的最大整数
 * 采用一个char数组来存放数字可避免溢出
 */
public class Offer_12PrintMaxDigits {

	public static void main(String[]args){
		int n=-4;
		try {
			solution(n);
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	private static void solution(int n) throws Exception {
		if(n<0){
			throw new Exception("负数没有意义！");
		}
		char[]charNums=new char[n];
		for(int i=0;i<charNums.length;i++){
			charNums[i]='0';
		}
		while (!increment(charNums)){
			printNum(charNums);
		}
	}

	private static void printNum(char[] charNums) {
		boolean isBegin=true;
		for(int i=0;i<charNums.length;i++){
		if(isBegin&&charNums[i]!='0'){
			isBegin=false;
		}
		if(!isBegin) {
			System.out.print(charNums[i]);
		}
		}
		System.out.println();
	}

	private static boolean increment(char[] charNums) {
		boolean isOverFlow=false;
		int takeOver=0;
		int cLen=charNums.length-1;
		for(int i=cLen;i>=0;i--){
			int res=charNums[i]-'0'+takeOver;
			if(i==cLen){
				res++;
			}
			if(res>=10){
				if(i==0){
					isOverFlow=true;
				}
				takeOver=1;
				res-=10;
				charNums[i]=(char)('0'+res);
			}else {
				charNums[i]=(char)('0'+res);
				break;
			}
		}
		return isOverFlow;
	}
}
