package com.leetcode.SurfaceAreaOf3DShapes;

public class SurfaceAreaOf3DShapes {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println(surfaceArea(grid));
    }

    public static int surfaceArea(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total += grid[i][j] * 6;
                if (grid[i][j] > 0) {
                    total -= (grid[i][j] - 1) * 2;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i + 1 < m) {
                    total -= Math.min(grid[i][j], grid[i + 1][j]) * 2;
                }
                if (j + 1 < n) {
                    total -= Math.min(grid[i][j], grid[i][j + 1]) * 2;
                }
            }
        }
        return total;
    }
}
