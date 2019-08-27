package com.prac.list;

import java.util.*;
public class Maze{
	public static void main(String[] args){
		Scanner s=new Scanner (System.in);
		while(s.hasNext()){
			String q=s.nextLine();
			String[] q1=q.split(" ");
			int n=Integer.valueOf(q1[0]);
			int m=Integer.valueOf(q1[1]);
			int[][] arr=new int[n][m];
			boolean[][] b=new boolean[n][m];
			b[n-1][m-1]=true;

			for (int i=0;i<n;i++){
				String w=s.nextLine();
				String[] r=w.split(" ");
				for (int j=0;j<r.length;j++)
					arr[i][j]=Integer.valueOf(r[j]);
			}

			haspath(arr, b, 0, 0, n, m);
			for (int i = 0; i < b.length; i++) {
				for (int j = 0; j < b[0].length; j++) {
					if (b[i][j]) {
						System.out.println("("+i+","+j+")");
					}
				}
			}

		}
	}

	public static boolean haspath(int[][] arr,boolean [][] b, int n,int m,int nlength,int mlength) {
		boolean flag = false;
		if (n==nlength -2&&m ==mlength-1&&arr[n][m]==0) {
			b[n][m]=true;
			return true;
		}
		if (m==mlength -2&&n ==nlength-1&&arr[n][m]==0) {
			b[n][m]=true;
			return true;
		}
		else if (m>=mlength||n>=nlength) {
			return false;
		} else if (arr[n][m]==0&&!b[n][m]) {
			b[n][m] = true;
			flag = haspath(arr, b, n+1, m, nlength, mlength)||haspath(arr, b, n, m+1, nlength, mlength);
		}
		if (flag) {
			return flag;
		}else {
			b[n][m] = false;
			return false;
		}
	}
}