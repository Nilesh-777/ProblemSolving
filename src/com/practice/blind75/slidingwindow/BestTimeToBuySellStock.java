package com.practice.blind75.slidingwindow;

import java.util.ArrayList;
import java.util.List;

/**
 * https://neetcode.io/problems/buy-and-sell-crypto/question?list=blind75 Input:
 * prices = [10,1,5,6,7,1] Output: 6
 */
public class BestTimeToBuySellStock {

	public static void main(String[] args) {
		List<Integer> li = List.of(10, 1, 5, 6, 7, 1);
		System.out.println("Max Profit: " + maxProfit(li));
	}

	private static int maxProfit(final List<Integer> li) {
		if (li == null) {
			return 0;
		}

		if (li.size() <= 1) {
			return 0;
		}

		int l = 0;
		int r = 1;
		int mp = 0;

		while (r < li.size()) {
			if (li.get(l) < li.get(r)) {
				mp = Math.max(mp, li.get(r) - li.get(l));
			} else {
				l = r;
			}

			r++;
		}

		return mp;
	}

}
