package com.practice.basics;

public class BinarySearch {

	// Input: 0, 1, 2, 3, 4, 5, 6, 7, 8
	// search: 4
	public static void main(String[] args) {
		int arr[] = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
		int low = 0;
		int high = arr.length - 1;
		int search = 7;

		int searchIndex = binarySearch(low, high, arr, search);
		System.out.println("Search Index: " + searchIndex);
	}

	private static int binarySearch(int low, int high, int[] arr, int search) {
		if (low > high) {
			return -1;
		}

		int mid = (low + high) / 2;

		if (arr[mid] == search) {
			return mid;
		}

		if (arr[mid] > search) {
			high = mid - 1;
		}

		if (arr[mid] < search) {
			low = low + 1;
		}

		return binarySearch(low, high, arr, search);
	}

}
