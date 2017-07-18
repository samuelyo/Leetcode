package com.leetcode.ReconstructOriginalDigitsFromEnglish;

public class ReconstructOriginalDigitsFromEnglish2 {

	public static void main(String[] args) {
		
		String s = "fvieowoztneoerfurofothreewozeighttneoerviefuro";
		String res = originalDigits(s);
		System.out.println(res);

	}
	
	public static String originalDigits(String s) {
		
		Integer[] digitsIn = new Integer[10];
		int[] charNum = new int[26];
		for(int i = 0;i<s.length();i++){
			char cur = s.charAt(i);
			charNum[cur - 'a'] ++;
		}
		if(charNum['z' - 'a'] != 0){
			digitsIn[0] = charNum['z' - 'a'];
			charNum['z' - 'a'] = 0;
			charNum['e' - 'a'] -= digitsIn[0];
			charNum['r' - 'a'] -= digitsIn[0];
			charNum['o' - 'a'] -= digitsIn[0];
		}
		if(charNum['w' - 'a'] != 0){
			digitsIn[2] = charNum['w' - 'a'];
			charNum['w' - 'a'] = 0;
			charNum['t' - 'a'] -= digitsIn[2];
			charNum['o' - 'a'] -= digitsIn[2];
		}
		if(charNum['u' - 'a'] != 0){
			digitsIn[4] = charNum['u' - 'a'];
			charNum['u' - 'a'] = 0;
			charNum['f' - 'a'] -= digitsIn[4];
			charNum['o' - 'a'] -= digitsIn[4];
			charNum['r' - 'a'] -= digitsIn[4];
		}
		if(charNum['x' - 'a'] != 0){
			digitsIn[6] = charNum['x' - 'a'];
			charNum['x' - 'a'] = 0;
			charNum['s' - 'a'] -= digitsIn[6];
			charNum['i' - 'a'] -= digitsIn[6];
		}
		if(charNum['g' - 'a'] != 0){
			digitsIn[8] = charNum['g' - 'a'];
			charNum['g' - 'a'] = 0;
			charNum['e' - 'a'] -= digitsIn[8];
			charNum['i' - 'a'] -= digitsIn[8];
			charNum['h' - 'a'] -= digitsIn[8];
			charNum['t' - 'a'] -= digitsIn[8];
		}
		if(charNum['h' - 'a'] != 0){
			digitsIn[3] = charNum['h' - 'a'];
			charNum['h' - 'a'] = 0;
			charNum['t' - 'a'] -= digitsIn[3];
			charNum['r' - 'a'] -= digitsIn[3];
			charNum['e' - 'a'] -= 2 * digitsIn[3];
		}
		if(charNum['o' - 'a'] != 0){
			digitsIn[1] = charNum['o' - 'a'];
			charNum['o' - 'a'] = 0;
			charNum['n' - 'a'] -= digitsIn[1];
			charNum['e' - 'a'] -= digitsIn[1];
		}
		if(charNum['f' - 'a'] != 0){
			digitsIn[5] = charNum['f' - 'a'];
			charNum['f' - 'a'] = 0;
			charNum['i' - 'a'] -= digitsIn[5];
			charNum['v' - 'a'] -= digitsIn[5];
			charNum['e' - 'a'] -= digitsIn[5];
		}
		if(charNum['s' - 'a'] != 0){
			digitsIn[7] = charNum['s' - 'a'];
			charNum['s' - 'a'] = 0;
			charNum['e' - 'a'] -= 2 * digitsIn[7];
			charNum['v' - 'a'] -= digitsIn[7];
			charNum['n' - 'a'] -= digitsIn[7];
		}
		if(charNum['e' - 'a'] != 0){
			digitsIn[9] = charNum['e' - 'a'];
		}
		StringBuilder res = new StringBuilder();
		for(int i = 0;i<10;i++){
			if(digitsIn[i] != null){
				int times = digitsIn[i];
				for(int j = 0;j<times;j++){
					res.append(Integer.toString(i));
				}
			}
		}
		return res.toString();
	}

}
