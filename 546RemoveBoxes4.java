package com.leetcode.RemoveBoxes;

public class RemoveBoxes4 {

	public static void main(String[] args) {

		int[] boxes = { 1, 3, 2, 2, 2, 3, 4, 3, 1 };
		System.out.println(removeBoxes(boxes));

	}

	public static int removeBoxes(int[] boxes) {

		int res = 0;
		int index = 0;
		while(index < boxes.length) {
			int cur = index;
			while(cur < boxes.length && boxes[cur] == boxes[index]) {
				cur ++;
			}
			int[] temp = new int[boxes.length - cur + index];
			int j = 0;
			for(int i = 0;i<boxes.length;i++){
				if(i >= index && i < cur){
					continue;
				}
				temp[j] = boxes[i];
				j ++;
			}
			res = Math.max(res, (cur - index) * (cur - index) + removeBoxes(temp));
			index = cur;
		}
		return res;

	}

}
