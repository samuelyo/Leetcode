package com.leetcode.RepeatedStringMatch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedStringMatch {

	public static void main(String[] args) {

		String A = "baaabbbaba";
		String B = "baaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbaba";
		System.out.println(repeatedStringMatch(A, B));

	}

	public static int repeatedStringMatch(String A, String B) {

		Set<Character> set = new HashSet<Character>();
		for(int i = 0;i<A.length();i++) {
			set.add(A.charAt(i));
		}
		for(int i = 0;i<B.length();i++) {
			if(!set.contains(B.charAt(i))) {
				return -1;
			}
		}
		
		if (A.length() >= B.length()) {
			for (int i = 0; i <= A.length() - B.length(); i++) {
				String cur = A.substring(i, i + B.length());
				if (cur.equals(B)) {
					return 1;
				}
			}
			String ADouble = A + "" + A;
			for (int i = 0; i <= ADouble.length() - B.length(); i++) {
				String cur = ADouble.substring(i, i + B.length());
				if (cur.equals(B)) {
					return 2;
				}
			}
			return -1;
		} else {
			int index = 0;
			List<Integer> starts = new ArrayList<Integer>();
			while (index < A.length()) {
				if (A.charAt(index) == B.charAt(0)) {
					starts.add(index);
				}
				index ++;
			}
			if (starts.size() == 0) {
				return -1;
			}
			for(Integer start : starts) {
				int count = 0;
				int diff = A.length() - start;
				if (!B.substring(0, diff).equals(A.substring(start))) {
					continue;
				} else {
					count++;
					int j = diff;
					boolean isValid = true;
					for (; j + A.length() < B.length(); j += A.length()) {
						String cur = B.substring(j, j + A.length());
						if (!cur.equals(A)) {
							isValid = false;
							break;
						} else {
							count++;
						}
					}
					if(!isValid) {
						continue;
					}
					int lastIndex = 0;
					List<Integer> ends = new ArrayList<Integer>();
					while (lastIndex < A.length()) {
						if (A.charAt(lastIndex) == B.charAt(B.length() - 1)) {
							ends.add(lastIndex);
						}
						lastIndex ++;
					}
					if (ends.size() == 0) {
						continue;
					}
					for(Integer end : ends) {
						if (B.substring(j).equals(A.substring(0, end + 1))) {
							return count + 1;
						}
					}
					
				}
			}
			return -1;
		}
	}
}
