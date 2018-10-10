package com.leetcode.ToLowerCase;

public class ToLowerCase2 {
    public static void main(String[] args) {
        String str = "Hello";
        System.out.println(toLowerCase(str));
    }

    public static String toLowerCase(String str) {
        char[] a = str.toCharArray();
        for (int i = 0; i < a.length; i++)
            if ('A' <= a[i] && a[i] <= 'Z')
                a[i] = (char) (a[i] - 'A' + 'a');
        return new String(a);
    }
}
