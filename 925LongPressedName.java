package com.leetcode.LongPressedName;

public class LongPressedName {
    public static void main(String[] args) {
        String name = "alex";
        String typed = "aaleex";
        System.out.println(isLongPressedName(name, typed));
    }

    public static boolean isLongPressedName(String name, String typed) {
        if (name == null || typed == null) {
            return false;
        }
        int index1 = 0;
        int index2 = 0;
        char pre1 = name.charAt(index1);
        char pre2 = typed.charAt(index2);
        int count1 = 0;
        int count2 = 0;
        while (index1 < name.length() && index2 < typed.length()) {
            while (index1 < name.length() && name.charAt(index1) == pre1) {
                index1++;
                count1++;
            }
            while (index2 < typed.length() && typed.charAt(index2) == pre2) {
                index2++;
                count2++;
            }
            if (pre1 != pre2 || count1 > count2) {
                return false;
            }
            if(index1 < name.length()) {
                pre1 = name.charAt(index1);
            }
            if(index2 < typed.length()) {
                pre2 = typed.charAt(index2);
            }
            count1 = 0;
            count2 = 0;
        }
        return index1 == name.length() && index2 == typed.length();
    }
}
