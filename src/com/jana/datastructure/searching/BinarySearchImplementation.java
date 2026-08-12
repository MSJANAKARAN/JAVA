package com.jana.datastructure.searching;

import java.util.Arrays;

public class BinarySearchImplementation {

	static int binarySearch(int[] arr, int x) {

		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == x) {
				return mid;
			} else if (arr[mid] > x) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}

	static boolean isBinarySearch(int[] arr, int x) {

		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == x) {
				return true;
			} else if (arr[mid] > x) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return false;
	}

	static int binarySearchRecursive(int[] arr, int x, int left, int right) {
		if (left >= right) {
			return -1;
		}
		int mid = left + (right - left) / 2;
		if (arr[mid] == x) {
			return mid;
		} else if (arr[mid] > x) {
			return binarySearchRecursive(arr, x, left, mid - 1);
		}
		return binarySearchRecursive(arr, x, mid + 1, right);

	}

	static boolean isBinarySearchRecursive(int[] arr, int x, int left, int right) {
		if (left >= right) {
			return false;
		}
		int mid = left + (right - left) / 2;
		if (arr[mid] == x) {
			return true;
		} else if (arr[mid] > x) {
			return isBinarySearchRecursive(arr, x, left, mid);
		}

		return isBinarySearchRecursive(arr, x, mid + 1, right);

	}

	public static void main(String[] args) {

		int arr[] = new int[] { 1, 3, 4, 5, 6, 7, 8, 9 };

//		Java inbuilt
		System.out.println("Element present at index: " + Arrays.binarySearch(arr, 5));
//		Iterative
		System.out.println("Element present at index: " + binarySearch(arr, 3));

		System.out.println("Element present: " + isBinarySearch(arr, 3));
//		Recursive
		System.out.println("Element present at index: " + binarySearchRecursive(arr, 2, 0, arr.length - 1));

		System.out.println("Element present: " + isBinarySearchRecursive(arr, 2, 0, arr.length - 1));

//		Binary Search is an elite searching algorithm designed for sorted collections. 
//		It works by repeatedly dividing the search interval in half, reducing the time complexity to a fraction of a linear scan.

	}

//| Attribute             | Complexity     | Notes                                                              |
//| :-------------------- | :------------- | :----------------------------------------------------------------- |
//| **Best Case Time**    | O(1)           | Target sits perfectly at the very first calculated midpoint.       |
//| **Average Case Time** | O(log n)       | Search space drops exponentially (halved at every single step).     |
//| **Worst Case Time**   | O(log n)       | Target is at the extreme boundaries or missing from the array.     |
//| **Space (Iterative)** | O(1)           | Constant memory allocation using simple boundary pointers.         |
//| **Space (Recursive)** | O(log n)       | Accumulates frames on the system call stack for every split depth. |

//	Edge Cases
//	Duplicate Elements: Standard Binary Search does not guarantee which index it returns if duplicates exist. 
//	It returns the first one it runs into. To find the absolute first or absolute last occurrence, 
//	you must modify the algorithm to continue searching even after finding a match.
//	Unsorted Input: If the array is not sorted, the elimination logic breaks completely, 
//	causing the search to return incorrect results.

}
