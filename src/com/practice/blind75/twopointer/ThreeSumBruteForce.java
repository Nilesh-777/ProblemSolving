package com.practice.blind75.twopointer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://neetcode.io/problems/three-integer-sum/question
 */
public class ThreeSumBruteForce {
	
	public static void main(String[] args) {
		System.out.println(threeSum(new int[] {-1,0,1,2,-1,-4}));
	}

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        if(nums.length < 3) {
            return list;
        }
        
        if(nums.length == 3) {
            if(sumZero(nums[0], nums[1], nums[2])) {
                add(list, createList(nums[0], nums[1], nums[2]));
            }
        }

        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                for(int k = j+1; k < nums.length; k++) {
                    if(sumZero(nums[i], nums[j], nums[k])) {
                        add(list, createList(nums[i], nums[j], nums[k]));
                    }                    
                }
            }
        }

        return list;
    }

    private static void add(List<List<Integer>> list, List<Integer> li) {
        if(!listContains(list, li)) {
            list.add(li);
        }
    }

    private static boolean listContains(List<List<Integer>> list, List<Integer> li) {
        return list.stream()
                    .anyMatch(listElem -> equals(listElem, li));
    }

    private static boolean equals(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set1 = list1.stream().collect(Collectors.toSet());
        Set<Integer> set2 = list2.stream().collect(Collectors.toSet());
        return set1.equals(set2);
    }

    private static boolean sumZero(int a, int b, int c) {
        return (a+b+c) == 0;
    }

    private static List<Integer> createList(int a, int b, int c) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(a);
        list.add(b);
        list.add(c);
        return list;
    }

}
