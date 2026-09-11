package com.jana.datastructure.sorting;

public class InsertionSortImplementation {
	static void print(int[] arr) {
		System.out.print("Array : ");
		for (int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
//		Insertion sort is a simple sorting algorithm that works by iteratively inserting each element of an unsorted 
//		list into its correct position in a sorted portion of the list. It is like sorting playing cards in your hands.
//		Best Used For: Nearly sorted data or small datasets
//		Best Case: O(N) (When the array is already fully sorted)
//		Average Case: O(N²)
//		Worst Case: O(N²) (When the array is reverse-sorted)
//		Space Complexity: O(1) auxiliary
		int arr[] = new int[] { 9, 4, 8, 7, 1, 0, 6, 2, 3 };
		print(arr);
		insertionSort(arr);
		print(arr);
//		Input Array: [5, 2, 8, 1, 3]
//		Iteration 1: Key is 2. Shift 5 right. Insert 2.
//			[2, 5, 8, 1, 3]
//		Iteration 2: Key is 8. No shift needed. Insert 8.
//			[2, 5, 8, 1, 3]
//		Iteration 3: Key is 1. Shift 8, 5, 2 right. Insert 1.
//			[1, 2, 5, 8, 3]
//		Iteration 4:  Key is 3. Shift 8, 5 right. Insert 3.
//			[1, 2, 3, 5, 8]
//		Final Output: [1, 2, 3, 5, 8]
	}

	private static void insertionSort(int[] arr) {
//		Look for a nested while loop shifting items backward.
		int n = arr.length;

		for (int i = 1; i < n; i++) {
			int key=arr[i];
			
			int j=i-1;
//	        Shift elements of arr[0..i-1] that are greater than key
//	        to one position ahead of their current position
			while(j>=0 && arr[j]>key) {
				arr[j+1]=arr[j];
				j--;
			}
//			Place the key in its correct spot
			arr[j+1]=key;
		}
	}

}
