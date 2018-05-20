package com.leetcode.PushDominoes;

public class PushDominoes {

	public static void main(String[] args) {

//		String dominoes = ".L.R...LR..L..";
		String dominoes = "RR.L";
		String res = pushDominoes(dominoes);
		System.out.println(res);

	}

	public static String pushDominoes(String dominoes) {
		
		if(dominoes == null || dominoes.length() == 0) {
			return "";
		}
		char[] chs = dominoes.toCharArray();
		Character pre = null;
		int index = 0;
		while(index < chs.length) {
			char cur = chs[index];
			if(cur != '.') {
				if(pre == null) {
					if(cur == 'L') {
						for(int j = 0;j<index;j++) {
							chs[j] = 'L';
						}
					}
					pre = cur;
				}else {
					if(pre == cur) {
						if(pre == 'L') {
							int temp = index - 1;
							while(temp >= 0 && chs[temp] == '.') {
								chs[temp] = 'L';
								temp --;
							}
						}else {
							int temp = index - 1;
							while(temp >= 0 && chs[temp] == '.') {
								chs[temp] = 'R';
								temp --;
							}
						}
					} else {
						if(pre == 'R' && cur == 'L') {
							int count = 0;
							int temp = index - 1;
							while(temp >= 0 && chs[temp] == '.') {
								count ++;
								temp --;
							}
							int size = count;
							if(count % 2 == 0) {
								temp = index - 1;
								while(temp >= 0 && chs[temp] == '.') {
									if(count > size / 2) {
										chs[temp] = 'L';
									} else {
										chs[temp] = 'R';
									}
									temp --;
									count --;
								}
							}else {
								temp = index - 1;
								while(temp >= 0 && chs[temp] == '.') {
									if(count > size / 2 + 1) {
										chs[temp] = 'L';
									} else if(count < size / 2 + 1){
										chs[temp] = 'R';
									}
									temp --;
									count --;
								}
							}
							pre = cur;
						}else {
							pre = cur;
						}
					}
				}
			}
			index ++;
		}
		if(pre != null && pre == 'R') {
			int temp = chs.length - 1;
			while(temp >= 0 && chs[temp] == '.') {
				chs[temp] = 'R';
				temp --;
			}
		}
		return new String(chs);
	}

}
