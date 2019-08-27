package com.prac.list;

import java.util.Scanner;

public class first {
	public static void main(String[]args){
		Scanner in=new Scanner(System.in);

		//solution(ip1,ip2,compare);
		while(in.hasNext()){
			String[] compare=in.nextLine().split("\\.");
			String[]ip1=in.nextLine().split("\\.");
			String[]ip2=in.nextLine().split("\\.");

			for(int i=0;i<compare.length;i++) {
				if(Integer.valueOf(compare[i])<0||Integer.valueOf(compare[i])>255||
				Integer.valueOf(ip1[i])<0||Integer.valueOf(ip1[i])>255||
						Integer.valueOf(ip2[i])<0||Integer.valueOf(ip2[i])>255){
					System.out.print(1);
					break;
				}
				else if((Integer.valueOf(compare[i])&Integer.valueOf(ip1[i]))==(Integer.valueOf(compare[i])&Integer.valueOf(ip2[i]))){
					System.out.print(0);
				}
				else {
					System.out.print(2);
					break;
				}
			}
		}
	}
}
