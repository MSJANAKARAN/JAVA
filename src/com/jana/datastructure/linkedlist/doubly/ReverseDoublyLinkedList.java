package com.jana.datastructure.linkedlist.doubly;

import com.jana.datastructure.linkedlist.doubly.DoublyLinkedList.Node;

public class ReverseDoublyLinkedList {

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
		Node reversed = reverseList(head);
		list.printList(reversed);
	}

	private static Node reverseList(Node head) {

		if (head == null || head.next == null) {
			return head;
		}

//		Node current = head;
//		Node prev=null, next;
//
//		while (current != null) {
//			next = current.next;
//			prev = current.prev;
//			current.next= prev;
//			current.prev = next;
//						
//			current=next;
//		}

		Node current = head;
		Node temp = null;

		while (current != null) {
//			swap next and prev
			temp = current.prev;
			current.prev = current.next;
			current.next = temp;

//			point to next node which is prev
			current = current.prev;
		}

		return temp.prev;
		
//		Solution with swapping in opposite
//		Node current = head;
//        Node newHead = null;
//
//        while (current != null) {
//            // 1. Save the original forward node before modifying current pointers
//            Node temp = current.next;
//
//            // 2. Perform the swap exactly as you requested
//            current.next = current.prev;
//            current.prev = temp;
//
//            // 3. Track the last non-null node processed, which will become our new head
//            newHead = current;
//
//            // 4. Advance forward safely using the saved reference
//            current = temp;
//        }
//
//        // Return the new front of the list
//        return newHead;
	}

}
