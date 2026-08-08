package com.jana.datastructure;

import java.util.LinkedList;

public class LinkedListClass {

	public static void main(String[] args) {

		LinkedList<Integer> list= new LinkedList<>();
		
		list.add(10);
		
		list.add(30);
		
		list.add(1,20);
		
		for(Integer i: list) {
			System.out.println(i+" ");
		}
	}
//	Methods for Java LinkedList
//	add(int index, E element)	Inserts element at given index.
//	add(E e)	This method Appends the specified element to the end of this list.
//	addAll(int index, Collection<E> c)	Inserts all elements of collection starting at index.
//	addAll(Collection<E> c)	Appends all elements of collection to end
//	addFirst(E e)	This method Inserts the specified element at the beginning of this list.
//	addLast(E e)	This method Appends the specified element to the end of this list.
//	clear()	This method removes all of the elements from this list.
//	clone()	This method returns a shallow copy of this LinkedList.
//	contains(Object o)	This method returns true if this list contains the specified element.
//	descendingIterator()	This method returns an iterator over the elements in this deque in reverse sequential order.
//	element()	This method retrieves but does not remove, the head (first element) of this list.
//	get(int index)	This method returns the element at the specified position in this list.
//	getFirst()	This method returns the first element in this list.
//	getLast()	This method returns the last element in this list.
//	indexOf(Object o)	Return first index of element or -1 if element is not present
//	lastIndexOf(Object o)	Return Last index of element or -1 if element is not present
//	listIterator(int index)	This method returns a list-iterator of the elements.
//	offer(E e)	This method Adds the specified element as the tail (last element) of this list.
//	offerFirst(E e)	This method Inserts the specified element at the front of this list.
//	offerLast(E e)	This method Inserts the specified element at the end of this list.
//	peek()	This method retrieves but does not remove, the head (first element) of this list.
//	peekFirst()	This method retrieves, but does not remove, the first element of this list or returns null if this list is empty.
//	peekLast()	This method retrieves, but does not remove, the last element of this list or returns null if this list is empty.
//	poll()	This method retrieves and removes the head (first element) of this list.
//	pollFirst()	This method retrieves and removes the first element of this list or returns null if this list is empty.
//	pollLast()	This method retrieves and removes the last element of this list or returns null if this list is empty.
//	pop()	This method Pops an element from the stack represented by this list.
//	push(E e)	This method pushes an element onto the stack represented by this list.
//	remove()	This method retrieves and removes the head (first element) of this list.
//	remove(int index)	This method removes the element at the specified position in this list.
//	remove(Object o)	This method removes the first occurrence of the specified element from this list if it is present.
//	removeFirst()	This method removes and returns the first element from this list.
//	removeFirstOccurrence(Object o)	This method removes the first occurrence of the specified element in this list.
//	removeLast()	This method removes and returns the last element from this list.
//	removeLastOccurrence(Object o)	This method removes the last occurrence of the specified element in this list.
//	set(int index, E element)	This method replaces the element at the specified position in this list with the specified element.
//	size()	This method returns the number of elements in this list.
//	spliterator()	This method creates a late-binding and fail-fast Spliterator over the elements in this list.
//	toArray()	This method returns an array containing all of the elements in this list in proper sequence.
//	toArray(T[] a)	Returns array of all elements in given type.
//	toString()	This method returns string representation of list.
}
