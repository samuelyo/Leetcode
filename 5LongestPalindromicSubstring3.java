package com.leetcode.LongestPalindromicSubstring;

public class LongestPalindromicSubstring3 {

	public static void main(String[] args) {

		String s = "babad";
		System.out.println(longestPalindrome(s));

	}

	public static String longestPalindrome(String s) {
		if (s == null || s.length() < 2) {
            return s;
        }
        char[] c = s.toCharArray();
        boolean[][] isPalindrome = new boolean[c.length][c.length];
        int start = 0;
        int end = 0;
        int counter = 0;
        int preCounter = 0;

        // basic case for only one character
        for (int i = 0; i < isPalindrome.length; i++) {
            isPalindrome[i][i] = true;
            start = i;
            end = i;
        }

        // basic case for only two characters
        for (int i = 0; i < isPalindrome.length - 1; i++) {
            if (c[i] == c[i + 1]) {
                isPalindrome[i][i + 1] = true;
                start = i;
                end = i + 1;
            } else {
                isPalindrome[i][i + 1] = false;
            }
        }
        
        // for substring from index a to b, i == b - a
        for (int i = 2; i < isPalindrome.length; i++) {
            counter = 0; // uesd for check is no new palindrome for a longer substring for better performance
            // j is the starting point of a substring
            for (int j = 0; j < isPalindrome.length -i; j++) {
                int index = j + i;
                // check is 2 characters shorter substring is palindrome and if character on two ends is equal
                if (isPalindrome[j + 1][index - 1] && c[j] == c[index]) {
                    isPalindrome[j][index] = true;
                    counter++;
                    start = j;
                    end = index;
                } else {
                    isPalindrome[j][index] = false;
                }
            }
            if (counter == 0 && preCounter == 0) {
                break;
            }
            preCounter = counter;
        }
        
        return s.substring(start, end + 1);
	}
}
