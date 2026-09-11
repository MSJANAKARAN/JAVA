package com.jana.datastructure.linkedlist;

import com.jana.datastructure.linkedlist.SinglyLinkedList.Node;

public class ReverseLinkedList {

	public static void main(String[] args) {
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);

		SinglyLinkedList.printList(head);

//		Node reversed = reverseList(head);
		Node reversed = reverseListRecursive(head);

		SinglyLinkedList.printList(reversed);
	}

	private static Node reverseList(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node current = head;
		Node next, prev = null;

		while (current != null) {
			next = current.next;

			current.next = prev;

			prev = current;

			current = next;
		}
		return prev;
	}

	private static Node reverseListRecursive(Node head) {
		// Base Case: If list is empty or has reached the last node
		if (head == null || head.next == null)
			return head;
		// Reverse the rest of the list first
		Node newHead = reverseListRecursive(head.next);
		// Rearrange pointers: make the next node point back to the current node
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
}
