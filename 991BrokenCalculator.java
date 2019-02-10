package com.leetcode.BrokenCalculator;

public class BrokenCalculator {
    public static void main(String[] args) {
        int X = 2, Y = 3;
        System.out.println(brokenCalc(X, Y));
    }

    public static int brokenCalc(int X, int Y) {
        int res = 0;
        while (Y > X) {
            Y = Y % 2 > 0 ? Y + 1 : Y / 2;
            res++;
        }
        return res + X - Y;
    }
}
