package com.jana.datastructure.tree;

import java.util.ArrayList;

public class DFSTraversals {

	static void inOrder(Node node, ArrayList<Integer> arr) {

		if (node == null) {
			return;
		}

		inOrder(node.left, arr);
		arr.add(node.data);
		inOrder(node.right, arr);
	}

	static void preOrder(Node node, ArrayList<Integer> arr) {
		if (node == null) {
			return;
		}

		arr.add(node.data);
		preOrder(node.left, arr);
		preOrder(node.right, arr);
	}

	static void postOrder(Node node, ArrayList<Integer> arr) {
		if (node == null)
			return;

		postOrder(node.left, arr);
		postOrder(node.right, arr);
		arr.add(node.data);

	}

	public static void main(String[] args) {

//		 Binary tree
//			  1
//			 / \
//			2   3
//		   / \   \
//		  4   5   6
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(6);

		ArrayList<Integer> in = new ArrayList<>();
		ArrayList<Integer> pre = new ArrayList<>();
		ArrayList<Integer> post = new ArrayList<>();

		inOrder(root, in);
		System.out.println("InOrder Traversal: ");
		for (int node : in) {
			System.out.print(node + " ");
		}

		preOrder(root, pre);
		System.out.println("\nPreOrder Traversal: ");
		for (int node : pre) {
			System.out.print(node + " ");
		}

		postOrder(root, post);
		System.out.println("\nPostOrder Traversal: ");
		for (int node : post) {
			System.out.print(node + " ");
		}

	}

//	Depth First Search Traversals
//	Inorder(tree) 
//	● Traverse the left subtree, i.e., call Inorder(left->subtree) 
//	● Visit the root. 
//	● Traverse the right subtree, i.e., call Inorder(right->subtree) 
//	
//	Preorder(tree) 
//	● Visit the root. 
//	● Traverse the left subtree, i.e., call Preorder(left->subtree) 
//	● Traverse the right subtree, i.e., call Preorder(right->subtree) 
//	
//	Postorder(tree) 
//	●Traverse the left subtree, i.e., call Postorder(left->subtree) 
//	● Traverse the right subtree, i.e., call Postorder(right->subtree) 
//	● Visit the root 

//	Time Complexity: O(n)
//	Auxiliary Space: O(h), h is the height of the tree
//	In the worst case, h can be the same as n (when the tree is a skewed tree)
//	In the best case, h can be the same as log n (when the tree is a complete tree)
}
