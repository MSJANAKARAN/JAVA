package com.jana.datastructure.tree;

import java.util.ArrayList;

public class DFSTraversals {

	static void inOrder(TreeNode TreeNode, ArrayList<Integer> arr) {

		if (TreeNode == null) {
			return;
		}

		inOrder(TreeNode.left, arr);
		arr.add(TreeNode.data);
		inOrder(TreeNode.right, arr);
	}

	static void preOrder(TreeNode TreeNode, ArrayList<Integer> arr) {
		if (TreeNode == null) {
			return;
		}

		arr.add(TreeNode.data);
		preOrder(TreeNode.left, arr);
		preOrder(TreeNode.right, arr);
	}

	static void postOrder(TreeNode TreeNode, ArrayList<Integer> arr) {
		if (TreeNode == null)
			return;

		postOrder(TreeNode.left, arr);
		postOrder(TreeNode.right, arr);
		arr.add(TreeNode.data);

	}

	public static void main(String[] args) {

//		 Binary tree
//			  1
//			 / \
//			2   3
//		   / \   \
//		  4   5   6
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(6);

		ArrayList<Integer> in = new ArrayList<>();
		ArrayList<Integer> pre = new ArrayList<>();
		ArrayList<Integer> post = new ArrayList<>();

		inOrder(root, in);
		System.out.println("InOrder Traversal: ");
		for (int TreeNode : in) {
			System.out.print(TreeNode + " ");
		}

		preOrder(root, pre);
		System.out.println("\nPreOrder Traversal: ");
		for (int TreeNode : pre) {
			System.out.print(TreeNode + " ");
		}

		postOrder(root, post);
		System.out.println("\nPostOrder Traversal: ");
		for (int TreeNode : post) {
			System.out.print(TreeNode + " ");
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
