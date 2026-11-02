package com.jana.datastructure.tree;

public class BinaryTreeImplementation {

	static class TreeNode {
		int data;
		TreeNode left, right;

		TreeNode(int data) {
			this.data = data;
			left = right = null;
		}
	}

	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	public static int maxDiameter(TreeNode root, int[] max) {
		if (root == null) {
			return 0;
		}

		int left = maxDiameter(root.left, max);
		int right = maxDiameter(root.right, max);

		max[0] = Math.max(max[0], left + right);
		return 1 + Math.max(left, right);
	}

	public static void main(String[] args) {
//		Binary Tree is a non-linear and hierarchical data structure where each node has 
//		at most two children referred to as the left child and the right child.  
//		The topmost node in a binary tree is called the root, 
//		and the bottom-most nodes(having no children) are called leaves.

		TreeNode firstNode = new TreeNode(4);
		TreeNode secondNode = new TreeNode(3);
		TreeNode thirdNode = new TreeNode(7);
		TreeNode fourthNode = new TreeNode(5);

		firstNode.left = secondNode;
		firstNode.right = thirdNode;
		secondNode.left = fourthNode;

		System.out.println("Maximum Depth: " + maxDepth(firstNode));

		int[] result = { 0 };
		// Passing array to get modifying max results inside same reference array object
		maxDiameter(firstNode, result);
		System.out.println("Maximum Diameter: " + result[0]);

	}

//	Types of Binary Trees
//	Full Binary Tree → Every non-leaf node has exactly two children.
//	Complete Binary Tree → All levels are fully filled except possibly the last, which is filled from left to right.
//	Perfect Binary Tree → Every level is completely filled, and all leaves are at the same depth.
//	Balanced Binary Tree → The left and right subtrees differ in height by at most 1.

//	Binary Tree can be classified into the following special types:
//		Binary Search Tree
//		AVL Tree
//		Red Black Tree
//		B Tree
//		B+ Tree

//	DFS Traversals: Explore one branch fully before backtracking.
//	In-Order (LNR): Left → Node → Right (retrieves BST elements in sorted order).
//	Pre-Order (NLR): Node → Left → Right (used for tree reconstruction).
//	Post-Order (LRN): Left → Right → Node (helps in deleting or evaluating expressions).
//	BFS Traversals: Visit nodes level by level.
//	Level-Order: Processes nodes from top to bottom (used in shortest path algorithms).
//	Zig-Zag Traversal: Alternates left-to-right and right-to-left at each level (used in hierarchical structures).

//	The maximum number of nodes at level L of a binary tree is 2L.
//	The maximum number of nodes in a binary tree of height H is 2H+1 – 1.
//	Total number of leaf nodes in a binary tree = total number of nodes with 2 children + 1.
//	In a Binary Tree with N nodes, the minimum possible height or the minimum number of levels is ⌊log2N⌋.
//	A Binary Tree with L leaves has at least ⌈log2L⌉+ 1 levels.
}
