package com.leetcode.RevealCardsInIncreasingOrder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RevealCardsInIncreasingOrder2 {
    public static void main(String[] args) {
        int[] deck = {2, 3, 5, 7, 11, 13, 17};
        int[] res = deckRevealedIncreasing(deck);
        System.out.println(Arrays.toString(res));
    }

    public static int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) q.add(i);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[q.poll()] = deck[i];
            q.add(q.poll());
        }
        return res;
    }
}
