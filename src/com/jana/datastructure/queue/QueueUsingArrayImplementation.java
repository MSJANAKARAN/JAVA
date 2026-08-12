package com.jana.datastructure.queue;

public class QueueUsingArrayImplementation {
	private int[] arr;

	private int capacity;

	private int size;

	public QueueUsingArrayImplementation(int cap) {
		arr = new int[cap];
		capacity = cap;
		size = 0;
	}

	void enqueue(int val) {
		if (capacity == size) {
			System.out.println("Queue is Full");
		}
		arr[size++] = val;
	}

	int dequeue() {
		if (size == 0) {
			System.out.println("Queue is empty");
			return -1;
		}

		int removal = arr[0];
		for (int i = 1; i < size; i++) {
			arr[i - 1] = arr[i];
		}
		size--;
		
		return removal;
	}

	int getFront() {
		if (size == 0) {
			System.out.println("Queue is empty");
			return -1;
		}

		return arr[0];
	}

	int getRear() {
		if (size == 0) {
			System.out.println("Queue is empty");
			return -1;
		}
		return arr[size - 1];
	}

	boolean isEmpty() {
		return size == 0;
	}

	boolean isFull() {
		return capacity == size;
	}

	public static void main(String[] args) {
		QueueUsingArrayImplementation q = new QueueUsingArrayImplementation(5);

		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);

		System.out.println("Remove: "+q.dequeue());

		System.out.println("Access first: " + q.getFront());

		System.out.println("Access last: " + q.getRear());

	}
//	The dequeue operation takes O(n) time due to element shifting. 
//	To achieve O(1) time for both enqueue and dequeue, 
//	we use a circular array implementation of queue.

}
