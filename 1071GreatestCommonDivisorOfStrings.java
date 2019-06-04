package com.leetcode.GreatestCommonDivisorOfStrings;

public class GreatestCommonDivisorOfStrings {
    public static void main(String[] args) {
        String s1 = "ABCABC";
        String s2 = "ABC";
        String res = gcdOfStrings(s1, s2);
        System.out.println(res);
    }

    public static String gcdOfStrings(String str1, String str2) {
        return GCD(str1, str2);
    }

    public static String GCD(String a, String b) {
        if (a.length() == 0)
            return b;
        if (b.length() == 0)
            return a;
        if (a.equals(b))
            return a;
        if (a.length() > b.length()) {
            for (int i = 0; i < b.length(); i++) {
                if (b.charAt(i) != a.charAt(i)) {
                    return "";
                }
            }
            String temp = a.substring(b.length());
            return GCD(temp, b);
        } else if (b.length() > a.length())
            return GCD(b, a);
        else
            return "";
    }
}
