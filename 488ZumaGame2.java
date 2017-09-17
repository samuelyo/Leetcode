package com.leetcode.ZumaGame;

public class ZumaGame2 {

	public static void main(String[] args) {

		String board = "G";
		String hand = "GGGGG";
		System.out.println(findMinStep(board, hand));

	}
	
	public static int findMinStep(String board, String hand) {
		
		int res = 6;
		int[] map = new int[26];
		for(int i = 0;i<hand.length();i++){
			map[hand.charAt(i) - 'A'] ++;
		}
		res = findMinStepBackTrack(board, map);
		return res == 6 ? -1 : res;
		
	}
	
	public static int findMinStepBackTrack(String board, int[] map) {
		
		int res = 6;
		board = deletedul(board);
		if(board.length() == 0){
			return 0;
		}
		int index = 0;
		while(index < board.length()){
			int cur = index;
			while(cur < board.length() && board.charAt(cur) == board.charAt(index)) {
				cur ++;
			}
			int need = 3 - (cur - index);
			if(map[board.charAt(index) - 'A'] >= need) {
				map[board.charAt(index) - 'A'] -= need;
				res = Math.min(res, need + findMinStepBackTrack(board.substring(0, index) + board.substring(cur), map));
				map[board.charAt(index) - 'A'] += need;
			}
			index = cur;
		}
		return res;
		
	}
	
	public static String deletedul(String board) {
		
		int index = 0;
		while(index < board.length()){
			int cur = index;
			while(cur < board.length() && board.charAt(cur) == board.charAt(index)) {
				cur ++;
			}
			if(cur - index >= 3){
				return deletedul(board.substring(0, index) + board.substring(cur));
			}
			index = cur;
		}
		return board;
		
	}

}
