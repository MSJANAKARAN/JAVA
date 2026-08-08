package com.jana.datastructure;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class ArrayDequeClass {

//	ArrayDeque is a resizable-array implementation of the Deque interface in Java. 
//	it allows elements to be added or removed from both ends efficiently and it not allow null element insertion .
//
//	ArrayDeque grows dynamically.
//	It generally provides faster operations than LinkedList as it is more cache friendly and 
//	does not require overhead of next previous reference management.
//	Operations like addFirst(), addLast(), removeFirst(), removeLast() are done in O(1) amortized time.
//	ArrayDeque is not Thread-Safe
	public static void main(String[] args) {

		Deque<Integer> d = new ArrayDeque<>();

		d.addFirst(10);
		d.push(30);
		d.offerLast(40);

		System.out.println("Deque: " + d);

		for (Iterator<Integer> i = d.iterator(); i.hasNext();) {
			System.out.print(i.next() + " ");
		}

		System.out.println();

		for (Iterator<Integer> i = d.descendingIterator(); i.hasNext();) {
			System.out.print(i.next() + " ");
		}
	}
//  Methods in ArrayDeque class
//	add(Element e)	The method inserts a particular element at the end of the deque.
//	addAll​(Collection<? extends E> c)	Adds all of the elements in the specified collection at the end of this deque, as if by calling addLast(E) on each one, in the order that they are returned by the collection's iterator.
//	addFirst(Element e)	The method inserts particular element at the start of the deque.
//	addLast(Element e) 	The method inserts a particular element at the end of the deque. It is similar to the add() method
//	clear() 	The method removes all deque elements.
//	clone()	The method copies the deque.
//	contains(Obj)	The method checks whether a deque contains the element or not
//	element() 	The method returns element at the head of the deque
//	forEach​(Consumer<? super E> action)	Performs the given action for each element of the Iterable until all elements have been processed or the action throws an exception.
//	getFirst()	The method returns first element of the deque
//	getLast()	The method returns last element of the deque
//	isEmpty()	The method checks whether the deque is empty or not.
//	iterator()	Returns an iterator over the elements in this deque.
//	offer(Element e)	The method inserts element at the end of deque.
//	offerFirst(Element e) 	The method inserts element at the front of deque.
//	offerLast(Element e)	The method inserts element at the end of the deque.
//	peek()	The method returns head element without removing it.
//	poll()	The method returns head element and also removes it
//	pop()	The method pops out an element for stack represented by deque
//	push(Element e)	The method pushes an element onto stack represented by deque
//	remove()	The method returns head element and also removes it
//	remove​(Object o)	Removes a single instance of the specified element from this deque.
//	removeAll​(Collection<?> c)	Removes all of this collection's elements that are also contained in the specified collection (optional operation).
//	removeFirst()	The method returns the first element and also removes it
//	removeFirstOccurrence​(Object o)	Removes the first occurrence of the specified element in this deque (when traversing the deque from head to tail).
//	removeIf​(Predicate<? super Element> filter)	Removes all of the elements of this collection that satisfy the given predicate.
//	removeLast()	The method returns the last element and also removes it
//	removeLastOccurrence​(Object o)	Removes the last occurrence of the specified element in this deque (when traversing the deque from head to tail).
//	size()	Returns the number of elements in this deque.
//	spliterator()	Creates a late-binding and fail-fast Spliterator over the elements in this deque.
//	toArray()	Returns an array containing all of the elements in this deque in proper sequence (from first to the last element).

}
