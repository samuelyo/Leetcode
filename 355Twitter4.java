package com.leetcode.Twitter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Twitter4 {

	public Map<Integer, List<Integer>> follow;
	public List<Tweet> tweets;
	
	 /** Initialize your data structure here. */
    public Twitter4() {
        
    	follow = new HashMap<Integer, List<Integer>>();
    	tweets = new ArrayList<Tweet>();
    	
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        
    	Tweet cur = new Tweet(userId, tweetId);
    	tweets.add(cur);
    	
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        
    	List<Integer> res = new ArrayList<Integer>();
    	List<Integer> follows = follow.get(userId);
    	int count = 0;
    	for(int i = tweets.size() - 1;i>=0;i--) {
    		if(count == 10) {
    			break;
    		}
    		Tweet cur = tweets.get(i);
    		if(cur.userId == userId || (follows != null && follows.contains(cur.userId))) {
    			res.add(cur.tweetId);
    			count ++;
    		}
    	}
    	return res;
    	
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        
    	List<Integer> follows = follow.get(followerId);
    	if(follows == null) {
    		follows = new ArrayList<Integer>();
    	}
    	if(!follows.contains(followeeId)) {
    		follows.add(followeeId);
    	}
    	follow.put(followerId, follows);
    	
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        
    	List<Integer> follows = follow.get(followerId);
    	if(follows != null && follows.contains(followeeId)) {
    		follows.remove(new Integer(followeeId));
    	}
    	
    }
    
}
