package com.jana.datastructure.linkedlist;

public class SinglyLinkedList {
	// Static Class, global instance created in class during JVM startup

	public static class Node {
		int data;
		Node next;

		public Node(int d) {
			this.data = d;
			this.next = null;
		}
	}

	public static int printLength(Node head) {
		Node temp = head;
		int count = 0;
		while (temp != null) {
			temp = temp.next;
			count++;
		}
		return count;
	}

	public static void printList(Node head) {
		Node temp = head;
		System.out.print("Singly Linked List: ");

		while (temp != null) {
			System.out.print(temp.data);
			if (temp.next != null) {
				System.out.print(" -> ");
			}
			temp = temp.next;
		}
		System.out.println();
	}

	public static boolean searchPresent(Node head, int key) {
		Node temp = head;

		while (temp != null) {
			if (temp.data == key) {
				return true;
			}
			temp = temp.next;
		}

		return false;
	}

	public static Node insertAtFront(Node head, int key) {
		System.out.println("Insert At Front [ data: %d]".formatted(key));

		Node insertNode = new Node(key);
		insertNode.next = head;
		return insertNode;
	}

	public static Node insertAtEnd(Node head, int key) {
		System.out.println("Insert At End [ data: %d]".formatted(key));

		Node temp = head;
		Node insertNode = new Node(key);
		if (temp == null) {
			return insertNode;
		}
		while (temp.next != null) {

			temp = temp.next;
		}

		temp.next = insertNode;
//		head and temp do not contain the actual node data. Instead, they store references (memory addresses) that point to objects allocated on the heap
//		When you assign Node temp = head;, you copy the memory address from head into temp. Both variables are now pointing to the exact same memory location
//		When the while loop executes temp = temp.next;, you are performing reference reassignment.
		return head;
	}

	public static Node insertAt(Node head, int pos, int key) {
		System.out.println("Insert At [position: %d, data: %d]".formatted(pos, key));

		if (pos < 1) {
			return head;
		}
		// Insert at Front
		if (pos == 1) {
			Node insertNode = new Node(key);
			insertNode.next = head;
			return insertNode;
		}
		Node temp = head;
		int index = 1;
		// As Singly Linked List one directional, go to prev node of position specified
		while (index++ < pos - 1 && temp != null) {

			temp = temp.next;

		}

		// position higher than length of list, node remains unchanges
		if (temp == null) {
			return head;
		}

		Node insertNode = new Node(key);
		insertNode.next = temp.next;
		temp.next = insertNode;
		return head;
	}

	public static Node insertAfter(Node head, int key, int newData) {
		System.out.println("Insert After [key: %d, data: %d]".formatted(key, newData));

		Node temp = head;
		// finding node of key
		while (temp != null) {
			if (temp.data == key) {
				break;
			}
			temp = temp.next;
		}

		// data not present in list, node remains unchanges
		if (temp == null) {
			return head;
		}

		Node insertNode = new Node(newData);
		insertNode.next = temp.next;
		temp.next = insertNode;
		return head;
	}

	public static Node insertBefore(Node head, int key, int newData) {
		System.out.println("Insert Before [key: %d, data: %d]".formatted(key, newData));

		Node temp = head;
		// finding previous node of key
		while (temp != null) {
			if (temp.next != null && temp.next.data == key) {
				break;
			}
			temp = temp.next;
		}
		// data not present in list, node remains unchanges, else go inside and isnert
		if (temp != null) {
			Node insertNode = new Node(newData);
			insertNode.next = temp.next;
			temp.next = insertNode;
		}

		return head;
	}

	private static int nthNodeStart(Node head, int i) {
		int key = -1;
		Node temp = head;
		int index = 1;
		while (temp != null) {
			if (index == i) {
				key = temp.data;
			}
			index++;
			temp = temp.next;
		}

		return key;
	}

	private static int nthNodeEnd(Node head, int i) {
		int length = printLength(head);
		int key = -1;
		Node temp = head;
		int index = 1;
		while (temp != null) {
			if (index == length - i + 1) {
				key = temp.data;
			}
			index++;
			temp = temp.next;
		}

		return key;
	}

	public static Node deleteAtFront(Node head) {
		System.out.println("Delete At Front: ");

		if (head == null || head.next == null) {
			return null;
		}
		Node temp = head;
		head = head.next;
		// Free the memory of the old head node
		temp = null;

		return head;
	}

	public static Node deleteAtEnd(Node head) {
		System.out.println("Delete At End: ");

		if (head == null || head.next == null) {
			return null;
		}

		Node temp = head;

		while (temp.next.next != null) {
			temp = temp.next;
		}
		temp.next = null;
		return head;
	}

	public static Node deleteByPosition(Node head, int pos) {
		System.out.println("Delete At Node [pos: %d]".formatted(pos));
		if (head == null) {
			return null;
		}

		if (pos == 1) {
			return head.next;
		}
		Node temp = head;
		// considering pos=1 is head, not index based, locating prev of pos
		for (int i = 1; i < pos - 1; i++) {
			if (temp == null) {
				break;
			}
			temp = temp.next;
		}

		// Position is out of bounds (target doesn't exist)
		if (temp == null || temp.next == null) {
			return head;
		}

		temp.next = temp.next.next;
		return head;

//		Geeks for Geeks solution
//		  Node temp = head;
//	        // Head is to be deleted
//	        if (position == 1) {
//	            head = temp.next;
//	            return head;
//	        }
//	        // Traverse to the node before 
//	        // the one to be deleted
//	        Node prev = null;
//	        for (int i = 1; i < position; i++) {
//	            prev = temp;
//	            temp = temp.next;
//	        }
//	        // Delete the node at the position
//	        prev.next = temp.next;
//	        return head;
	}

	public static void main(String[] args) {
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);

		printList(head);

		System.out.println("Length of Singly Linked List: " + printLength(head));

		System.out.println("Element presemt: " + searchPresent(head, 30));

//		To Insert/Delete at front, we are altering head memory, so reassigning head value
		head = insertAtFront(head, 60);
		printList(head);

		printList(insertAtEnd(head, 50));

		printList(insertAt(head, 3, 70));

		printList(insertAfter(head, 10, 80));

		printList(insertBefore(head, 20, 90));

		System.out.println("Nth Node from Start: " + nthNodeStart(head, 3));

		System.out.println("Nth Node from End: " + nthNodeEnd(head, 5));

		head = deleteAtFront(head);
		printList(head);

		printList(deleteAtEnd(head));

		printList(deleteByPosition(head, 2));

		// Delete a linkedList
		// Set head to null to remove the reference to the linked list.
		// This allows Java's garbage collector to automatically clean up
		// the memory used by the nodes, as there are no more references
		// to the nodes in the linked list.
		// head = null;
	}

}
