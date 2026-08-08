package com.jana.datastructure;

import java.util.Stack;

public class StackClass {
//	Stack is a linear data structure that follows the Last In First Out (LIFO) principle
//	New elements are always pushed on top.
//	Removal (pop) also happens only from the top.
//	This ensures a strict order: last in → first out.
//	Stack Class is defined in the java.util package. Internally, it extends the Vector class.
//	Stack class maintains insertion order and allows duplicates and null values.
//	Grows dynamically when its capacity is exceeded
//
//	It is a legacy collection from early Java versions. It is outdated and rarely used in modern Java
//	It's synchronized and thread-safe, which can be slower in single-threaded applications
	public static void main(String[] args) {
		//Create a stack
		Stack<Integer> s = new Stack<>();
		//Add elements
		s.push(10);
		s.push(20);
		s.push(30);
		System.out.println("Stack: "+s);
		
		//Remove elements
		System.out.println("Remove: "+s.pop());
		//Access elements
		System.out.println("Access: "+s.peek());

		
		
	}
	
//	Methods in Stack Class
//
//	empty() => This method returns true if the stack contains no elements at all, and false otherwise.
//
//	peek() => This method returns the element on the top of the stack, but does not remove it.
//
//	pop() => This method removes and returns the top element of the stack.
//
//	push(Object element) => This method pushes an element on the top of the stack.
//
//	search(Object element) => This method is used to determine whether an object exists in the stack. If the element is found. It returns the position of the element from the top of the stack. Else, it returns -1.

}
