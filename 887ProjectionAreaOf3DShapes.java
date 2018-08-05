package com.leetcode.ProjectionAreaOf3DShapes;

public class ProjectionAreaOf3DShapes {
    public static void main(String[] args) {
        int[][] grid = {{2, 2, 2}, {2, 1, 2}, {2, 2, 2}};
        System.out.println(projectionArea(grid));
    }

    public static int projectionArea(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int zCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    zCount++;
                }
            }
        }
        int yCount = 0;
        for (int j = 0; j < grid[0].length; j++) {
            int max = 0;
            for (int i = 0; i < grid.length; i++) {
                max = Math.max(max, grid[i][j]);
            }
            yCount += max;
        }
        int xCount = 0;
        for (int i = 0; i < grid.length; i++) {
            int max = 0;
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, grid[i][j]);
            }
            xCount += max;
        }
        return xCount + yCount + zCount;
    }
}
