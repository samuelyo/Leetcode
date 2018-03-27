package com.leetcode.MaxIncreaseToKeepCitySkyline;

public class MaxIncreaseToKeepCitySkyline2 {

	public static void main(String[] args) {
		
		int[][] grid = {{3, 0, 8, 4}, 
				        {2, 4, 5, 7},
				        {9, 2, 6, 3},
				        {0, 3, 1, 0}};
		System.out.println(maxIncreaseKeepingSkyline(grid));
		
	}
	
	public static int maxIncreaseKeepingSkyline(int[][] grid) {
		
		int n = grid.length;
        int[] col = new int[n], row = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                row[i] = Math.max(row[i], grid[i][j]);
                col[j] = Math.max(col[j], grid[i][j]);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                res += Math.min(row[i], col[j]) - grid[i][j];
        return res;
		
	}

}
