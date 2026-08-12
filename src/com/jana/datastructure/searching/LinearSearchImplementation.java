package com.jana.datastructure.searching;

public class LinearSearchImplementation {

	static int linearSearch(int[] arr, int x) {
		for (int val = 0; val < arr.length; val++) {
			if (arr[val] == x) {
				return val;
			}
		}
		return -1;


//| Attribute             | Complexity     | Notes                                                              |
//| :-------------------- | :------------- | :----------------------------------------------------------------- |
//| **Best Case Time**    | O(1)           | Target sits perfectly at the very first element of the collection. |
//| **Average Case Time** | O(n)           | Target is located near the middle, inspecting roughly n/2 items.   |
//| **Worst Case Time**   | O(n)           | Target is at the final index or completely absent from the array.  |
//| **Space Complexity**  | O(1)           | Constant memory allocation; operates strictly on the input space.  |

	}

	static int linearSearchRecursive(int[] arr, int x, int index) {
		if (index >= arr.length) {
			return -1;
		}
		if (arr[index] == x) {
			return index;
		}

		return linearSearchRecursive(arr, x, index + 1);

//| Attribute             | Complexity     | Notes                                                              |
//| :-------------------- | :------------- | :----------------------------------------------------------------- |
//| **Best Case Time**    | O(1)           | Target sits perfectly at the very first index (0 recursive steps). |
//| **Average Case Time** | O(n)           | Target is located near the middle, spawning roughly n/2 frames.    |
//| **Worst Case Time**   | O(n)           | Target is missing or at the final index, executing n stack splits. |
//| **Space Complexity**  | O(n)           | Allocates a brand new stack frame for every single index checked.  |

	}

	public static void main(String[] args) {

		int arr[] = new int[] { 9, 4, 8, 7, 1, 0, 6, 2, 3 };

		System.out.println("Element present at index: " + linearSearch(arr, 7));

		System.out.println("Element present at index: " + linearSearchRecursive(arr, 8, 0));

	}

}
