package com.leetcode.ProjectionAreaOf3DShapes;

public class ProjectionAreaOf3DShapes2 {
    public static void main(String[] args) {
        int[][] grid = {{2, 2, 2}, {2, 1, 2}, {2, 2, 2}};
        System.out.println(projectionArea(grid));
    }

    public static int projectionArea(int[][] grid) {
        int z = 0, x = 0, y = 0;
        for (int i = 0; i < grid.length; ++i) {
            int mx = 0, my = 0; // max of x & y values.
            for (int j = 0; j < grid.length; ++j) {
                mx = Math.max(mx, grid[j][i]); // see above 1
                my = Math.max(my, grid[i][j]); // see above 2
                if (grid[i][j] > 0) {
                    ++z;
                } // only the cell with positive value has a projection area of size 1 in z direction.
            }
            x += mx;
            y += my; // x & y projection accumulation.
        }
        return x + y + z;
    }
}
