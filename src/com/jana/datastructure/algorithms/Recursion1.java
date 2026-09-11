package com.jana.datastructure.algorithms;

import java.util.Arrays;

public class Recursion1 {
	static void fun(int n) {
		if (n == 0)
			return;
		System.out.println("Before " + n);
		fun(n - 1);
		System.out.println("After " + n);
	}

	static int factorial(int n) {
		if (n == 0)
			return 1;
		return n * factorial(n - 1);
	}

	static int fibonacci(int n) {
		if (n == 1 || n == 0)
			return n;
		return fibonacci(n - 1) + fibonacci(n - 2);
//		        fib(5)
//		     /          \
//		 fib(4)         fib(3)
//		/    \          /    \
//	 fib(3) fib(2)   fib(2) fib(1)
//That's why naive Fibonacci recursion is: Time:  O(2^n) Space: O(n)
//How would you optimize it?
//Answer: Use memoization or bottom-up dynamic programming.
	}

	static void print1toN(int n) {
		if (n < 1)
			return;
		print1toN(n - 1);
		System.out.println(n);
	}

	static void printNto1(int n) {
		if (n < 1)
			return;
		System.out.println(n);
		printNto1(n - 1);
	}

	static int sum1toN(int n) {
		if (n <= 1)
			return n;
		return n + sum1toN(n - 1);
	}

	static double powerofN(double x, int n) {
		if (n == 0)
			return 1;
		if (n < 0)
			return 1 / powerofN(x, -n); // Negative exponent handling
		return x * powerofN(x, n - 1);
	}

	static int countDigits(int n) {
		if (n < 10)
			return 1;
		return 1 + countDigits(n / 10);
	}

	static int sumDigits(int n) {
		if (n == 0)
			return 0;
		return n % 10 + sumDigits(n / 10);
	}

	static int reverseNumber(int n, int rev) {
		System.out.println(n + " " + rev);
		if (n == 0)
			return rev;
		return reverseNumber(n / 10, rev * 10 + (n % 10));
	}

	static boolean isPalindrome(int n) {
		if (n < 0)
			return false; // Negative numbers are not palindromes due to '-'
		return n == reverseNumber(n, 0);
	}

	static boolean recursivePalindrome(String s, int left, int right) {
		if (left >= right)
			return true;

		if (s.charAt(left) != s.charAt(right)) {
			return false;
		}
		return recursivePalindrome(s, left + 1, right - 1);
	}

	static int findMaximum(int[] arr, int index) {
		if (index == arr.length - 1) {
			return arr[index];
		}
		return Math.max(arr[index], findMaximum(arr, index + 1));
	}

	static int sumArray(int[] arr, int index) {
		if (index == arr.length - 1) {
			return arr[index];
		}
		return arr[index] + sumArray(arr, index + 1);
	}

