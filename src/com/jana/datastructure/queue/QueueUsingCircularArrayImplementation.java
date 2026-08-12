package com.jana.datastructure.queue;

public class QueueUsingCircularArrayImplementation {
	private int[] arr;

	private int capacity;

	private int size;

	private int front;

	public QueueUsingCircularArrayImplementation(int cap) {
		arr = new int[cap];
		capacity = cap;
		size = 0;
		front = 0;
	}

	void enqueue(int val) {
		// Insert an element at the rear
		if (capacity == size) {
			System.out.println("Queue is Full");
		}
		int rear = (front + size) % capacity;
		arr[rear] = val;
		size++;
	}

	int dequeue() {
		// Remove an element from the front
		if (size == 0) {
			System.out.println("Queue is empty");
			return -1;
		}

		int val = arr[front];
		front = (front + 1) % capacity;
//		while decrementing size, val can't be able to access
		size--;
		return val;

		
		
	}

	int getFront() {
		if (size == 0) {
			System.out.println("Queue is empty");
			return -1;
		}

		return arr[front];
	}

	int getRear() {
		if (size == 0) {
			System.out.println("Queue is empty");
			return -1;
		}
		int rear = (front + size - 1) % capacity;
		return arr[rear];
	}

	boolean isEmpty() {
		return size == 0;
	}

	boolean isFull() {
		return capacity == size;
	}

	public static void main(String[] args) {
		QueueUsingCircularArrayImplementation q = new QueueUsingCircularArrayImplementation(5);

		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);

		System.out.println("Remove: " + q.dequeue());

		System.out.println("Access first: " + q.getFront());

		System.out.println("Access last: " + q.getRear());

	}
//	The dequeue operation takes O(n) time due to element shifting in simple array. 
//	To achieve O(1) time for both enqueue and dequeue, 
//	we use a circular array implementation of queue.

//	Working of circular array(Where f is front of queue)
//	Index		0		1		2		3
//	add			10									f=10, size=1, rear=40
//				fr
//	add			10		20							f=10, size=2, rear=40
//				f		r
//	add			10		20		40					f=10, size=3, rear=40
//				f				r
//	remove				20		40					f=20, size=2, rear=40
//						f		r
//	add 				20		40		25			f=20, size=3, rear=25
//						f				r
//	add			50		20		40		25			f=20, size=4, rear=50
//				r		f
}
