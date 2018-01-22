package com.leetcode.BinarySearchTreeIterator;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator3 {

	List<Integer> list;
	
	public BSTIterator3(TreeNode root) {
        
		list = new ArrayList<Integer>();
		inorderTraverse(list, root);
		
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        
    	return list.size() > 0;
    	
    }

    /** @return the next smallest number */
    public int next() {
        
    	int value = list.get(0);
    	list.remove(0);
    	return value;
    }
    
    public void inorderTraverse(List<Integer> list, TreeNode root) {
    	
    	if(root == null) {
    		return;
    	}
    	inorderTraverse(list, root.left);
    	list.add(root.val);
    	inorderTraverse(list, root.right);
    	
    }
}
