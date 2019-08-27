package com.prac.swordtooffer;

public class Offer_MatrixCover {

	public static void main(String[]args){
		int tar=9;
		System.out.println(solution(tar));
	}

	private static int solution(int tar) {
		if(tar*2==2){
			return 1;
		}
		if(tar*2==4){
			return 2;
		}
		return solution(tar-1)+solution(tar-2);
	}
}
