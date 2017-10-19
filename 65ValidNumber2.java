package com.leetcode.ValidNumber;

public class ValidNumber2 {

	public static void main(String[] args) {

		String s = "av";
		boolean res = isNumber(s);
		System.out.println(res);

	}

	// We start with trimming.

	// If we see [0-9] we reset the number flags.
	// We can only see . if we didn't see e or ..
	// We can only see e if we didn't see e but we did see a number. We reset
	// numberAfterE flag.
	// We can only see + and - in the beginning and after an e
	// any other character break the validation.
	// At the and it is only valid if there was at least 1 number and if we did
	// see an e then a number after it as well.
	//
	// So basically the number should match this regular expression:
	//
	// [-+]?(([0-9]+(.[0-9]*)?)|.[0-9]+)(e[-+]?[0-9]+)?

	public static boolean isNumber(String s) {

		s = s.trim();
		if(s.isEmpty()) {
			return false;
		}
		String reg = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?";
		return s.matches(reg);
		
	}

}
