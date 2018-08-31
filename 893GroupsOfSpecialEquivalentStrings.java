package com.leetcode.GroupsOfSpecialEquivalentStrings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GroupsOfSpecialEquivalentStrings {
    public static void main(String[] args) {
        String[] A = {"abcd", "cdab", "adcb", "cbad"};
        int res = numSpecialEquivGroups(A);
        System.out.println(res);
    }

    public static int numSpecialEquivGroups(String[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        Set<String> set = new HashSet<>();
        for (String s : A) {
            char[] chs = s.toCharArray();
            StringBuilder odd = new StringBuilder();
            StringBuilder even = new StringBuilder();
            for (int i = 0; i < chs.length; i++) {
                if (i % 2 == 0) {
                    even.append(chs[i]);
                } else {
                    odd.append(chs[i]);
                }
            }
            char[] oddChar = odd.toString().toCharArray();
            Arrays.sort(oddChar);
            char[] evenChar = even.toString().toCharArray();
            Arrays.sort(evenChar);
            String temp = "" + new String(oddChar) + new String(evenChar);
            set.add(temp);
        }
        return set.size();
    }
}
