package com.leetcode.LetterTilePossibilities;

public class LetterTilePossibilities {
    public static void main(String[] args) {
        int res = numTilePossibilities("AAB");
        System.out.println(res);
    }

    public static int numTilePossibilities(String tiles) {
        int[] count = new int[26];
        for (char c : tiles.toCharArray()) count[c - 'A']++;
        return dfs(count);
    }

    public static int dfs(int[] arr) {
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0) continue;
            sum++;
            arr[i]--;
            sum += dfs(arr);
            arr[i]++;
        }
        return sum;
    }
}
