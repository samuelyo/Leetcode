package com.leetcode.WordSubsets;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {
    public static void main(String[] args) {
        String[] A = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] B = {"ec", "oc", "ceo"};
        List<String> res = wordSubsets(A, B);
        System.out.println(res.toString());
    }

    public static List<String> wordSubsets(String[] A, String[] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return new ArrayList<>();
        }
        int[] max = new int[26];
        for (String s : B) {
            int[] temp = helper(s);
            for (int i = 0; i < 26; i++) {
                max[i] = Math.max(temp[i], max[i]);
            }
        }
        List<String> res = new ArrayList<>();
        for (String string : A) {
            int[] temp = helper(string);
            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (max[i] > temp[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res.add(string);
            }
        }
        return res;
    }

    public static int[] helper(String s) {
        int[] res = new int[26];
        char[] chs = s.toCharArray();
        for (char ch : chs) {
            res[ch - 'a']++;
        }
        return res;
    }
}
