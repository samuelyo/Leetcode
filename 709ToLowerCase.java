package com.leetcode.ToLowerCase;

public class ToLowerCase {
    public static void main(String[] args) {
        String str = "Hello";
        System.out.println(toLowerCase(str));
    }

    public static String toLowerCase(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char[] chs = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char ch : chs) {
            if (Character.isUpperCase(ch)) {
                sb.append((char)('a' + (ch - 'A')));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
