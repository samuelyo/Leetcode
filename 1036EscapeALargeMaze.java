package com.leetcode.EscapeALargeMaze;

import java.util.HashSet;
import java.util.Set;

public class EscapeALargeMaze {
    public static void main(String[] args) {
        int[][] blocked = {{0, 1}, {1, 0}};
        int[] source = {0, 0};
        int[] target = {0, 2};
        boolean res = isEscapePossible(blocked, source, target);
        System.out.println(res);
    }

    public static final int MAX_VISIT = 20000;

    public static boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<String> blockedSet = new HashSet<>();
        for (int[] point : blocked) {
            blockedSet.add(getKey(point));
        }
        return canVisit(blockedSet, source, getKey(target)) && canVisit(blockedSet, target, getKey(source));
    }

    public static String getKey(int[] point) {
        return point[0] + "," + point[1];
    }

    public static boolean canVisit(Set<String> blocked, int[] source, String targetKey) {
        Set<String> visited = new HashSet<>();
        dfs(blocked, source, targetKey, visited);
        return visited.size() >= MAX_VISIT || visited.contains(targetKey);
    }

    public static void dfs(Set<String> blocked, int[] curr, String targetKey, Set<String> visited) {
        int i = curr[0], j = curr[1];
        if (i < 0 || j < 0 || i >= 1e6 || j >= 1e6) {
            return;
        }

        String key = getKey(curr);
        if (blocked.contains(key)) {
            return;
        }
        if (visited.size() >= MAX_VISIT || visited.contains(targetKey)) {
            return;
        }

        if (visited.contains(key)) {
            return;
        }
        visited.add(key);

        for (int[] next : new int[][]{{i - 1, j}, {i + 1, j}, {i, j - 1}, {i, j + 1}}) {
            dfs(blocked, next, targetKey, visited);
        }
    }
}
