package com.practice.numbers;

import java.util.HashSet;
import java.util.Set;

/**
 * https://neetcode.io/problems/longest-consecutive-sequence/question
 */
public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		System.out.println(longestConsecutive(new int[] {2,20,4,10,3,4,5}));
	}

    public static int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<Integer>();

        for (int num: nums) {
            set.add(num);
        }

        int maxSequence = 1;
        for(Integer num: set) {
            int maxSeq = findMaxSequence(num, set);
            if (maxSeq > maxSequence) {
                maxSequence = maxSeq;
            }
        }

        return maxSequence;
    }

    private static int findMaxSequence(Integer initial, Set<Integer> set) {
        int maxSeq = 1;
        
        // initial + 1 -> contains -> maxSeq = 2
        // initial + 2 -> contains -> maxSeq = 3
        // initial + 3 -> contains no -> return maxSeq
        int temp = 1;
        while(true) {
            int next = initial + temp;
            if(set.contains(next)) {
                maxSeq = maxSeq + 1;
            } else {
                break;
            }
            temp++;
        }

        return maxSeq;
    }

}
