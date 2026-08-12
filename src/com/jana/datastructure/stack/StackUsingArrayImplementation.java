package com.jana.datastructure.stack;

public class StackUsingArrayImplementation {

	private int[] arr;

	private int capacity;

	private int top;

	public StackUsingArrayImplementation(int cap) {
		capacity = cap;
		arr = new int[capacity];
		top = -1;
	}

	public void push(int val) {
		if (top == capacity - 1) {
			System.out.println("Stack Overflow");
			return;
		}

		arr[++top] = val;

	}

	public int peek() {
		if (top == -1) {
			System.out.println("Stack is Empty");
			return -1;
		}
		return arr[top];
	}

	public int pop() {
		if (top == -1) {
			System.out.println("Stack Underflow");
			return -1;
		}
		return arr[top--];
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == capacity - 1;
	}

	public static void main(String[] args) {

		StackUsingArrayImplementation stack = new StackUsingArrayImplementation(5);

		stack.push(10);
		stack.push(30);
		stack.push(40);
		stack.push(60);

		// Remove elements
		System.out.println("Remove: " + stack.pop());
		// Access elements
		System.out.println("Access: " + stack.peek());

	}
//	We can use dynamic array like ArrayList to make stack dynamic

}
