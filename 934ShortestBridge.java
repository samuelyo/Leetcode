package com.leetcode.ShortestBridge;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    public static void main(String[] args) {

    }

    public static int shortestBridge(int[][] A) {
        Queue<int[]> qa = new LinkedList<>();
        Queue<int[]> qb = new LinkedList<>();
        int m = A.length, n = A[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    if (qa.isEmpty()) dfs(A, i, j, qa);
                    else dfs(A, i, j, qb);
                }
            }
        }
        int res = 0;
        int[] d = new int[]{0, 1, 0, -1, 0};
        while (!qa.isEmpty() && !qb.isEmpty()) {
            for (int size = qa.size(); size > 0; size--) {
                int[] cur = qa.poll();
                for (int k = 0; k < 4; k++) {
                    int x = cur[0] + d[k], y = cur[1] + d[k + 1];
                    if (x < 0 || x >= m || y < 0 || y >= n || A[x][y] == 3) continue;
                    if (A[x][y] == 4) return res;
                    A[x][y] = 3;
                    qa.add(new int[]{x, y});
                }
            }
            for (int size = qb.size(); size > 0; size--) {
                int[] cur = qb.poll();
                for (int k = 0; k < 4; k++) {
                    int x = cur[0] + d[k], y = cur[1] + d[k + 1];
                    if (x < 0 || x >= m || y < 0 || y >= n || A[x][y] == 4) continue;
                    if (A[x][y] == 3) return res + 1;
                    A[x][y] = 4;
                    qb.add(new int[]{x, y});
                }
            }
            res += 2;
        }
        return 1;
    }

    public static void dfs(int[][] A, int i, int j, Queue<int[]> q) {
        int m = A.length, n = A[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || A[i][j] != 1) return;
        q.add(new int[]{i, j});
        A[i][j] = 2;
        dfs(A, i + 1, j, q);
        dfs(A, i - 1, j, q);
        dfs(A, i, j + 1, q);
        dfs(A, i, j - 1, q);
    }
}
