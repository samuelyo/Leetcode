package com.leetcode.FindTheShortestSuperstring;

import java.util.Arrays;
import java.util.Stack;

public class FindTheShortestSuperstring {
    public static void main(String[] args) {
        String[] A = {"catg", "ctaagt", "gcta", "ttca", "atgcatc"};
        String res = shortestSuperstring(A);
        System.out.println(res);
    }

    public static String shortestSuperstring(String[] A) {
        int n = A.length;
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = calc(A[i], A[j]);
                graph[j][i] = calc(A[j], A[i]);
            }
        }
        int[][] dp = new int[1 << n][n];
        int[][] path = new int[1 << n][n];
        int last = -1, max = -1;
        for (int i = 1; i < (1 << n); i++) {
            Arrays.fill(dp[i], -1);
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    int prev = i - (1 << j);
                    if (prev == 0) {
                        dp[i][j] = 0;
                    } else {
                        for (int k = 0; k < n; k++) {
                            if (dp[prev][k] > -1 && dp[prev][k] + graph[k][j] > dp[i][j]) {
                                dp[i][j] = dp[prev][k] + graph[k][j];
                                path[i][j] = k;
                            }
                        }
                    }
                }
                if (i == (1 << n) - 1 && dp[i][j] > max) {
                    max = dp[i][j];
                    last = j;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int cur = (1 << n) - 1;
        Stack<Integer> stack = new Stack<>();
        while (cur > 0) {
            stack.push(last);
            int temp = cur;
            cur -= (1 << last);
            last = path[temp][last];
        }
        int i = stack.pop();
        sb.append(A[i]);
        while (!stack.isEmpty()) {
            int j = stack.pop();
            sb.append(A[j].substring(graph[i][j]));
            i = j;
        }
        return sb.toString();
    }

    private static int calc(String a, String b) {
        for (int i = 1; i < a.length(); i++) {
            if (b.startsWith(a.substring(i))) {
                return a.length() - i;
            }
        }
        return 0;
    }
}
