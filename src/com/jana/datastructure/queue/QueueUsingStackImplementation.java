package com.jana.datastructure.queue;

import java.util.Stack;

public class QueueUsingStackImplementation {

//	Enqueue in O(n) and Dequeue() in O1n)
	static class Queue1 {
		Stack<Integer> s = new Stack<>();

		// 1. Enqueue: Uses recursion to insert the element at the bottom (O(N))
		void enqueue(int data) {
			// Base case: If stack is empty, push the item directly
			if (s.isEmpty()) {
				s.push(data);
				return;
			}

			// Hold all top elements in the recursive call stack
			int topElement = s.pop();

			// Recursively move towards the bottom of the stack
			enqueue(data);

			// Push the held elements back on top of the newly inserted bottom element
			s.push(topElement);
		}

		int dequeue() {
			if (s.isEmpty()) {
				System.out.println("Queue Underflow! The queue is empty.");
				return -1;
			}
			return s.pop();
		}

		int getFront() {
			if (s.isEmpty()) {
				System.out.println("Queue Underflow! The queue is empty.");
				return -1;
			}
			return s.peek();
		}

		boolean isEmpty() {
			return s.isEmpty();
		}

		int size() {
			return s.size();
		}
	}

//	Enqueue in O(1) and Dequeue() in O(n)
	static class Queue2 {
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
	}

	public static void main(String[] args) {
//		Enqueue in O(n) and Dequeue() in O(1)
		Queue1 q = new Queue1();
//		Enqueue in O(1) and Dequeue() in O(n)
//		Queue2 q= new Queue2();
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
