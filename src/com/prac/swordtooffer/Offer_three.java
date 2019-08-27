package com.prac.swordtooffer;

import java.util.ArrayList;
import java.util.List;

public class Offer_three {
	public static void solution(List<Integer> list){
		int sz=list.size();
		while (sz>0){
			sz--;
			System.out.print(list.get(sz)+" ");
		}
	}
	public static void main(String[]args){
		List<Integer>list=new ArrayList<>();
		for(int i=0;i<6;i++){
			list.add(i);
		}
		solution(list);
	}
}
