package com.leetcode.ShiftingLetters;

public class ShiftingLetters {

	public static void main(String[] args) {

		String S = "abc";
		int[] shifts = { 3, 5, 9 };
		System.out.println(shiftingLetters(S, shifts));
	}

	public static String shiftingLetters(String S, int[] shifts) {

		if (shifts == null || shifts.length == 0) {
			return S;
		}
		char[] chs = S.toCharArray();
		long[] times = new long[chs.length];
		times[times.length - 1] = shifts[shifts.length - 1];
		for (int i = times.length - 2; i >= 0; i--) {
			times[i] = times[i + 1] + shifts[i];
		}
		for (int i = 0; i < chs.length; i++) {
			long time = times[i] % 26;
			char cur = chs[i];
			cur += time;
			if (cur > 'z') {
				cur -= 26;
			}
			chs[i] = (char) cur;
		}
		return new String(chs);
	}

}
