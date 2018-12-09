package com.leetcode.VerifyingAnAlienDictionary;

import java.util.Arrays;
import java.util.Comparator;

public class VerifyingAnAlienDictionary2 {
    public static void main(String[] args) {
        String[] words = {"apple", "app"};
        String order = "abcdefghijklmnopqrstuvwxyz";
        boolean res = isAlienSorted(words, order);
        System.out.println(res);
    }

    public static boolean isAlienSorted(String[] words, String order) {
        int k = 0;
        while (k + 1 < words.length) {

            // loop through words[], compare two consecutive strings at a time
            if (checkInOrderWithNext(order, words, k))
                k++;
            else
                return false;
        }
        return true;
    }

    private static boolean checkInOrderWithNext(String order, String[] words, int k) {
        int wordLengthMax = Math.max(words[k].length(), words[k + 1].length());
        int currentOrderIdx = 0;

        // compare the two strings one char at a time
        for (int i = 0; i < wordLengthMax; i++) {

            // if the previous one runs out first, return true
            if (i >= words[k].length())
                return true;

            // if the latter one runs out first, return false
            if (i >= words[k + 1].length())
                return false;

            // if current comparing chars are strictly increasing in order, return true
            // if they are equal, compare next chars
            // if they are strictly decreasing in order, return false
            if (order.indexOf(words[k].charAt(i)) < order.indexOf(words[k + 1].charAt(i)))
                return true;
            else if (order.indexOf(words[k].charAt(i)) == order.indexOf(words[k + 1].charAt(i)))
                continue;
            else
                return false;
        }

        // return true if they are identical
        return true;
    }
}
