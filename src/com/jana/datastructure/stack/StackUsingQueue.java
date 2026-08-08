package com.jana.datastructure.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

	Queue<Integer> q = new LinkedList<>();
	
	void push(int val) {
		
		q.add(val);
		
//		As we are shifting elements \, last value to first, while isEmpty not used
//		after inserting the element, all previous (n-1) elements must be rotated behind it, 
//		so new value added will be at first place for every time making it a stack
		for(int i=0;i<q.size()-1;i++) {
			q.add(q.poll());
		}
		
	}
	
	int pop() {
		if(q.size()==0) {
			System.out.println("Stack is Empty");
			return -1;
		}
		
		return q.poll();
	}

	int peek() {
		if(q.size()==0) {
			System.out.println("Stack is Empty");
			return -1;
		}
		
		return q.peek();
	}
	
	boolean isEmpty() {
		return q.isEmpty();
	}
	
	int size() {
		return q.size();
	}
	
	public static void main(String[] args) {
		// Push O(n) Pop O(1)

		StackUsingQueue st = new StackUsingQueue();
		st.push(10);
		st.push(39);
		st.push(40);
		st.push(0);

		System.out.println("Remove: " + st.pop());

		System.out.println("Access: " + st.peek());

		System.out.println("Size: " + st.size());

		System.out.println("Empty: " + st.isEmpty());
	}

//	Stack is used for DFS (Depth-First Search).
//	Queue is used for BFS (Breadth-First Search).
}
