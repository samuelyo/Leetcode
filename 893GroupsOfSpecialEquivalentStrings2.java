package com.leetcode.GroupsOfSpecialEquivalentStrings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GroupsOfSpecialEquivalentStrings2 {
    public static void main(String[] args) {
        String[] A = {"abcd", "cdab", "adcb", "cbad"};
        int res = numSpecialEquivGroups(A);
        System.out.println(res);
    }

    public static int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        for (String s : A) {
            int[] odd = new int[26];
            int[] even = new int[26];
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) odd[s.charAt(i) - 'a']++;
                else even[s.charAt(i) - 'a']++;
            }
            String sig = Arrays.toString(odd) + Arrays.toString(even);
            set.add(sig);
        }
        return set.size();
    }
}
