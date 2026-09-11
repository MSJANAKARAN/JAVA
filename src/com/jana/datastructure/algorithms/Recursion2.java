package com.jana.datastructure.algorithms;

import java.util.ArrayList;
import java.util.List;

import com.jana.datastructure.linkedlist.SinglyLinkedList;
import com.jana.datastructure.linkedlist.SinglyLinkedList.Node;
import com.jana.datastructure.tree.TreeNode;

public class Recursion2 {

	static Node reverseList(Node head) {
		if (head == null || head.next == null)
			return head;

		Node newHead = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
//		Imagine a list: 1 -> 2 -> 3 -> null.
//		Go to the end: The function calls itself until it reaches node 3. 
//		Since 3.next == null, it hits the base case and returns node 3 as reversedHead. 
//		Unwind to Node 2: 
//			Currently, head is 2.
//			head.next is node 3.
//			head.next.next = head translates to 3.next = 2.
//			head.next = null breaks the original link, making 2.next = null.
//			The list is now: 3 -> 2 -> null. Node 3 is still held as reversedHead. 
//		Unwind to Node 1:
//			Currently, head is 1.
//			head.next is node 2.
//			head.next.next = head translates to 2.next = 1.
//			head.next = null breaks the original link, making 1.next = null.
//		The final list is: 3 -> 2 -> 1 -> null
	}

