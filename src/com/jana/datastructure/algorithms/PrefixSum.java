package com.jana.datastructure.algorithms;

import java.util.HashMap;
import java.util.Map;

public class PrefixSum {

	public static void main(String[] args) {
//		Range sum / cumulative sum / subarray sum

//		Range Sum Query
//		Array: [1, 2, 3, 4, 5]
//		Find sum from index 1 to 3.
		int[] arr = { 1, 2, 4, 6, 3, 3, 5, 5 };
		int left = 1, right = 3;

		System.out.println("Range Sum of %d to %d: ".formatted(left, right) + rangeSum(arr, left, right));

//		Subarray Sum Equals K
		System.out.println("Subarray Sum Equals K: " + subarraySum(arr, 6));

//		Find Equilibrium Index
//		goal is to find an index in an array such that the sum of elements at lower indices 
//		is equal to the sum of elements at higher indices.
		System.out.println("Find Equilibrium Index: " + equilibriumIndex(arr));

	}

	static int rangeSum(int arr[], int left, int right) {
		int[] prefix = new int[arr.length + 1];

		for (int i = 0; i < arr.length; i++) {
			prefix[i + 1] = prefix[i] + arr[i];
		}
		return prefix[right + 1] - prefix[left];
	}

	static int subarraySum(int[] arr, int k) {

		Map<Integer, Integer> map = new HashMap<>();

		int count = 0;
		int prefixSum = 0;
		map.put(0, 1);

		for (int a : arr) {
			prefixSum += a;

			count += map.getOrDefault(prefixSum - k, 0);

			map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
		}
		return count;
	}

	static int equilibriumIndex(int[] arr) {
		int total = 0;
		for (int a : arr) {
			total += a;
		}

		int leftSum = 0;

		for (int i = 0; i < arr.length; i++) {
			int rightSum = total - leftSum - arr[i];
			if (leftSum == rightSum)
				return i;

			leftSum += arr[i];
		}
		return -1;
	}

}
