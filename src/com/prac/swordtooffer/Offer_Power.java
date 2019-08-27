package com.prac.swordtooffer;

public class Offer_Power {

	public static void main(String[]args)throws Exception{
		double tar=-1.5;
		int n=2;
		System.out.println(power(tar,n));
		System.out.println(Math.pow(tar,n));
	}

	private static double power(double tar, int n) throws RuntimeException {
		int n_=n;
		double res=0;
		/**
		 * 注意临界条件的判断
		 */
		if(n==0&&(tar-0.0)<1e-6) {
           return 1.0;
		}
		if(n<0&&(tar-0.0)<1e-6){
			throw new RuntimeException("0.0的负数次方无意义!");
		}
		if(n==1) {
			return tar;
		}
	    if(n<0){
	    	n_=-n;
		}
	    if(n%2==0){
	    	double temp=power(tar,n_>>1);
	    	res=temp*temp;
		}
	    if(n%2==1){
			double temp=power(tar,(n_-1)>>1);
	    	res=temp*temp*tar;
		}
	    return n>0?res:1/res;
	}
}
