package com.jana.datastructure.queue;

import java.util.Stack;

public class QueueUsingTwoStacksImplementation {

//	Enqueue in O(n) and Dequeue() in O(1)
	static class Queue1 {
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();

		void enqueue(int val) {
			// Move all elements from s1 to s2
			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}
			// Push the new item into s1, now new item is the 1st element
			s1.push(val);

			while (!s2.isEmpty()) {
				s1.push(s2.pop());
			}
		}

		int dequeue() {
			if (s1.size() == 0) {
				System.out.println("Queue is empty");
				return -1;
			}

			return s1.pop();
		}

		int getFront() {
			if (s1.size() == 0) {
				System.out.println("Queue is empty");
				return -1;
			}
			return s1.peek();
		}

		boolean isEmpty() {
			return s1.isEmpty();
		}

		int size() {
			return s1.size();
		}
	}

//	Enqueue in O(1) and Dequeue() in O(n)
	static class Queue2 {
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();

		void enqueue(int val) {
			s1.push(val);
		}
//		if s2 is not empty then top of s2 needs to be returned. 
//		Otherwise all elements are transferred from s1 to s2, 
//		and the element at the top of s2 is returned.
		int dequeue() {
			if (s1.size() == 0 && s2.size()==0) {
				System.out.println("Queue is empty");
				return -1;
			}

			if (s2.isEmpty()) {
				while (!s1.isEmpty()) {
					s2.push(s1.pop());
				}
			}

			return s2.pop();
		}

		int getFront() {
			if (s2.size() != 0) {
				return s2.peek();
			}

			// Move elements to s2 to access front
			if (s1.size() != 0) {
				while (!s1.isEmpty()) {
					s2.push(s1.pop());
				}
				return s2.peek();
			}

			System.out.println("Queue is empty");
			return -1;
		}

		boolean isEmpty() {
			return s1.isEmpty() && s2.isEmpty();
		}

		int size() {
			return s1.size()+s2.size();
		}
	}

	public static void main(String[] args) {

//		Enqueue in O(n) and Dequeue() in O(1)
//		Queue1 q = new Queue1();
//		Enqueue in O(1) and Dequeue() in O(n)
		Queue2 q = new Queue2();

		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);

		System.out.println("Remove: " + q.dequeue());

		System.out.println("Access first: " + q.getFront());

		System.out.println("Size: " + q.size());

		System.out.println("Empty: " + q.isEmpty());

	}

}
