package com.prac.swordtooffer;

import java.io.IOException;

/**
 * 假设第一次跳1阶：则f(n)=1+f(n-1)
 * 假设第一次跳2阶：则f(n)=1+f(n-2)
 * 综上：f(n)=f(n-1)+f(n-2)  (n>2)
 * 斐波那契数列问题
 */
public class Offer_JumpFloor {
	public static void main(String[]args){
		int n=9;
		try {
			System.out.println(jumpResult(n));
			System.out.println(floop(n));
			System.out.println(matrixResult(n));
			System.out.println(hardJump(3));
		}catch (Exception e){
			System.out.println(e.toString());
		}
	}

	/**
	 * 递归求解
	 * @param n
	 * @return
	 * @throws Exception
	 */
	private static int jumpResult(int n) throws Exception {
		if(n<0){
			throw new Exception("非法数字！");
		}
		if(n<3){
			return n;
		}
		return jumpResult(n-1)+jumpResult(n-2);
	}

	/**
	 * 循环方式求解
	 * @param n
	 * @return
	 * @throws Exception
	 */
	public static int floop(int n)throws Exception {
		if(n<0){
			throw new Exception("非法数字！");
		}
		if(n<3){
			return n;
		}
		int f2=2;
		int f1=1;
		int res=0;
		for(int i=2;i<n;i++){
			res=f2+f1;
			f1=f2;
			f2=res;
		}
		return res;
	}
	public static int matrixResult(int n){
		long[][] f = new long[][]{{0,1},{1,1}};
		if(n<3){
			return n;
		}
		f=pow(n,f);
		return (int)f[1][1];
	}

	private static long[][] pow(int n, long[][] f) {
		if(n==1){
			return f;
		}
		if(n==2){
			return fun(f,f);
		}
		if(n%2==0){
			pow(n/2,f);
			return fun(f,f);
		}
		else {
			pow(n/2+1,f);
			return fun(pow(n/2,f),pow(n/2+1,f));
		}
	}

	private static long[][] fun(long[][] f, long[][] f1) {
		long[][]temp=new long[2][2];
		temp[0][0]=(f[0][0]*f1[0][0]+f[0][1]*f1[1][0]);
		temp[0][1]=(f[0][0]*f1[0][1]+f[0][1]*f1[1][1]);
		temp[1][0]=(f[1][0]*f1[0][0]+f[1][1]*f1[1][0]);
		temp[1][1]=(f[1][0]*f1[0][1]+f[1][1]*f1[1][1]);
		return temp;
	}
	/**
	 * 假设可以跳1,2,3,4......n界
	 */
	public static int hardJump(int n)throws Exception{
		if(n<0){
			throw new Exception("非法数字...");
		}
		if(n<3){
			return n;
		}
		return 2*hardJump(n-1);
	}
}