	static void inOrder(TreeNode root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

	static int maxDepth(TreeNode node) {
		if (node == null)
			return 0;
		int left = maxDepth(node.left);
		int right = maxDepth(node.right);
		return 1 + Math.max(left, right);
	}

	static int countNodes(TreeNode node) {
		if (node == null)
			return 0;

		return 1 + countNodes(node.left) + countNodes(node.right);
	}

	static boolean isBalancedTree(TreeNode node) {
		System.out.println(checkHeight(node));
		return checkHeight(node) != -1;
	}

	static int checkHeight(TreeNode node) {
		if (node == null)
			return 0;
		// 1. Check the height of the left subtree
		int left = checkHeight(node.left);
		if (left == -1)
			return -1; // Pass the unbalance flag upward
		// 2. Check the height of the right subtree
		int right = checkHeight(node.right);
		if (right == -1)
			return -1; // Pass the unbalance flag upward
		// 3. Check if the current node is unbalanced
		if (Math.abs(left - right) > 1) {
			return -1;
		}
		// 4. If balanced, return the actual height of this node's subtree
		return 1 + Math.max(left, right);
	}

	static void subsets(int[] arr, int index, List<Integer> current, List<List<Integer>> result) {
		// Base Case: If we've made a choice for every element, save the subset
		if (index == arr.length) {
			result.add(new ArrayList<>(current));
			return;
		}
		// Choice 1: INCLUDE the current element nums[index]
		current.add(arr[index]);
		subsets(arr, index + 1, current, result);

		// Backtrack: Remove the element to try the second choice
		current.remove(current.size() - 1);
		// Choice 2: EXCLUDE the current element nums[index]
		subsets(arr, index + 1, current, result);

	}

	static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	static void permuteUsingBoolean(int[] arr, boolean[] visited, ArrayList<Integer> current,
			List<List<Integer>> result) {
		if (current.size() == arr.length) {
			result.add(new ArrayList<>(current));
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			// Skip if the number is already used in the current path
			if (visited[i]) {
				continue;
			}
			// Choice: Take the number
			visited[i] = true;
			current.add(arr[i]);
			// Recurse: Build the rest of the permutation
			permuteUsingBoolean(arr, visited, current, result);
			// Backtrack: Remove the number and mark it as unvisited for the next branch
			current.remove(current.size() - 1);
			visited[i] = false;
		}
	}

	static void permuteUsingSwap(int[] arr,  int start, List<List<Integer>> result) {
		if(start==arr.length) {
			List<Integer> res = new ArrayList<>(arr.length);
			for(int a:arr) {
				res.add(a);
			}
			result.add(res);
			return;
		}
		for(int i=start;i<arr.length;i++) {
            // Choice: Swap the element at index 'start' with the element at index 'i'
			swap(arr,start,i);
            // Recurse: Fix the next position (start + 1)
			permuteUsingSwap(arr,start+1,result);
            // Backtrack: Undo the swap to restore the array layout for the next iteration
			swap(arr,start,i);

		}
	}


	 static void combinationSum1(int[] arr, ArrayList<Integer> current,int index,int currSum, List<List<Integer>> result, int target) {

		 if(index==arr.length || currSum>=target) {
			 if(currSum==target) {
				 result.add(new ArrayList<>(current));
			 }
			 return;
		 }
		 
		 current.add(arr[index]);
		 currSum+=arr[index];
//	     Pass 'index' instead of 'index + 1' to allow reuse
//		 It is perfectly safe to pass index because base case currSum >= target acts as a guard
		 combinationSum1(arr,current,index,currSum,result,target);
		 
		 currSum-=current.get(current.size()-1);
		 current.remove(current.size()-1);
		 combinationSum1(arr,current,index+1,currSum,result,target);

	}

	 static void combinationSum2(int[] arr, ArrayList<Integer> current,int index,int currSum, List<List<Integer>> result, int target) {

		 if(index==arr.length || currSum>=target) {
			 if(currSum==target) {
				 result.add(new ArrayList<>(current));
			 }
			 return;
		 }
		 for(int i=index;i<arr.length;i++) {
		 current.add(arr[index]);
		 currSum+=arr[index];
//	     Pass 'index' instead of 'index + 1' to allow reuse
//		 It is perfectly safe to pass index because base case currSum >= target acts as a guard
		 combinationSum2(arr,current,index,currSum,result,target);
		 
		 currSum-=current.get(current.size()-1);
		 current.remove(current.size()-1);
//		 combinationSum2(arr,current,index+1,currSum,result,target); //instead for loop
		 }
	}

	public static void main(String[] args) {
		System.out.println("\n================= Recursion on Linked List ==================");
		System.out.println("------------Reverse Linked List-------------");
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		SinglyLinkedList.printList(head);
		Node reversed = reverseList(head);
		SinglyLinkedList.printList(reversed);

		System.out.println("\n================= Recursion on Trees ==================");
//		Trees are one of the biggest applications of recursion.
//			Inorder   → Left Root Right
//			Preorder  → Root Left Right
//			Postorder → Left Right Root
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.left.right.right = new TreeNode(3);

		inOrder(root);
		System.out.println("\n================= Maximum Depth of Binary Tree ==================");
//		The pattern
//			Solve left
//			Solve right
//			Combine
//		This pattern appears repeatedly in tree problems.
		System.out.println(maxDepth(root));

		System.out.println("\n================= Count Nodes in Binary Tree ==================");
		System.out.println(countNodes(root));

		System.out.println("\n================= Check Balanced Binary Tree ==================");
//		The naive solution repeatedly calculates height.
//		A better recursive solution returns information upward.
//		A recursive function can return more useful information than just the final answer.
//		root.left.right.right.left = new TreeNode(2);

		System.out.println(isBalancedTree(root));

		System.out.println("\n================= Backtracking ==================");
//		Choose → Explore → Undo
//		void backtrack(...) {
//
//		    if (baseCase) {
//		        // store answer
//		        return;
//		    }
//
//		    for (...) {
//
//		        // choose
//
//		        backtrack(...);
//
//		        // undo
//		    }
//		}
		System.out.println("\n================= Backtracking Subsets ==================");
//		A subset is a set whose every element is contained inside another larger set
//		Input : [1,2,3]
//		Output: [] [1] [2] [3] [1,2] [1,3] [2,3] [1,2,3]	
//		There are two choices for every element: Include OR Exclude
//				        Start []
//				       /        \
//			Include 1 /          \ Exclude 1
//					 /            \
//				  [1]              []
//				 /   \            /   \
//	 Include 2 /      \      Inc /     \ Exc
//		      /        \        /       \
//			[1, 2]     [1]    [2]       []   <- Base Cases (Saved to result)

		List<List<Integer>> result1 = new ArrayList<>();
		int arr[] = new int[] { 1, 2, 3 };
		subsets(arr, 0, new ArrayList<>(), result1);
		System.out.println(result1);

		System.out.println("\n================= Backtracking Permutations ==================");
//		Input : [1,2,3]
//		Output: 123 132 213 231 312 321
//		void permute(...) {
//		    if (complete) {
//		        // save
//		        return;
//		    }
//		    for (...) {
//		        // choose
//
//		        // swap / mark visited
//
//		        permute(...);
//
//		        // undo
//		    }
//		}
		List<List<Integer>> result2 = new ArrayList<>();
		List<List<Integer>> result3 = new ArrayList<>();

//		Efficient Approach using Swapping
		permuteUsingSwap(arr, 0, result2);
		permuteUsingBoolean(arr, new boolean[arr.length], new ArrayList<>(), result3);

		System.out.println("Efficient Swapping Technique:\n" + result2);
		System.out.println("Boolean Standard Backtracking:\n" + result3);

		System.out.println("\n================= Backtracking Combination Sum ==================");
		List<List<Integer>> result4 = new ArrayList<>();
		List<List<Integer>> result5 = new ArrayList<>();

		int target=3;
		combinationSum1(arr,new ArrayList<Integer>(),0,0,result4, target);
		System.out.println(result4);
		combinationSum2(arr,new ArrayList<Integer>(),0,0,result5, target);
		System.out.println(result4);
		
		System.out.println("\n================= Backtracking N-Queens ==================");
//		Place N queens on an N×N chessboard such that no two queens attack each other.
//		You recursively place one queen per row:
//			Row 0
//			 ↓
//			Row 1
//			 ↓
//			Row 2
//			 ↓
//			Row 3
//		For each row:
//			Try column
//			   ↓
//			Valid?
//			   ↓
//			Place queen
//			   ↓
//			Recurse
//			   ↓
//			Remove queen
//		https://leetcode.com/problems/n-queens/
//		https://leetcode.com/problems/n-queens-ii/
		System.out.println("\n================= Divide and Conquer ==================");
//		Problem
//		   ↓
//		Divide
//		   ↓
//		Solve smaller problems
//		   ↓
//		Combine
//		Classic examples:
//			Merge Sort
//				Array
//				 ↓
//				Split
//				 ↓
//				Left + Right
//				 ↓
//				Sort both
//				 ↓
//				Merge
//			Quick Sort
//				Choose pivot
//				 ↓
//				Partition
//				 ↓
//				Left
//				Right
//				 ↓
//				Recursively sort
		System.out.println("\n================= Recursion + Memoization ==================");
//		This is where recursion becomes DP.
//		Instead of:
//			Repeated calculation
//			Repeated calculation
//			Repeated calculation
//		store: memo[n]
//		Concept: Recursion + Memoization = Top-down Dynamic Programming
		int n=6;
		int fibRes = fibonacci(n, new int[n+1]);
		System.out.println(fibRes);
		
	}

	static int fibonacci(int n, int[] memo) {
		if(n<=1) {
			return n;
		}
		
		if(memo[n]!=0) {
			return memo[n];
		}
		
		memo[n]=fibonacci(n-1,memo)+fibonacci(n-2,memo);
		
		return memo[n];
	}
}
