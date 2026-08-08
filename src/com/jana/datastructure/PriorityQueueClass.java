package com.jana.datastructure;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueClass {

//	A PriorityQueue in Java is a queue where elements are ordered based on their priority, 
//	rather than the order of insertion. By default, it uses natural ordering (min-heap)
//
//	Elements are processed based on priority rather than insertion order.
//	Supports standard queue operations like add(), poll(), and peek().
//	Automatically grows as elements are added and null insertion is not possible .
//	Uses a heap data structure internally to ensure efficient insertion and removal of the highest-priority element.
	public static void main(String[] args) {
		Queue<Integer> pq = new PriorityQueue<>();

		pq.add(20);
		System.out.println("Queue: " + pq);

		pq.add(10);
		System.out.println("Queue: " + pq);

		pq.add(30);
		System.out.println("Queue: " + pq);

		pq.add(15);
		System.out.println("Queue: " + pq);

		pq.add(35);
		System.out.println("Queue: " + pq);

		System.out.println("Remove: " + pq.remove());

		System.out.println("Access: " + pq.peek());

		Iterator<Integer> i = pq.iterator();

		while (i.hasNext()) {
			System.out.println(i.next() + " ");
		}

	}
	
//	Methods of Queue Interface
//	add(E e)	Inserts the specified element; throws exception if insertion fails.
//	offer(E e)	Inserts the specified element; returns false if insertion fails.
//	remove()	Removes and returns the head of the queue; throws exception if empty.
//	poll()	Removes and returns the head; returns null if empty.
//	peek()	Retrieves, but does not remove, the head; returns null if empty.
//	size()	Returns the number of elements in the queue.
//	isEmpty()	Returns true if the queue contains no elements.
//	contains(Object o)	Returns true if the queue contains the specified element.
//	iterator()	Returns an iterator over the elements in the queue.
//	toArray()	Converts the queue elements into an array.
//	addFirst(E e)	Inserts element at the front (Deque only).
//	addLast(E e)	Inserts element at the end (Deque only).
//	offerFirst(E e)	Inserts element at the front; returns false if fails (Deque only).
//	offerLast(E e)	Inserts element at the end; returns false if fails (Deque only).
//	removeFirst()	Removes and returns the first element (Deque only).
//	removeLast()	Removes and returns the last element (Deque only).
//	pollFirst()	Removes and returns the first element; returns null if empty (Deque only).
//	pollLast()	Removes and returns the last element; returns null if empty (Deque only).
//	getFirst()	Retrieves, but does not remove, the first element (Deque only).
//	getLast()	Retrieves, but does not remove, the last element (Deque only).
//	peekFirst()	Retrieves, but does not remove, the first element; returns null if empty (Deque only).
//	peekLast()	Retrieves, but does not remove, the last element; returns null if empty (Deque only).
//	put(E e)	Inserts element, waits if necessary (BlockingQueue only).
//	take()	Removes and returns head element, waits if empty (BlockingQueue only).

}
