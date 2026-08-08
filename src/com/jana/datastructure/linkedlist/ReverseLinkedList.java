package com.jana.datastructure.linkedlist;

import com.jana.datastructure.linkedlist.SinglyLinkedList.Node;

public class ReverseLinkedList {

	public static void main(String[] args) {
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);

		SinglyLinkedList.printList(head);
		Node reversed = reverseList(head);
		SinglyLinkedList.printList(reversed);

	}

	private static Node reverseList(Node head) {
		if(head == null || head.next == null) {
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
}
