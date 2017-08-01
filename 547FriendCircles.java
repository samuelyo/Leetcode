package com.leetcode.FriendCircles;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FriendCircles {

	public static void main(String[] args) {
		
		int[][] M = {{1,1,0},{1,1,0},{0,0,1}};
		System.out.println(findCircleNum(M));

	}
	
	public static int findCircleNum(int[][] M) {
	
		if(M == null || M.length == 0 || M[0].length == 0){
			return 0;
		}
		int n = M.length;
		List<Integer>[] friend = new List[n];
		for(int i = 0;i<n;i++){
			for(int j = i+1;j<n;j++){
				if(M[i][j] == 1){
					if(friend[i] == null){
						friend[i] = new ArrayList<Integer>();
					}
					if(friend[j] == null){
						friend[j] = new ArrayList<Integer>();
					}
					friend[i].add(j);
					friend[j].add(i);
				}
			}
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visit = new boolean[n];
		int count = 0;
		for(int i = 0;i<n;i++){
			if(visit[i] == false){
				queue.add(i);
				while (!queue.isEmpty()) {
					Integer cur = queue.poll();
					List<Integer> next = friend[cur];
					if(next != null){
						for (int j = 0; j < next.size(); j++) {
							Integer curr = next.get(j);
							if (visit[curr] == false && !queue.contains(cur)) {
								queue.add(curr);
								visit[curr] = true;
							}
						}
					}
				}
				count ++;
			}
			
		}
		return count;
	}

}
