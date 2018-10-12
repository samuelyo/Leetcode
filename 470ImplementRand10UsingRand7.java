package com.leetcode.ImplementRand10UsingRand7;

import java.util.Random;

public class ImplementRand10UsingRand7 {
    public static void main(String[] args) {

    }

    public int rand10() {
        int result = 40;
        while (result >= 40) {
            result = 7 * (rand7() - 1) + (rand7() - 1);
        }
        return result % 10 + 1;
    }

    private int rand7() {
        return new Random().nextInt(7);
    }

}
