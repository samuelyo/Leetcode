package com.leetcode.CamelcaseMatching;

import java.util.ArrayList;
import java.util.List;

public class CamelcaseMatching2 {
    public static void main(String[] args) {
        String[] queries = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        String pattern = "FoBa";
        List<Boolean> res = camelMatch(queries, pattern);
        for (Boolean b : res) {
            System.out.print(b + " ");
        }
    }

    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        String newPattern = "[a-z]*" + String.join("[a-z]*", pattern.split("")) + "[a-z]*";
        List<Boolean> ans = new ArrayList<>();
        for (String q : queries) {
            ans.add(q.matches(newPattern));
        }
        return ans;
    }
}
