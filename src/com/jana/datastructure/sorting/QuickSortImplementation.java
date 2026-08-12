package com.jana.datastructure.sorting;

public class QuickSortImplementation {

	static int partition(int[] arr, int left, int right) {

		int pivot = right;

		int i = left - 1;

		// traverse arr[low..high] and move all smaller
		// elements to the left side. Elements from low to
		// i are smaller after every iteration
		for (int j = left; j < right; j++) {
			if (arr[j] < arr[pivot]) {
				i++;
				swap(arr, i, j);
			}
		}
		// swap pivot element with i+1th element(after smaller elements)

		swap(arr, i + 1, right);
		// i will be before the pivot element
		return i + 1;
	}

	static void quickSort(int[] arr, int left, int right) {

		if (left < right) {

			int pi = partition(arr, left, right);

			quickSort(arr, left, pi - 1);
			quickSort(arr, pi + 1, right);
		}
	}

	static void swap(int arr[], int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}

	static void print(int[] arr) {
		System.out.print("Array : ");
		for (int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
//		QuickSort is a sorting algorithm based on the Divide and Conquer that 
//		picks an element as a pivot and partitions the given array around the 
//		picked pivot by placing the pivot in its correct position in the sorted array
//		
//		Choose a Pivot: Select an element from the array as the pivot. 
//		The choice of pivot can vary (e.g., first element, last element, random element, or median).
//		Partition the Array: Re arrange the array around the pivot. After partitioning, all elements 
//		smaller than the pivot will be on its left, and all elements greater than the pivot will be on its right.
//		Recursively Call: Recursively apply the same process to the two partitioned sub-arrays.
//		Base Case: The recursion stops when there is only one element left in the sub-array, as a single element is already sorted.
		int arr[] = new int[] { 9, 4, 8, 7, 1, 0, 6, 2, 3 };
		print(arr);
		quickSort(arr, 0, arr.length - 1);
		print(arr);
	}

//	Time Complexity:
//		Best Case: (Ω(n log n)), Occurs when the pivot element divides the array into two equal halves.
//		Average Case (θ(n log n)), On average, the pivot divides the array into two parts, but not necessarily equal.
//		Worst Case: (O(n²)), Occurs when the smallest or largest element is always chosen as the pivot (e.g., sorted arrays).
//	Auxiliary Space:
//		Worst-case scenario: O(n) due to unbalanced partitioning leading to a skewed recursion tree requiring a call stack of size O(n).
//		Best-case scenario: O(log n) as a result of balanced partitioning leading to a balanced recursion tree with a call stack of size O(log n).
}
