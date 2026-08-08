package com.jana.datastructure.queue;

import java.util.Stack;

public class QueueUsingStack {

//	Enqueue in O(1) and Dequeue() in O(n)

	Stack<Integer> s = new Stack<>();

	void enqueue(int val) {
		s.push(val);
	}

//		if s2 is not empty then top of s2 needs to be returned. 
//		Otherwise all elements are transferred from s1 to s2, 
//		and the element at the top of s2 is returned.
	int dequeue() {

		if (s.isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		}

//		 If stack becomes empty after popping,
//		 this was the bottom (front of queue)
		int val = s.pop();

		if (s.isEmpty()) {
			return val;
		}
//		Recursive call to remove bottom element
		int item = dequeue();

//		Restore stack, except last element, others will be pushed
		s.push(val);

		return item;
	}

	int getFront() {
		if (s.isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		}

		int val = s.pop();

		if (s.isEmpty()) {
			s.push(val);
			return val;
		}

		int item = getFront();
		// restore stack
		s.push(val);

		return item;
	}

	boolean isEmpty() {
		return s.isEmpty();
	}

	int size() {
		return s.size();
	}

	public static void main(String[] args) {

//		Enqueue in O(1) and Dequeue() in O(n)
		QueueUsingStack q = new QueueUsingStack();

		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);

		System.out.println("Remove: " + q.dequeue());

		System.out.println("Access first: " + q.getFront());

		System.out.println("Size: " + q.size());

		System.out.println("Empty: " + q.isEmpty());

	}

//	Stack is used for DFS (Depth-First Search).
//	Queue is used for BFS (Breadth-First Search).
}
