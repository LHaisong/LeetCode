package com.prac.swordtooffer;

public class Offer_20PrintMatrixClockWise {

	public static void main(String[]args){
		int[][]matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

		String str=new String("abc");
		printMatrixClockWise(matrix);
	}

	public static void printMatrixClockWise(int[][]m){
		int rowLen=m.length;
		int colLen=m[0].length;
		if(m==null||(rowLen<=0&&colLen<=0)){
			return;
		}
		int start=0;
		while (colLen>2*start&&rowLen>2*start){
			printMatrix(m, rowLen,colLen,start);
			start++;
		}
	}
	private static void printMatrix(int[][] matrix,int rLen,int cLen,int start) {
		int endX = cLen - 1 - start;
		int endY = rLen - 1 - start;

		//打印顶行
		for (int i = start; i <= endX; i++) {
			System.out.print(matrix[start][i]+" ");
		}
		//打印右行
		if (start < endY) {
			for (int i = start + 1; i <= endY; i++) {
				System.out.print(matrix[i][endX]+" ");
			}
		}
		//打印下行
		if (start < endX && start < endY) {
			for (int i = endX - 1; i >= start; i--) {
				System.out.print(matrix[endY][i]+" ");
			}
		}
		//打印左行
		if (start < endX && start <= endY - 1) {
			for (int i = endY - 1; i > start; i--) {
				System.out.print(matrix[i][start]+" ");
			}
		}
	}
}
