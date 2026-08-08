package com.jana.datastructure.linkedlist.doubly;

public class DoublyLinkedList {

	// Non Static Class, called by instantiating the class as new object creation
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

	public int printLength(Node head) {
		Node temp = head;
		int count = 0;
		while (temp != null) {
			temp = temp.next;
			count++;
		}
		return count;
	}

	public void printList(Node head) {
		Node temp = head;
		System.out.print("Doubly Linked List: ");

		while (temp != null) {
			System.out.print(temp.data);
			if (temp.next != null) {
				System.out.print(" <-> ");

			}
			temp = temp.next;
		}
		System.out.println();

	}

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();

		Node head = list.new Node(10);

		head.next = list.new Node(20);
		head.next.prev = head;

		head.next.next = list.new Node(30);
		head.next.next.prev = head.next;

		head.next.next.next = list.new Node(40);
		head.next.next.next.prev = head.next.next;

		list.printList(head);
		System.out.println("Doubly Linked List: " + list.printLength(head));
	}

}