	static void reverseArray(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}
		int temp = arr[right];
		arr[right] = arr[left];
		arr[left] = temp;
		reverseArray(arr, left + 1, right - 1);
	}

	static int getPaths(int[][] grid, int right, int bottom) {
		if (right >= grid.length || bottom >= grid[0].length) {
			return 0;
		}
		if (grid[right][bottom] == 0) {
			return 0;
		}
		if (right == grid.length - 1 && bottom == grid[0].length - 1) {
			return 1;
		}
		return getPaths(grid, right + 1, bottom) + getPaths(grid, right, bottom + 1);

	}

	static int getPathsIterative(int[][] grid) {
		// Iterative Solution:
//		In Unique Paths problem, Initializing the first row and first column to 1 because there is exactly 
//		one unique way to reach any cell on the top border or the left border of the grid.
//		Below solution without obstacles case for reference, check Test2 for solution without obstacles
		int m = grid.length;
		int n = grid[0].length;
		for (int i = 0; i < m; i++) {
			grid[i][0] = 1;
		}
		for (int j = 0; j < n; j++) {
			grid[0][j] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				grid[i][j] = grid[i - 1][j] + grid[i][j - 1];

			}
		}
		return grid[m - 1][n - 1];
		
	}

	public static void main(String[] args) {
//		Prefer when All possibilities / combinations / permutations / tree-like choices
		
//		Recursion is a technique where a function solves a problem by 
//		calling itself on a smaller subproblem until reaching a base case.		
//		Two Things Every Recursion Must Have
//		1. Base Case : Stops recursion.
//			if (n == 0)
//			    return;
//		2. Progress Toward Base Case : The input must move toward the base case.
//			fun(n - 1);
//		Otherwise: fun(n); // infinite recursion
		System.out.println("\n================== Understand the Call Stack ==================");
		fun(3);
//		Before 3 -> Before 2 -> Before 1 -> After 1 -> After 2 -> After 3
//		What is the difference between code before and after recursive call?
//			Before → executed while going down
//			After → executed while unwinding

		System.out.println("\n================== Must-Know Basic Recursion Questions ==================");
		System.out.println("------------Print 1 to N-------------");
		print1toN(5);

		System.out.println("------------Print N to 1-------------");
		printNto1(5);

		System.out.println("------------Sum of 1 to N-------------");
		System.out.println(sum1toN(5));

		System.out.println("------------Factorial-------------");
		System.out.println(factorial(5));

		System.out.println("------------Fibonacci-------------");
		System.out.println(fibonacci(5));

		System.out.println("------------Power of a number-------------");
		System.out.println(powerofN(-2, 4));

		System.out.println("------------Count digits-------------");
		System.out.println(countDigits(543));

		System.out.println("------------Sum of digits-------------");
		System.out.println(sumDigits(543));

		System.out.println("------------Reverse a number-------------");
		System.out.println(reverseNumber(543, 0));

		System.out.println("------------Check palindrome-------------");
		System.out.println(isPalindrome(54345));

		System.out.println("\n================== Recursion With Arrays ==================");
		System.out.println("------------Find maximum-------------");
		int[] arr = { 1, 2, 4, 5, 12, 9 };
		System.out.println(findMaximum(arr, 0));
		System.out.println("------------Sum of array-------------");
		System.out.println(sumArray(arr, 0));
		System.out.println("------------Reverse array-------------");
//		Always use left + 1 in recursion. It keeps your functions pure, avoids hidden mutations, and safely transitions execution down the stack frames.
//		Avoid left++ or ++left inside parameter lists, as they create structural bugs that are difficult to trace and debug.
		reverseArray(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));

		System.out.println("\n================== Recursion + Two Pointers ==================");
		System.out.println("------------Recursive palindrome-------------");
		String pal1 = "hdmi";
		String pal2 = "radar";
		System.out.println(recursivePalindrome(pal1, 0, pal1.length() - 1));
		// array.length -1 as string will be converted to char Array
		System.out.println(recursivePalindrome(pal2, 0, pal2.length() - 1));

		System.out.println("\n================== Grid Recursion ==================");
//		Unique Paths with Obstacles (Walmart 2nd round), 
//		(consider 0 as obstacle, find no of pathd to reach mxn place from 0,0.)
		int[][] grid = new int[][] { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };
//		1 1 0
//		1 1 1
//		0 1 1
//		At every cell:
//	          current
//	          /     \
//	       Down     Right
		// solution to reach last nodes. to reach mxn, check com.walmart.Test2
		System.out.println(getPaths(grid, 0, 0));
//		Unique Paths solution without obstacles case for reference, check Test2 for solution without obstacles
//		https://leetcode.com/problems/unique-paths/submissions/
//		https://leetcode.com/problems/unique-paths-ii/submissions/

		System.out.println(getPathsIterative(grid));
		
//		Generate Subsets
		
	}
	
//	The 5 Recursion Patterns MUST Recognize
//	Pattern 1 — Linear Recursion
//		f(n)
//		 ↓
//		f(n-1)
//		 ↓
//		f(n-2)
//	  Examples:
//		Factorial
//		Sum
//		Reverse
//		Fibonacci
//	Pattern 2 — Two-Branch Recursion
//	             f(n)
//	            /    \
//	        f(n-1)  f(n-2)
//	  Examples:
//		Fibonacci
//		Climbing Stairs
//		Subsets
//		Grid paths
//	Pattern 3 — Tree Recursion
//	             root
//	            /    \
//	         left    right
//	  Examples:
//		Tree traversal
//		Tree height
//		Diameter
//		Balanced tree
//		Path sum
//	Pattern 4 — Backtracking
//		Choose
//		  ↓
//		Explore
//		  ↓
//		Undo
//	  Examples:
//		Subsets
//		Permutations
//		Combination Sum
//		N-Queens
//		Sudoku
//	Pattern 5 — Divide & Conquer
//		Divide
//		  ↓
//		Solve
//		  ↓
//		Combine
//	  Examples:
//		Merge Sort
//		Quick Sort
//		Binary Search

}
