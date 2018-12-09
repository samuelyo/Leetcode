package com.leetcode.VerifyingAnAlienDictionary;

import java.util.Arrays;
import java.util.Comparator;

public class VerifyingAnAlienDictionary {
    public static void main(String[] args) {
        String[] words = {"apple", "app"};
        String order = "abcdefghijklmnopqrstuvwxyz";
        boolean res = isAlienSorted(words, order);
        System.out.println(res);
    }

    public static String Order;

    public static boolean isAlienSorted(String[] words, String order) {
        if (words == null || words.length == 0 || order == null) {
            return false;
        }
        String[] temp = words.clone();
        Order = order;
        Arrays.sort(temp, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int len1 = s1.length();
                int len2 = s2.length();
                char[] ch1 = s1.toCharArray();
                char[] ch2 = s2.toCharArray();
                int index = 0;
                while (index < len1 && index < len2 && ch1[index] == ch2[index]) {
                    index++;
                }
                if (index == len1) {
                    return -1;
                } else if (index == len2) {
                    return 1;
                } else {
                    return Order.indexOf(ch1[index]) - Order.indexOf(ch2[index]);
                }
            }
        });
        int index = 0;
        boolean res = true;
        while (index < words.length) {
            if (words[index].equals(temp[index])) {
                index++;
            } else {
                res = false;
                break;
            }
        }
        return res;
    }
}
