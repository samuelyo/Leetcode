package com.leetcode.DefangingAnIPAddress;

public class DefangingAnIPAddress {
    public static void main(String[] args) {
        String address = "255.100.50.0";
        String res = defangIPaddr(address);
        System.out.println(res);
    }

    public static String defangIPaddr(String address) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chs = address.toCharArray();
        for (char ch : chs) {
            if (ch == '.') {
                stringBuilder.append('[');
                stringBuilder.append(ch);
                stringBuilder.append(']');
            } else {
                stringBuilder.append(ch);

            }
        }
        return stringBuilder.toString();
    }
}
