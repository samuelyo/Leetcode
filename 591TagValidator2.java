package com.leetcode.TagValidator;

public class TagValidator2 {

	public static void main(String[] args) {

		String code = "<DIV>This is the first line <![CDATA[<div>]]></DIV>";
		System.out.println(isValid(code));

	}

	public static boolean isValid(String code) {

		if (code.equals("t"))
			return false;
		code = code.replaceAll("<!\\[CDATA\\[.*?\\]\\]>", "c");

		String prev = "";
		while (!code.equals(prev)) {
			prev = code;
			code = code.replaceAll("<([A-Z]{1,9})>[^<]*</\\1>", "t");
		}

		return code.equals("t");
	}

}
