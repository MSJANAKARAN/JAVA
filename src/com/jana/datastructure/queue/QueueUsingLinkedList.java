package com.jana.datastructure.queue;

public class QueueUsingLinkedList {

	private Node front;
	private Node rear;
	private int size;

	class Node {
		public int data;
		public Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	QueueUsingLinkedList() {
		front = null;
		rear = null;
		size = 0;
	}

	void enqueue(int val) {
		Node temp = new Node(val);

		if (front == null) {
			front = rear=temp;
			size++;
		}else {
			rear.next=temp;
			rear= temp;
		}
		
		size++;
	}

	int dequeue() {
		if (front == null) {
			System.out.println("Queue is empty");
			return -1;
		}
		Node temp= front;
		int val=temp.data;
		front=front.next;
		if(front ==null) {
			rear=null;
		}
		size--;
		return val;
	}

	private int getRear() {
		if (front == null) {
			System.out.println("Queue is empty");
			return -1;
		}

		return rear.data;
	}

	private int getFront() {
		if (front == null) {
			System.out.println("Queue is empty");
			return -1;
		}

		return front.data;
	}

	boolean isEmpty() {
		return front == null;
	}

	int size() {
		return size;
	}

	public static void main(String[] args) {

		QueueUsingLinkedList q = new QueueUsingLinkedList();

		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);

		System.out.println("Remove: " + q.dequeue());

		System.out.println("Access first: " + q.getFront());

		System.out.println("Access last: " + q.getRear());

		System.out.println("Size: " + q.size());

		System.out.println("Empty: " + q.isEmpty());

	}

}
