package com.leetcode.OccurrencesAfterBigram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OccurrencesAfterBigram {
    public static void main(String[] args) {
        String text = "alice is a good girl she is a good student";
        String first = "a";
        String second = "good";
        String[] res = findOcurrences(text, first, second);
        System.out.println(Arrays.toString(res));
    }

    public static String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> ans = new ArrayList<>();
        for (int i = 2; i < words.length; ++i) {
            if (first.equals(words[i - 2]) && second.equals(words[i - 1]))
                ans.add(words[i]);
        }
        return ans.toArray(new String[0]);
    }
}
