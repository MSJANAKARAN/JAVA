package com.jana.datastructure.algorithms;

import java.util.HashSet;

public class SlidingWindow {

	public static void main(String[] args) {
//		substring / subarray + continuous + longest/shortest/count
//		Pattern:
//			Add right
//			Remove left

//		Maximum Sum Subarray of Size K.
		int[] arr = { 1, 5, 4, 2, 9, 9, 9 };
		System.out.println("Maximum Sum Subarray of Size K: " + maxSubarraySum(arr, 3));
		System.out.println("Maximum Sum Distinct Subarray of Size K: " + maxDistinctSubarraySum(arr, 3));

//		Longest Substring Without Repeating Characters
		System.out.println("Longest Substring Without Repeating Characters: " + longestSubstringLength("mahandra"));

//		Minimum Size Subarray Sum
//		Find smallest continuous subarray whose sum ≥ target.
		System.out.println("Minimum Size Subarray Sum: " + minSubarrayLength(arr, 28));

	}

	static int maxSubarraySum(int[] arr, int k) {
		int windowSum = 0;
		for (int i = 0; i < k; i++) {
			windowSum += arr[i];
		}
		int max = windowSum;
		for (int i = k; i < arr.length; i++) {
			windowSum += arr[i];
			windowSum -= arr[i - k];

			max = Math.max(windowSum, max);
		}
		return max;
	}

	static int maxDistinctSubarraySum(int[] arr, int k) {
		HashSet<Integer> set = new HashSet<>();
		int windowSum = 0;
		int max = 0;
		int left = 0;
		for (int right = 0; right < arr.length; right++) {
			// 1. If we see a duplicate, shrink the window from the left
			// until the duplicate is completely removed from the Set
			while (set.contains(arr[right])) {
				windowSum -= arr[left];
				set.remove(arr[left]);
				left++;
			}
			// 2. Now it's safe to add the current element

			windowSum += arr[right];
			set.add(arr[right]);
			// 3. If our distinct window hits size K, record the max
			if (right - left + 1 == k) {
				max = Math.max(windowSum, max);
				// Slide the left edge forward by 1 to prepare for the next iteration
				windowSum -= arr[left];
				set.remove(arr[left]);
				left++;
			}
		}
		return max;
	}

	static int longestSubstringLength(String s) {
		HashSet<Character> set = new HashSet<>();

		int left = 0;
		int max = 0;

		for (int right = 0; right < s.length(); right++) {
			while (set.contains(s.charAt(right))) {
				set.remove(s.charAt(left));
				left++;
			}

			set.add(s.charAt(right));

			max = Math.max(max, right - left + 1);
		}

		return max;
	}

	static int minSubarrayLength(int[] arr, int target) {
		int min = Integer.MAX_VALUE;

		int left = 0;
		int sum = 0;

		for (int right = 0; right < arr.length; right++) {
			sum += arr[right];

			while (sum >= target) {
				min = Math.min(min, right - left + 1);
				sum -= arr[left];
				left++;
			}
		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}
}
