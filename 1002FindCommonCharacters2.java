package com.leetcode.FindCommonCharacters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonCharacters2 {
    public static void main(String[] args) {
        String[] A = {"bella", "label", "roller"};
        List<String> res = commonChars(A);
        for (String s : res) {
            System.out.print(s + " ");
        }
    }

    public static List<String> commonChars(String[] A) {
        List<String> ans = new ArrayList<>();
        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);
        for (String a : A) {
            int[] t = new int[26];
            for (char c : a.toCharArray()) {
                ++t[c - 'a'];
            }
            for (int i = 0; i < 26; ++i) {
                count[i] = Math.min(t[i], count[i]);
            }
        }
        for (int i = 0; i < 26; ++i) {
            if (count[i] == Integer.MAX_VALUE) continue;
            while (count[i]-- > 0) {
                ans.add("" + (char) (i + 'a'));
            }
        }
        return ans;
    }
}
