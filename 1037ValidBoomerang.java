package com.leetcode.ValidBoomerang;

public class ValidBoomerang {
    public static void main(String[] args) {
        int[][] p = {{1, 1}, {2, 3}, {3, 2}};
        System.out.println(isBoomerang(p));
    }

    public static boolean isBoomerang(int[][] p) {
        return (p[0][0] - p[1][0]) * (p[0][1] - p[2][1]) != (p[0][0] - p[2][0]) * (p[0][1] - p[1][1]);
    }
}
