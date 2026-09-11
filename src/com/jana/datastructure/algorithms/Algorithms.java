package com.jana.datastructure.algorithms;

public class Algorithms {

	public static void main(String[] args) {
//		| #  | Concept                      | Typical Problems                             | Priority |
//		| -- | ---------------------------- | -------------------------------------------- | -------- |
//		| 1  |   Hashing                    | Two Sum, duplicates, frequency               | ⭐⭐⭐⭐⭐    |
//		| 2  |   Two Pointers               | Pair Sum, 3Sum, palindrome                   | ⭐⭐⭐⭐⭐    |
//		| 3  |   Sliding Window             | Longest substring, max K window              | ⭐⭐⭐⭐⭐    |
//		| 4  |   Binary Search              | Search, first/last occurrence, answer search | ⭐⭐⭐⭐⭐    |
//		| 5  |   Stack / Monotonic Stack    | Parentheses, Next Greater Element            | ⭐⭐⭐⭐⭐    |
//		| 6  |   Prefix Sum                 | Range Sum, Subarray Sum = K                  | ⭐⭐⭐⭐      |
//		| 7  |   Recursion / Backtracking   | Subsets, permutations, combinations          | ⭐⭐⭐⭐⭐    |
//		| 8  |   DFS / BFS                  | Trees, graphs, islands, shortest path        | ⭐⭐⭐⭐⭐    |
//		| 9  |   Heap / Priority Queue      | Top K, Kth largest, median                   | ⭐⭐⭐⭐⭐    |
//		| 10 |   Dynamic Programming        | Climbing Stairs, Knapsack, Unique Paths      | ⭐⭐⭐⭐⭐    |

//		1. Hashing
//		Hashing uses a hash function to map data to a specific index in a table. 
//		In practice, this means using a HashMap (key-value pairs) or a HashSet (unique keys) to 
//		store items you have seen before so you can look them up instantly later.
//		"Have I seen this before?" → HashSet/HashMap
//		Know:
//			Frequency counting
//			Duplicate detection
//			Two Sum
//			First non-repeating character
//			Longest consecutive sequence
//			Subarray Sum = K
		
//		2. Two Pointers
//		The Two Pointers technique uses two integer variables (acting as indices) to read through a 
//		data structure at the same time. They can either start at opposite ends and 
//		move toward each other (converging) or move at different speeds (fast/slow pointers).
//		Sorted array + pair/target → Two Pointers
//		Know:
//			Two Sum sorted
//			3Sum
//			Palindrome
//			Remove duplicates
//			Move zeroes
//			Container With Most Water
			
//		3. Sliding Window
//		A Sliding Window is used to track a continuous subsegment (subarray or substring) of 
//		a larger array or string. The "window" expands by moving its right boundary forward 
//		and shrinks by pulling its left boundary forward.
//		Continuous + longest/shortest/max/min → Sliding Window
//		Know:
//			Maximum sum of K consecutive elements
//			Longest substring without repeating characters
//			Longest substring with K distinct characters
//			Minimum Window Substring
		
//		4. Binary Search
//		Binary Search finds an item in a sorted collection by repeatedly dividing the search interval in half.
//		If the target value is less than the item in the middle of the interval, 
//		you narrow the interval to the lower half; otherwise, you narrow it to the upper half.
//		Sorted/monotonic condition → Binary Search
//		Must know:
//			Basic binary search
//			First occurrence
//			Last occurrence
//			Lower/upper bound
//			Search rotated array
//			Peak element
//			Binary Search on Answer
			
//		5. Stack / Monotonic Stack
//		A Stack is a data structure that processes data in a Last-In, First-Out (LIFO) order. 
//		A Monotonic Stack is a specialized version that keeps its elements strictly sorted 
//		(either entirely increasing or entirely decreasing) as you push new values.
//		Next Greater/Smaller, Previous Greater/Smaller → Monotonic Stack
//		Must know:
//			Valid Parentheses
//			Next Greater Element
//			Previous Greater Element
//			Daily Temperatures
//			Largest Rectangle in Histogram
			
//		6. Prefix Sum
//		A Prefix Sum involves creating a secondary array where each index stores the cumulative 
//		sum of all elements from the start of the original array up to that index.
//		Know:
//			Range Sum Query
//			Subarray Sum
//			Equilibrium Index
//			Count subarrays with sum K
			
//		7. Recursion / Backtracking
//		Recursion is a programming pattern where a function calls itself to break down a problem into smaller subproblems. 
//		Backtracking is an algorithmic technique built on top of recursion to systematically try out all possible paths 
//		to solve a problem and "backtrack" (undo the last step) as soon as a path fails.
//		Recursion
//			Solve smaller version
//			        ↓
//			Recursive call
//			        ↓
//			Base case
//		Backtracking
//			Choose
//			  ↓
//			Explore
//			  ↓
//			Undo
//		Must know:
//			Factorial
//			Fibonacci
//			Palindrome
//			Binary Search
//			Reverse Linked List
//			Tree recursion
//			Subsets
//			Permutations
//			Combination Sum
//			N-Queens
		
//		8. DFS / BFS (Graph & Tree Traversals)
//		DFS (Depth-First Search): Uses a Stack (or recursion) to dive as deep as possible down a single branch before backtracking
//		to check other paths.Use DFS when you need to explore paths thoroughly, check connectivity, or visit leaf nodes.
//		BFS (Breadth-First Search): Uses a Queue to explore a structure layer-by-layer, visiting all immediate neighbor nodes 
//		before moving to the next level down. Use BFS when you need to find the shortest path or minimum steps in an unweighted graph.
//		Must know:
//			Tree traversals
//			Maximum depth
//			Number of Islands
//			Connected Components
//			Graph traversal
//			Shortest path in unweighted graph
//			Level-order traversal
			
//		9. Heap / Priority Queue
//		A Heap is a specialized tree-based data structure that maintains a specific order. 
//		A Min-Heap keeps the absolute smallest element at the top, while a Max-Heap keeps the absolute largest element at the top.
//		Must know:
//			Kth largest
//			Kth smallest
//			Top K frequent
//			Merge K sorted lists
//			Find median
//			Meeting Rooms
		
//		10. Dynamic Programming (DP)
//		Dynamic Programming is an optimization technique used to solve complex problems by breaking them down into simpler, 
//		overlapping subproblems. It solves each subproblem exactly once and stores the answer—either top-down using 
//		recursion + a cache (Memoization) or bottom-up using a table (Tabulation).
//		Top-Down Approach (Memoization)
//			The top-down approach starts from the main problem and breaks it down into smaller pieces using recursion.
//			It checks a cache or memoization table before computing a state. If the value is already there, it uses it. 
//			If not, it computes the value and saves it in the table for next time. 
//		Bottom-Up Approach (Tabulation)
//			The bottom-up approach starts from the smallest base cases and builds up to the final solution using loops.
//			It uses an array or table (dp table). It solves the base cases first, 
//			then fills in the rest of the table iteratively using a for or while loop.
		
//		Must know:
//			Fibonacci
//			Climbing Stairs
//			House Robber
//			Unique Paths
//			Unique Paths with Obstacles
//			Coin Change
//			0/1 Knapsack
//			Longest Common Subsequence
		
	}

}
