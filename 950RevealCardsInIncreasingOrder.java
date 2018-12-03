package com.leetcode.RevealCardsInIncreasingOrder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RevealCardsInIncreasingOrder {
    public static void main(String[] args) {
        int[] deck = {2, 3, 5, 7, 11, 13, 17};
        int[] res = deckRevealedIncreasing(deck);
        System.out.println(Arrays.toString(res));
    }

    public static int[] deckRevealedIncreasing(int[] deck) {
        int[] res = new int[deck.length];
        Arrays.sort(deck);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < deck.length; i++) {
            queue.offer(i);
        }
        int index = queue.poll();
        for (int i = 0; i < deck.length; i++) {
            res[index] = deck[i];
            if (i < deck.length - 1) {
                queue.offer(queue.poll());
                index = queue.poll();
            }
        }
        return res;
    }
}
