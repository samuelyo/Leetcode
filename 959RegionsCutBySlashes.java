package com.leetcode.RegionsCutBySlashes;

public class RegionsCutBySlashes {
    public static void main(String[] args) {
        String[] grid = {};
        int res = regionsBySlashes(grid);
        System.out.println(res);
    }

    public static int count, n;
    public static int[] f;

    public static int regionsBySlashes(String[] grid) {
        n = grid.length;
        f = new int[n * n * 4];
        count = n * n * 4;
        for (int i = 0; i < n * n * 4; ++i) f[i] = i;

        // top: 0, right: 1, bottom: 2, left: 3
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i > 0) union(g(i - 1, j, 2), g(i, j, 0));
                if (j > 0) union(g(i, j - 1, 1), g(i, j, 3));
                if (grid[i].charAt(j) != '/') {
                    union(g(i, j, 0), g(i, j, 1));
                    union(g(i, j, 2), g(i, j, 3));
                }
                if (grid[i].charAt(j) != '\\') {
                    union(g(i, j, 0), g(i, j, 3));
                    union(g(i, j, 2), g(i, j, 1));
                }
            }
        }
        return count;
    }

    public static int find(int x) {
        if (x != f[x]) {
            f[x] = find(f[x]);
        }
        return f[x];
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            f[x] = y;
            count--;
        }
    }

    public static int g(int i, int j, int k) {
        return (i * n + j) * 4 + k;
    }

}
