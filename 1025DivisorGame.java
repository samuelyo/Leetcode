package com.leetcode.DivisorGame;

public class DivisorGame {
    public static void main(String[] args) {
        boolean res = divisorGame(3);
        System.out.println(res);
    }

    public static boolean divisorGame(int N) {
        return N % 2 == 0;
    }
}
