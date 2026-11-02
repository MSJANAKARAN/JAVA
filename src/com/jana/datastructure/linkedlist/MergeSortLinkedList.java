package com.jana.datastructure.linkedlist;

import com.jana.datastructure.linkedlist.SinglyLinkedList.Node;

public class MergeSortLinkedList {

	public static void main(String[] args) {
		Node head = new Node(10);
		head.next = new Node(30);
		head.next.next = new Node(20);
		head.next.next.next = new Node(50);
		head.next.next.next = new Node(60);
		head.next.next.next = new Node(40);

		SinglyLinkedList.printList(head);
		Node sorted = mergeSort(head);
		SinglyLinkedList.printList(sorted);
	}

	public static Node mergeSort(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node mid = middleLeft(head);
		Node left = head;
		Node right = mid.next;
		mid.next = null;

		return merge(left, right);
	}

	public static Node merge(Node left, Node right) {
		Node dummy = new Node(0);
		Node temp = dummy;

		while (left != null && right != null) {
			if (left.data < right.data) {
				temp.next = left;
				left = left.next;
			} else {
				temp.next = right;
				right = right.next;
			}
			temp = temp.next;
		}

		temp.next = left != null ? left : right;
		return dummy.next;
	}

	public static Node middleLeft(Node head) {
		Node slow = head;
		Node fast = head.next;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
}
