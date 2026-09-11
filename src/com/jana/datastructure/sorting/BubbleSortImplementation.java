package com.jana.datastructure.sorting;

public class BubbleSortImplementation {
	static void print(int[] arr) {
		System.out.print("Array : ");
		for (int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
//		Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in the wrong order. 
//		This algorithm is not efficient for large data sets as its average and worst-case time complexity are quite high
		//		Best Case: O(N) (Using the swapped optimization on a sorted array)
//		Average Case: O(N²)
//		Worst Case: O(N²)
//		Space Complexity: O(1) auxiliary
		int arr[] = new int[] { 9, 4, 8, 7, 1, 0, 6, 2, 3 };
		print(arr);
		bubbleSort(arr);
		print(arr);
		
//		Input Array: [5, 2, 8, 1, 3]
//		Iteration 1 (Pass 1):
//			[2, 5, 8, 1, 3] (Swap 5, 2)
//			[2, 5, 8, 1, 3] (No swap 5, 8)
//			[2, 5, 1, 8, 3] (Swap 8, 1)
//			[2, 5, 1, 3, 8] (Swap 8, 3) -> 8 is sorted.
//		Iteration 2 (Pass 2):
//			[2, 5, 1, 3, 8] (No swap 2, 5)
//			[2, 1, 5, 3, 8] (Swap 5, 1)
//			[2, 1, 3, 5, 8] (Swap 5, 3) -> 5 is sorted.
//		Iteration 3 (Pass 3):
//			[1, 2, 3, 5, 8] (Swap 2, 1)
//			[1, 2, 3, 5, 8] (No swap 2, 3) -> 3 is sorted.
//		Iteration 4 (Pass 4):
//			[1, 2, 3, 5, 8] (No swap 1, 2) -> Optimized break.
//		Final Output: [1, 2, 3, 5, 8]
	}

	private static void bubbleSort(int[] arr) {
//		Look for adjacent comparisons (arr[j] > arr[j+1]).
		int n = arr.length;
		boolean swapped;
		
		for (int i = 0; i < n-1; i++) {
			swapped = false;
	        // Last i elements are already sorted/bubbled up
			for(int j=0;j<n-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					swapped=true;
				}
			}
			// Optimization: If no elements were swapped, array is sorted
	        if (!swapped) {
	            break;
	        }
		}
	}

}
