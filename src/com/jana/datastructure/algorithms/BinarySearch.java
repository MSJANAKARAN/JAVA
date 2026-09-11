package com.jana.datastructure.algorithms;

public class BinarySearch {

	public static void main(String[] args) {
//		Sorted array / monotonic condition / search space

//		Binary Search
		int[] arr = { 2, 2, 3, 4, 6, 6, 7, 12 };
		System.out.println("Binary Search index: " + binarySearch(arr, 6));

//		First Occurrence
		System.out.println("First Occurrence index: " + firstOccurrence(arr, 6));

//		Search in Rotated Sorted Array
		int[] arr1 = { 3, 4, 5, 6, 6, 7, 12, 1, 2 };
		System.out.println("Search in Rotated Sorted Array index: " + searchRotated(arr1, 6));

	}

	static int binarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}

	static int firstOccurrence(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		int answer = -1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == target) {
//				Don't stop when found; continue searching left.
				answer = mid;
				right = mid - 1;
			} else if (arr[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return answer;
	}

	static int searchRotated(int arr[], int target) {
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == target) {
				return mid;
			}
//			if the left half is sorted Otherwise, the right half must be sorted
			if (arr[left] <= arr[mid]) {
				if (arr[left] <= target && target < arr[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (arr[mid] < target && target <= arr[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}

		}
		return -1;
	}
}
