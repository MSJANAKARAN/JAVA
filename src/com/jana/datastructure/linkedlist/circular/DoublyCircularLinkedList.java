package com.jana.datastructure.linkedlist.circular;

import com.jana.datastructure.linkedlist.circular.CircularLinkedList.Node;
import com.jana.datastructure.linkedlist.doubly.DoublyLinkedList;

public class DoublyCircularLinkedList {

	public class Node {
		int data;
		Node next;
		Node prev;

		Node(int data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	public static void printList(Node head) {

		Node temp = head;
		int count = 20;
		System.out.print("Circular Doubly Linked List(%d): ".formatted(count));

		while (temp != null && count-- > 0) {
			System.out.print(temp.data);
			if (temp.next != null) {
				System.out.print(" -> ");

			}
			temp = temp.next;
		}
		System.out.println();

	}

	public static int printLength(Node head) {
		Node fast = head;
		Node slow = head;
		int count = 0;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			count++;

			if (fast == slow) {
				return count;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		DoublyCircularLinkedList list = new DoublyCircularLinkedList();

		Node head = list.new Node(10);

		head.next = list.new Node(20);
		head.next.prev = head;

		head.next.next = list.new Node(30);
		head.next.next.prev = head.next;

		head.next.next.next = list.new Node(40);
		head.next.next.next.prev = head.next.next;

		Node last = head.next.next.next;

		last.next = head;
		head.prev = last;

		printList(head);

		System.out.println("Length of Circular Doubly Linked List: " + printLength(head));
	}
}
