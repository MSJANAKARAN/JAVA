package com.jana.datastructure.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackUsingDeque {

	public static void main(String[] args) {

		Deque<Integer> stack = new ArrayDeque<>();
		
		stack.push(20);
		stack.push(40);
		stack.push(10);
		stack.push(30);
		
		System.out.println("Stack: "+stack);
		System.out.println("Remove: "+stack.pop());
		System.out.println("Access: "+stack.peek());

	}

//	Feature					Stack				ArrayDeque				LinkedList
//	Synchronization			Yes						No						No
//	Backing Structure		Array (Vector)		Resizable Array		Doubly-Linked List
//	Null Elements			Yes						No						Yes
//	Use as Queue			No						Yes						Yes
//	Performance				Slower				Fastest					Moderate
//	Memory Overhead			Moderate				Low						High
//	Thread Safety			Synchronized		Not thread-safe			Not thread-safe
}
