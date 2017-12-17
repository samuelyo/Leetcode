package com.leetcode.ImageSmoother;

public class ImageSmoother2 {

	public static void main(String[] args) {
		
		int[][] M ={{1,1,1},{1,0,1},{1,1,1}};
		int[][] res = imageSmoother(M);
		for(int i = 0;i<res.length;i++){
			for(int j = 0;j<res[0].length;j++){
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
		
	}

	public static int[][] imageSmoother(int[][] M) {
		
		int m = M.length;
		int n = M[0].length;
		int[][] dir = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1},
			{1, -1}, {1, 0}, {1, 1}};
		
		
		int[][] res = new int[m][n];
		for(int i = 0;i<m;i++) {
			for(int j = 0;j<n;j++) {
				int count = 0;
				int sum = 0;
				for(int k = 0;k<dir.length;k++) {
					int row = i + dir[k][0];
					int col = j + dir[k][1];
					if(row >= 0 && row < m && col >= 0 && col < n) {
						count ++;
						sum += M[row][col];
					}
				}
				res[i][j] = (int) Math.floor(sum / count);
			}
		}
		return res;
		
	}
}
