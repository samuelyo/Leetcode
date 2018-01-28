package com.leetcode.MaximalSquare;

public class MaximalSquare5 {

	public static void main(String[] args) {

//		char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
//				{ '1', '0', '0', '1', '0' } };
		char[][] matrix = {{'1','1'},{'1','1'}};
		System.out.println(maximalSquare(matrix));
		// char[] t = {'0','0'};
		//
		// List<Integer> ans = rowHelp(t);
		// for(int i = 0;i<ans.size();i++){
		// System.out.print(ans.get(i) + " ");
		// }
	}

	public static int maximalSquare(char[][] matrix) {

		int maxSide = 0;
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return maxSide;
		}
		int[][] temp = new int[matrix.length][matrix[0].length];
		for(int i = 0;i < matrix[0].length;i++){
			if(matrix[0][i] == '1'){
				maxSide = 1;
			}
			temp[0][i] = matrix[0][i] - '0';
		}
		for(int i = 0;i < matrix.length;i++){
			if(matrix[i][0] == '1'){
				maxSide = 1;
			}
			temp[i][0] = matrix[i][0] - '0';
		}
		for(int i = 1;i<matrix.length;i++){
			for(int j = 1;j<matrix[0].length;j++){
				if(matrix[i][j] == '1'){
					temp[i][j] = Math.min(temp[i - 1][j - 1], Math.min(temp[i - 1][j], temp[i][j - 1])) + 1;
					maxSide = Math.max(maxSide, temp[i][j]);
				}
			}
		}
		
		return maxSide * maxSide;
	}

}
