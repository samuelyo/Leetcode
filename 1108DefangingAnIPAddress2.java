package com.leetcode.DefangingAnIPAddress;

public class DefangingAnIPAddress2 {
    public static void main(String[] args) {
        String address = "255.100.50.0";
        String res = defangIPaddr(address);
        System.out.println(res);
    }

    public static String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}
