package com.leetcode.ReverseVowelsOfAString;

public class ReverseVowelsOfAString3 {

	public static void main(String[] args) {
		
		String s = "hello";
		String res = reverseVowels(s);
		System.out.println(res);

	}
			
	 public static String reverseVowels(String s) {
		 
		 char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
		 char[] words = s.toCharArray();
		 int start = 0;
		 int end = s.length() - 1;
		 while(start < end) {
			 while(start < end && start < s.length() && !isInVowels(vowels, words[start])) {
				 start ++;
			 }
			 while(start < end && end >= 0 && !isInVowels(vowels, words[end])) {
				 end --;
			 }
			 char temp = words[start];
			 words[start] = words[end];
			 words[end] = temp;
			 start ++;
			 end --;
		 }
		 return new String(words);
		 
	 }
	 
	 public static boolean isInVowels(char[] vowels, char c) {
		 
		 for(int i = 0;i<vowels.length;i++) {
			 if(c == vowels[i]) {
				 return true;
			 }
		 }
		 return false;
		 
	 }

}
