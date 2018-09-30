package com.leetcode.CatAndMouse;

public class CatAndMouse {
    public static void main(String[] args) {
        int[][] graph = {{2, 5}, {3}, {0, 4, 5}, {1, 4, 5}, {2, 3}, {0, 2, 3}};
        System.out.println(catMouseGame(graph));
    }

    public static int catMouseGame(int[][] graph) {
        int n = graph.length;
        int[][][] dp = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
            }
        }
        return calc(1, 2, 1, dp, graph);
    }

    private static int calc(int curM, int curC, int isM, int[][][] dp, int[][] graph) {
        if (curC == 0 || curM == 0)
            return 1;
        if (curC == curM)
            return 2;
        if (dp[curM][curC][isM] != -1) {
            return dp[curM][curC][isM];
        }
        dp[curM][curC][isM] = 0;
        boolean canDraw = false;
        if (isM != 0) {
            for (int i = 0; i < graph[curM].length; i++) {     //If any neigbor is 0 return 1
                if (graph[curM][i] == 0) {
                    dp[curM][curC][isM] = 1;
                    return 1;
                }
            }
            for (int i = 0; i < graph[curM].length; i++) {
                int temp = calc(graph[curM][i], curC, 0, dp, graph);
                if (temp == 1) {
                    dp[curM][curC][isM] = 1;
                    return 1;
                } else if (temp == 0) {
                    canDraw = true;
                }
            }
            if (!canDraw)
                dp[curM][curC][isM] = 2;
        } else {
            for (int i = 0; i < graph[curC].length; i++) {     //If any neighbor is current pos of mouse return 2
                if (graph[curC][i] == curM) {
                    dp[curM][curC][isM] = 2;
                    return 2;
                }
            }
            for (int i = 0; i < graph[curC].length; i++) {
                int temp = calc(curM, graph[curC][i], 1, dp, graph);
                if (temp == 2) {
                    dp[curM][curC][isM] = 2;
                    return 2;
                } else if (temp == 0) {
                    canDraw = true;
                }
            }
            if (!canDraw)
                dp[curM][curC][isM] = 1;
        }
        return dp[curM][curC][isM];
    }
}
