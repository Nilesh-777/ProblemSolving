package com.practice.uncategorised;

// Write logic for these 2 operations.
// addInteger(int a) — adds the integer to a collection,
// findMedian() — returns the median when the collection is sorted.
// If the size of the collection is even then return the avg of the 2 median integers.
// Both of these operations can be performed multiple times.

import java.util.PriorityQueue;
import java.util.Queue;

// Is below flow in acccordance with above problem statement?
// addInteger() -> 2, 3, 1
// findMedian() -> 2
// addInteger() -> 4
// findMedian() -> 2
public class AddIntegerFindMedian {

    // Approach#1:
    // list
    // addInteger -> add to list
    // findMedian -> sort list & find out median
    // Time complexity: O(1)
    // findMedian: O(n)

    // Improvement:
    // insertion: O(log n)
    // findMedian: O(1)

    private final static Queue<Integer> MIN_HEAP = new PriorityQueue<>(Integer::compareTo);
    private final static Queue<Integer> MAX_HEAP = new PriorityQueue<>((a, b) -> b.compareTo(a));

    //  Approach#2: Pseudo code written in adjacent file
    public static void main(final String[] args) {
        addInteger(5);
        addInteger(2);
        addInteger(8);
        System.out.println(findMedian());
        addInteger(1);
        System.out.println(findMedian());
    }

    private static void addInteger(final Integer i) {
        if (MAX_HEAP.isEmpty()) {
            MAX_HEAP.add(i);
        } else if (i < MAX_HEAP.peek()) {
            MAX_HEAP.add(i);
        } else {
            MIN_HEAP.add(i);
        }

        rebalance(i);
    }

    private static void rebalance(final Integer i) {
        if (Math.abs(MAX_HEAP.size() - MIN_HEAP.size()) < 2) {
            return;
        }

        if (MAX_HEAP.size() > MIN_HEAP.size()) {
            Integer value = MAX_HEAP.poll();
            MIN_HEAP.add(value);
        } else if (MIN_HEAP.size() > MAX_HEAP.size()) {
            Integer value = MIN_HEAP.poll();
            MIN_HEAP.add(value);
        }

    }

    private static Integer findMedian() {
        if (MAX_HEAP.size() > MIN_HEAP.size()) {
            return MAX_HEAP.peek();
        } else if (MIN_HEAP.size() > MAX_HEAP.size()) {
            return MIN_HEAP.peek();
        } else {
            return (MIN_HEAP.peek() + MAX_HEAP.peek()) / 2;
        }
    }

}
