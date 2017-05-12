package com.leetcode.validanagram;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ValidAnagram3 {

	public static void main(String[] args) {
		
		String s = "aa";
		String t = "bb";
		System.out.println(isAnagram(s, t));
	}
	
	public static boolean isAnagram(String s,String t){
		
		int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++){
        	alphabet[s.charAt(i) - 'a']++;
        }	
        for (int i = 0; i < t.length(); i++){
        	alphabet[t.charAt(i) - 'a']--;
        }
        for (int i : alphabet) {
        	if (i != 0) return false;
        }
        return true;
	}
}
