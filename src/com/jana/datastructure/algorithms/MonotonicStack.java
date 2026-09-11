package com.jana.datastructure.algorithms;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class MonotonicStack {

	public static void main(String[] args) {
//		Stack / Monotonic Stack
//		Next greater/smaller, previous greater/smaller, parentheses

//		Valid Parentheses
		String parentheses1 = "{([{}})}";
		String parentheses2 = "{([{}])}";

		System.out.println("Valid Parentheses: " + isValidParentheses(parentheses1));
		System.out.println("Valid Parentheses: " + isValidParentheses(parentheses2));

//		Next Greater Element
		int[] arr = { 2, 1, 5, 3 };
		System.out.println("Next Greater Element: " + Arrays.toString(nextGreaterElement(arr)));
		System.out.println("Next Greater Element(Effective right to left): " + Arrays.toString(nextGreaterElement(arr)));

//		Min Stack
//		goal is to design a stack that supports push, pop, top, and retrieving the minimum element in O(1) constant time.

		MinStack stack = new MinStack();
		
		stack.push(4);
		stack.push(2);
		stack.pop();
		stack.push(3);
		stack.push(7);
		System.out.println("Stack minimum: "+stack.getMin());
		System.out.println("Stack top: "+stack.top());


	}

	static boolean isValidParentheses(String s) {

		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else {
				if (stack.isEmpty())
					return false;

				char top = stack.pop();

				if ((top != '{' && c == '}') || (top != '[' && c == ']') || (top != '(' && c == ')')) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	static int[] nextGreaterElement(int arr[]) {
		int[] result = new int[arr.length];
		Arrays.fill(result, -1);

		Deque<Integer> stack = new ArrayDeque<>();

		for (int i = 0; i < arr.length; i++) {
			while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
				result[stack.pop()] = arr[i];
			}
			stack.push(i);
		}
		return result;
	}
	
	static int[] nextGreaterElement1(int arr[]) {
		int[] result = new int[arr.length];

		Deque<Integer> stack = new ArrayDeque<>();

		for(int i=arr.length-1;i>=0;i--) {
			while(!stack.isEmpty() && stack.peek()<=arr[i]) {
				stack.pop();
			}
			if(!stack.isEmpty()) {
				result[i]=stack.peek();
			}else {
				result[i]=-1;
			}
			stack.push(arr[i]);
		}
		return result;
	
	}

	static class MinStack {
		Deque<Integer> stack = new ArrayDeque<>();
		Deque<Integer> minStack = new ArrayDeque<>();

		public void push(int x) {
			stack.push(x);
			if (minStack.isEmpty() || x <= minStack.peek()) {
				minStack.push(x);
			}
		}

		public void pop() {
			int x = stack.pop();

			if (x == minStack.peek()) {
				minStack.pop();
			}
		}

		public int getMin() {
			return minStack.peek();
		}
		
		public int top() {
			return stack.peek();
		}
	}
}
