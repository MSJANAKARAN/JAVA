package com.jana.datastructure.stack;

import java.util.ArrayList;

public class StackUsingArrayList {

	ArrayList<Integer> arr = new ArrayList<>();

	void push(int val) {
		arr.add(val);
	}
	
	int pop() {
		if(arr.isEmpty()) {
			System.out.println("Stack Underflow");
			return -1;
		}
		
		return arr.remove(arr.size()-1);
	}
	
	int peek() {
		if(arr.isEmpty()) {
			System.out.println("Stack is Empty");
			return -1;
		}
		
		return arr.get(arr.size()-1);
	}
	
	int size() {
		return arr.size();
	}
	
	boolean isEmpty() {
		return arr.isEmpty();
	}
	
	public static void main(String[] args) {

		StackUsingArrayList st = new StackUsingArrayList();

		st.push(10);
		st.push(20);
		st.push(30);
		
		System.out.println("Remove: "+ st.pop());
		System.out.println("Access: "+ st.peek());
		System.out.println("Size: "+ st.size());
		System.out.println("Empty: "+ st.isEmpty());
	}

}
