package com.jana.datastructure.sorting;

public class MergeSortImplementation {

	static void mergeSort(int[] arr, int start, int end) {
		if (start >= end) {
			return;
		}
		int mid = start + (end - start) / 2;

		mergeSort(arr, start, mid);

		mergeSort(arr, mid + 1, end);

		merge(arr, start, mid, end);
//		print(arr);

	}

	static void merge(int arr[], int start, int mid, int end) {

		int L[] = new int[mid - start + 1];
		int R[] = new int[end - mid];

		for (int i = 0; i < L.length; i++) {
			L[i] = arr[start + i];
		}
		for (int i = 0; i < R.length; i++) {
			R[i] = arr[mid + 1 + i];
		}

		int i = 0;
		int j = 0;
		int k = start;
		while (R.length > j && L.length > i) {
			if (L[i] <= R[j]) {
				arr[k++] = L[i++];
			} else {
				arr[k++] = R[j++];
			}
		}
		while (L.length > i) {
			arr[k++] = L[i++];
		}
		while (R.length > j) {
			arr[k++] = R[j++];
		}
		
	}

	static void print(int[] arr) {
		System.out.print("Array : ");
		for (int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
//		Merge sort is a popular sorting algorithm follows the Divide and Conquer approach.
//		It works by recursively dividing the input array into two halves, recursively 
//		sorting the two halves and finally merging them back together to obtain the sorted array.
//		
//		Divide: Divide the list or array recursively into two halves until it can no more be divided.
//		Conquer: Each subarray is sorted individually using the merge sort algorithm.
//		Merge: The sorted subarrays are merged back together in sorted order. 
//		The process continues until all elements from both subarrays have been merged.
		int arr[] = new int[] { 9, 4, 8, 7, 1, 0, 6, 2, 3 };
		print(arr);
		mergeSort(arr, 0, arr.length - 1);
		print(arr);
	}
//	Arrays.sort in Java uses QuickSort while Collections.sort uses MergeSort internally.
//	Primitives (int, char, double, etc.): Arrays.sort() uses a highly optimized Dual-Pivot Quicksort.
//	Objects (String, Integer, custom objects): Arrays.sort() uses Timsort (an adaptive, hybrid variant of Merge Sort and Insertion Sort).
//	Collections (Collections.sort()): Since collections in Java can only hold objects, 
//		Collections.sort() delegates internally to Arrays.sort(Object[]), naturally utilizing Timsort (Merge Sort).
	
//| Attribute             | Complexity     | Notes                                                              |
//| :-------------------- | :------------- | :----------------------------------------------------------------- |
//| **Best Case Time**    | O(n log n)     | Equal overhead even if the collection is already sorted.           |
//| **Average Case Time** | O(n log n)     | Uniform distribution of dividing sequences.                        |
//| **Worst Case Time**   | O(n log n)     | Guaranteed limit; avoids the O(n²) degradations found in Quicksort. |

}
