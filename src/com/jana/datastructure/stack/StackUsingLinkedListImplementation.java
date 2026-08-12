package com.jana.datastructure.stack;

public class StackUsingLinkedListImplementation {

	Node top;
	int count;

	public StackUsingLinkedListImplementation() {
		// initial stack is empty
		top = null;
		count = 0;
	}

	class Node {
		public int data;
		public Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	void push(int val) {

		Node temp = new Node(val);
		temp.next = top;
		top = temp;

		count++;
	}

	int pop() {
		if (top == null) {
			System.out.println("Stack Underflow");
			return -1;
		}
		Node temp = top;
		top = top.next;

		int data = temp.data;
		temp = null;

		count--;
		return data;
	}

	int peek() {
		if (top == null) {
			System.out.println("Stack is Empty");
			return -1;
		}
		return top.data;
	}

	boolean isEmpty() {
		return top == null;
	}

	int size() {
//		int count=0;
//		Node temp = top;
//		while(temp!=null) {
//			count++;
//			temp=temp.next;
//		}
		return count;
	}

	public static void main(String[] args) {

		StackUsingLinkedListImplementation st = new StackUsingLinkedListImplementation();
		st.push(10);
		st.push(39);
		st.push(40);
		st.push(0);
		System.out.println("Remove: " + st.pop());

		System.out.println("Access: " + st.peek());

		System.out.println("Size: " + st.size());

		System.out.println("Empty: " + st.isEmpty());

	}

}
