package com.leetcode.WordSubsets;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets2 {
    public static void main(String[] args) {
        String[] A = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] B = {"ec", "oc", "ceo"};
        List<String> res = wordSubsets(A, B);
        System.out.println(res.toString());
    }

    public static List<String> wordSubsets(String[] A, String[] B) {
        int[] uni = new int[26], tmp;
        int i;
        for (String b : B) {
            tmp = counter(b);
            for (i = 0; i < 26; ++i)
                uni[i] = Math.max(uni[i], tmp[i]);
        }
        List<String> res = new ArrayList<>();
        for (String a : A) {
            tmp = counter(a);
            for (i = 0; i < 26; ++i)
                if (tmp[i] < uni[i]) break;
            if (i == 26) res.add(a);
        }
        return res;
    }

    private static int[] counter(String word) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) count[c - 'a']++;
        return count;
    }
}
