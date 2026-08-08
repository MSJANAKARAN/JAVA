package com.jana.datastructure.linkedlist.circular;

public class CircularLinkedList {
	public static class Node {
		int data;
		Node next;

		public Node(int d) {
			this.data = d;
			this.next = null;
		}
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

	public static void printList(Node head) {

		Node temp = head;
		int count = 20;
		System.out.print("Circular Linked List(%d): ".formatted(count));

		while (temp != null && count-- > 0) {
			System.out.print(temp.data);
			if (temp.next != null) {
				System.out.print(" -> ");

			}
			temp = temp.next;
		}
		System.out.println();

	}

	public static void main(String[] args) {
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);

		Node last = head.next.next.next;
		last.next = head;

		printList(head);

		System.out.println("Length of Circular Linked List: " + printLength(head));
	}

}
