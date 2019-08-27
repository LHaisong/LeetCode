package com.prac.list;

import java.util.Scanner;
import java.util.Stack;

public class CalculateMultiplyingCount {

	public static int solution(int[][]arr,String str){
		int result=0;
		Stack<Integer> stack=new Stack<>();
		for(int i=0;i<str.length();i++){
			char temp=str.charAt(i);
			if(temp == '('){
				continue;
			}else if(temp!=')'){
				int num=temp-'A';
				stack.push(arr[num][0]);
				stack.push(arr[num][1]);
			}else {

			}
		}
		return result;
	}
	public static void main(String[]args){
		Scanner in=new Scanner(System.in);
		while (in.hasNext()){
			int matrixCount=in.nextInt();
			int[][]matrix=new int[matrixCount][2];
			for(int i=0;i<matrixCount;i++){
				matrix[i][0]=in.nextInt();
				matrix[i][1]=in.nextInt();
			}
			String expr=in.nextLine();
			System.out.print(solution(matrix,expr));
		}
		in.close();
	}
}
