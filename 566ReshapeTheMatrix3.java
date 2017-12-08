package com.leetcode.ReshapeTheMatrix;

public class ReshapeTheMatrix3 {

	public static void main(String[] args) {
		
		int[][] nums = {{1,2},{3,4}};
		int r = 1;
		int c = 4;
		int[][] res = matrixReshape(nums, r, c);
		for(int i = 0;i<r;i++) {
			for(int j = 0;j<c;j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static int[][] matrixReshape(int[][] nums, int r, int c) {
		
		int row = nums.length;
		int col = nums[0].length;
		
		if(row * col != r * c) {
			return nums;
		}
		int[][] res = new int[r][c];
		int index = 0;
		int temp = 0;
		while(index < row * col) {
			int value = nums[index / col][index % col];
			res[temp / c][temp % c] = value;
			index ++;
			temp ++;
		}
		return res;
		
	}
}
