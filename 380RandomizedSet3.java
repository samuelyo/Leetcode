package com.leetcode.InsertDeleteGetRandomO1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class RandomizedSet3 {

	Set<Integer> set;
	/** Initialize your data structure here. */
    public RandomizedSet3() {
        
    	set = new HashSet<Integer>();
    	
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        
    	return set.add(val);
    	
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        
    	return set.remove(val);
    	
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        
    	int random = new Random().nextInt(set.size());
    	Iterator<Integer> iterator = set.iterator();
    	Integer res = null;
    	while(random >= 0 && iterator.hasNext()) {
    		res = iterator.next();
    		random --;
    	}
    	return res;
    	
    }
}
