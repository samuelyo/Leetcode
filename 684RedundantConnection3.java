package com.leetcode.RedundantConnection;

public class RedundantConnection3 {

	public static void main(String[] args) {

		int[][] edges = { { 1, 2 }, { 1, 3 }, { 2, 3 }};
		int[] res = findRedundantConnection(edges);
		System.out.println(res[0] + " " + res[1]);

	}

	public static int[] findRedundantConnection(int[][] edges) {

		int[] parent = new int[20001];
        for(int i=0;i<parent.length;i++){
            parent[i] = i;
        }
        
        for(int[] ele:edges){
            int index1 = findparent(parent,ele[0]);
            int index2 = findparent(parent,ele[1]);
            if(index1==index2){
                return ele;
            }else{
                parent[index1] = index2;
            }
        }
        
        return new int[0];
    }
    
    public static int findparent(int[] parent,int index){
    	
        while(index!=parent[index]){
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
	}

}
