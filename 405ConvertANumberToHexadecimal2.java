package com.leetcode.ConvertANumberToHexadecimal;

public class ConvertANumberToHexadecimal2 {

	public static void main(String[] args) {

		int num = -26;
		String res = toHex(num);
		System.out.println(res);

	}

	public static char[] map = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	public static String toHex(int num) {

		if (num == 0)
			return "0";
		String result = "";
		while (num != 0) {
			result = map[(num & 15)] + result;
			num = (num >>> 4);
		}
		return result;

	}
}
