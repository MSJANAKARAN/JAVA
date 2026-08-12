package com.jana.datastructure.tree;

public class BinaryTreeImplementation {

	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	public static void main(String[] args) {
//		Binary Tree is a non-linear and hierarchical data structure where each node has 
//		at most two children referred to as the left child and the right child.  
//		The topmost node in a binary tree is called the root, 
//		and the bottom-most nodes(having no children) are called leaves.

		Node firstNode = new Node(4);
		Node secondNode = new Node(3);
		Node thirdNode = new Node(7);
		Node fourthNode = new Node(5);

		firstNode.left = secondNode;
		firstNode.right = thirdNode;
		secondNode.left = fourthNode;

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
