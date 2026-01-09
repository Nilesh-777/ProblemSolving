package com.practice.blind75.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * https://neetcode.io/problems/three-integer-sum/question
 */
public class ThreeSumHashMap1 {

	public static void main(String[] args) {
		System.out.println(threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
	}

 	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		// create frequency map
		Map<Integer, Integer> frequencyMapOrig = Arrays.stream(nums).boxed()
				.collect(Collectors.toMap(key -> key, val -> 1, (oldVal, newVal) -> oldVal + newVal));
		// iterate with 2 pointers - i, j
		// If count >= 1 ---> decrement the count
		// If count == 0 --> skip that number
		// check for 3rd in hashmap key, if present & occurrence >= 1, construct desired
		// list & decrement count
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int thirdNum = -(nums[i] + nums[j]);
				
				Map<Integer,Integer> frequencyMap = new HashMap<Integer, Integer>(frequencyMapOrig);
				
				if (frequencyMap.containsKey(thirdNum)) {				

					{
					int iFreq = frequencyMap.getOrDefault(nums[i], 0);
					if(iFreq <= 0) {
						continue;
					}
					frequencyMap.put(nums[i], iFreq - 1);
					}

					{
					int jFreq = frequencyMap.getOrDefault(nums[j], 0);
					if(jFreq <= 0) {
						continue;
					}
					frequencyMap.put(nums[j], jFreq - 1);
					}

					{
					int thirdNumFreq = frequencyMap.getOrDefault(thirdNum, 0);
					if(thirdNumFreq <= 0) {
						continue;
					}
					frequencyMap.put(thirdNum, thirdNumFreq - 1);
					}
					add(list, Arrays.asList(nums[i], nums[j], thirdNum));					
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

}
