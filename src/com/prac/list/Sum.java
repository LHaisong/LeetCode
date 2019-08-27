package com.prac.list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sum{
	public static void main(String[]args){
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int count=0;
		try {
			String str = br.readLine();
			char[] strToChar = str.split(" ")[0].toCharArray();
			char a=str.split(" ")[1].toCharArray()[0];
			if (strToChar.length<=0) {
				System.out.print(" string is null!");
			}
			if(a+""==null){
				System.out.print(" char is null!");
			}
			if(str.split(" ").length>2){
				System.out.print(" illegal input!");
			}
			else {
				for (int i = 0; i < strToChar.length; i++) {
					if (strToChar[i] == a) {
						count++;
					}
				}
			}
			System.out.print(count);
		}catch (IOException e){
			e.printStackTrace();
		}
	}

}