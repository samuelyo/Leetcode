package com.leetcode.ImageSmoother;

public class ImageSmoother {

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
		
		int len = M.length;
		int wid = M[0].length;
		int[][] res = new int[len][wid];
		for(int i = 0;i<len;i++){
			for(int j = 0;j<wid;j++){
				res[i][j] = imageSmootherHelp(M, i, j, len, wid);
			}
		}
		return res;
		
	}
	
	public static int imageSmootherHelp(int[][] M, int i, int j, int len, int wid) {
		
		int sum = 0;
		int count = 0;
		int[] row = {-1,0,1};
		int[] col = {-1,0,1};
		for(int m = 0;m<3;m++){
			for(int n = 0;n<3;n++){
				int rowIndex = i + row[m];
				int colIndex = j + col[n];
				if(rowIndex < len && rowIndex >= 0 && colIndex < wid && colIndex >= 0){
					sum += M[rowIndex][colIndex];
					count ++;
				}
			}
		}
		return (int) Math.floor(sum / count);
		
	}
}
