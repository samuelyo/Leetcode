package com.leetcode.FruitIntoBaskets;

public class FruitIntoBaskets {
    public static void main(String[] args) {
        int[] tree = {};
        int res = totalFruit(tree);
        System.out.println(res);
    }

    public static int totalFruit(int[] tree) {
        int[] map = new int[40001];
        int cnt = 0;
        int max = 0;
        for (int l = 0, r = 0; r < tree.length; r++) {
            if (map[tree[r]] == 0) {
                cnt++;
            }
            map[tree[r]]++;
            while (cnt > 2) {
                map[tree[l]]--;
                if (map[tree[l]] == 0) {
                    cnt--;
                }
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
