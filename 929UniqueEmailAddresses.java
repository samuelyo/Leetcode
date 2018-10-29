package com.leetcode.UniqueEmailAddresses;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        int res = numUniqueEmails(emails);
        System.out.println(res);
    }

    public static int numUniqueEmails(String[] emails) {
        if (emails == null || emails.length == 0) {
            return 0;
        }
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String[] strings = email.split("@");
            String local = strings[0];
            String domain = strings[1];
            StringBuilder sb = new StringBuilder();
            int index = 0;
            while (index < local.length()) {
                if (local.charAt(index) == '.') {
                    index++;
                } else if (local.charAt(index) == '+') {
                    break;
                } else {
                    sb.append(local.charAt(index));
                    index++;
                }
            }
            String temp = sb.toString() + domain;
            set.add(temp);
        }
        return set.size();
    }
}
