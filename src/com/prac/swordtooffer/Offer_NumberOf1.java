package com.prac.swordtooffer;

/**
 * 求整数的二进制中1的个数
 */
public class Offer_NumberOf1 {
	public static void main(String[]args){
		int n=0x80000000;
	    System.out.println(solution(n));
	}

	private static int solution(int n) {
		int num=0;
		while (n!=0){
			num++;
			n=(n-1)&n;
		}
		return num;
	}
}