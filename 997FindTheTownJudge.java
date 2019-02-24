package com.leetcode.FindTheTownJudge;

public class FindTheTownJudge {
    public static void main(String[] args) {
        int N = 3;
        int[][] trust = {{1, 3}, {2, 3}, {3, 1}};
        int res = findJudge(N, trust);
        System.out.println(res);
    }

    public static int findJudge(int N, int[][] trust) {
        int[] count = new int[N + 1];
        for (int[] t : trust) {
            count[t[0]]--;
            count[t[1]]++;
        }
        for (int i = 1; i <= N; ++i) {
            if (count[i] == N - 1) return i;
        }
        return -1;
    }
}
