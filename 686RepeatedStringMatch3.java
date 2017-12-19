package com.leetcode.RepeatedStringMatch;

public class RepeatedStringMatch3 {

	public static void main(String[] args) {

//		"abcabcabcabc"
//		"abac"
		
		String A = "abcabcabcabc";
		String B = "abac";
//		String A = "baaabbbaba";
//		String B = "baaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbaba";
		System.out.println(repeatedStringMatch(A, B));

	}

	public static int repeatedStringMatch(String A, String B) {
        		
		int times = 0;
		StringBuilder sb = new StringBuilder();
		while(sb.length() <= 2 * A.length() + B.length()) {
			sb.append(A);
			times ++;
			if(sb.toString().contains(B)) {
				break;
			}
		}
		return sb.toString().contains(B) ? times : -1;
		
    }
	
}
