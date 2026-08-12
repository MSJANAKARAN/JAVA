package com.jana.datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFSTraversals {

	private static void levelOrderRecursive(Node node, int level, ArrayList<ArrayList<Integer>> res) {
		if (node == null)
			return;
//		The idea is to traverse the tree recursively, starting from the root at level 0. When a node is visited, 
//		its value is added to the result array at the index corresponding to its level, and then its left and right children
//		are recursively processed in the same way. This effectively performs a level-order traversal using recursion.
		// Add a new level to the result if needed
		if (res.size() <= level)
			res.add(new ArrayList<>());

		// Add current node's data to its corresponding level
		res.get(level).add(node.data);
		// Recur for left and right children
		levelOrderRecursive(node.left, level + 1, res);
		levelOrderRecursive(node.right, level + 1, res);

	}

	private static void levelOrderQueue(Node root, ArrayList<ArrayList<Integer>> res) {
//		The idea is to use a queue to traverse the tree level by level. 
//		Start by adding the root to the queue. Then, repeatedly remove a node from the queue, 
//		store its value in the result, and add its left and right children to the queue. 
//		Continue this process until the queue is empty.
//		Using queue such that,nodes accessed in the order of insertion. i.e level order

		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		int level = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			res.add(new ArrayList<>());
			for (int i = 0; i < size; i++) {
				Node node = q.poll();
				res.get(level).add(node.data);
				if (node.left != null)
					q.offer(node.left);

				if (node.right != null)
					q.offer(node.right);
			}
			level++;
		}
	}

	private static void zigzagTraversal2Stack(Node root, ArrayList<Integer> res) {
//		s1 stores nodes of the current level, and s2 stores nodes of the next level.
//		Nodes in s1 are processed from top to bottom, and their children are pushed onto s2 in left → right order.
//		Nodes in s2 are then processed from top to bottom, and their children are pushed onto s1 in right → left order.
//		By alternating the order of pushing children between the two stacks at each level, 
//		the traversal naturally alternates direction, achieving the zigzag pattern.	
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();

		s1.push(root);
		while (!s1.isEmpty() || !s2.isEmpty()) {
			while (!s1.isEmpty()) {
				Node node = s1.pop();
				res.add(node.data);
				if (node.left != null) {
					s2.push(node.left);
				}
				if (node.right != null) {
					s2.push(node.right);
				}
			}
			while (!s2.isEmpty()) {
				Node node = s2.pop();
				res.add(node.data);
				if (node.right != null) {
					s1.push(node.right);
				}
				if (node.left != null) {
					s1.push(node.left);
				}
			}
		}

	}

	public static void main(String[] args) {
//		Breadth First Search Traversals
//              5
//             / \
//           12   13
//           /  \    \
//          7    14   2
//         / \  /  \  / \
//        17 23 27 3  8  11

		Node root = new Node(5);
		root.left = new Node(12);
		root.right = new Node(13);
		root.left.left = new Node(7);
		root.left.right = new Node(14);
		root.right.right = new Node(2);
		root.left.left.left = new Node(17);
		root.left.left.right = new Node(23);
		root.left.right.left = new Node(27);
		root.left.right.right = new Node(3);
		root.right.right.left = new Node(8);
		root.right.right.right = new Node(11);

		System.out.println("==== Level Order Traversal ====");

//		Level Order Traversal technique is a method to traverse a Tree such that all nodes 
//		present in the same level are traversed completely before traversing the next level.
//		Using Recursion - O(n) time and O(n) space
//		Using Queue (Iterative) - O(n) time and O(n) space

		ArrayList<ArrayList<Integer>> res1 = new ArrayList<>();
		levelOrderRecursive(root, 0, res1);
		System.out.println("Level Order Traversal using Recursion: ");

		for (ArrayList<Integer> level : res1) {

			for (int val : level) {
				System.out.print(val + " ");
			}
//			System.out.println();
		}
		System.out.println();

		ArrayList<ArrayList<Integer>> res2 = new ArrayList<>();
		levelOrderQueue(root, res2);
		System.out.println("Level Order Traversal using Queue [Expected Approach]: ");

		for (ArrayList<Integer> level : res2) {

			for (int val : level) {
				System.out.print(val + " ");
			}
			System.out.println();
		}

		System.out.println("==== ZigZag Tree Traversal ====");
//		Given the root of a binary tree, perform a zigzag (spiral) level order traversal. 
//		For odd-numbered levels, traverse the nodes from left to right and 
//		for even-numbered levels, traverse the nodes from right to left.

//		[Naive Approach] - Using Recursion - O(n*h) Time and O(h) Space
//		[Expected Approach - 1] - Using Two Stacks - O(n) Time and O(n) Space
//		[Expected Approach - 2] - Using Deque - O(n) Time and O(n) Space

		System.out.println("ZigZag Tree Traversal using Two Stacks: ");

		ArrayList<Integer> res3 = new ArrayList<>();
		zigzagTraversal2Stack(root, res3);
		System.out.println("Level Order Traversal using Queue [Expected Approach]: ");

		for (int val : res3) {
			System.out.print(val + " ");
		}
		System.out.println();

	}

}
