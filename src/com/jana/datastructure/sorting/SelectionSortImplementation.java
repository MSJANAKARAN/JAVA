package com.jana.datastructure.sorting;

public class SelectionSortImplementation {
	static void print(int[] arr) {
		System.out.print("Array : ");
		for (int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
//		It divides the array into a sorted and an unsorted region. 
//		In every iteration, it selects the absolute smallest element from the unsorted 
//		region and swaps it with the first element of the unsorted region.
//		Best Case: O(N²) Average Case: O(N²) Worst Case: O(N²)
//		Space Complexity: O(1) auxiliary
		int arr[] = new int[] { 9, 4, 8, 7, 1, 0, 6, 2, 3 };
		print(arr);
		selectionSort(arr);
		print(arr);
//		Input Array: [5, 2, 8, 1, 3]
//		Iteration 1: Find min in [5, 2, 8, 1, 3] → 1. Swap with index 0.
//			[1, 2, 8, 5, 3]
//		Iteration 2: Find min in [2, 8, 5, 3] → 2. Swap with index 1 (no change).
//			[1, 2, 8, 5, 3]
//		Iteration 3: Find min in [8, 5, 3] → 3. Swap with index 2.
//			[1, 2, 3, 5, 8]
//		Iteration 4: Find min in [5, 8] → 5. Swap with index 3 (no change).
//			[1, 2, 3, 5, 8]
//		Final Output: [1, 2, 3, 5, 8]
	}

	private static void selectionSort(int[] arr) {
//		Look for code tracking a minIndex or maxIndex
		int n = arr.length;

		for (int i = 0; i < n - 1; i++) {
			// Assume current index holds the minimum
			int minIdx = i;
			// Find the actual minimum in the remaining unsorted array
			for (int j = i; j < n; j++) {
				if (arr[j] < arr[minIdx]) {
					minIdx = j;
				}
			}
			// Swap the found minimum with the first unsorted element
			int temp = arr[minIdx];
			arr[minIdx] = arr[i];
			arr[i] = temp;
		}
	}

}
