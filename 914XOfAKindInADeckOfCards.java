package com.leetcode.XOfAKindInADeckOfCards;

import java.util.*;

public class XOfAKindInADeckOfCards {
    public static void main(String[] args) {
        int[] deck = {1, 1, 1, 2, 2, 2, 3, 3};
        System.out.println(hasGroupsSizeX(deck));
    }

    public static boolean hasGroupsSizeX(int[] deck) {
        if (deck == null || deck.length == 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : deck) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int res = 0;
        for (int num : map.values()) {
            res = gcd(res, num);
        }
        return res > 1;
    }

    private static int gcd(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        a = max;
        b = min;
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
