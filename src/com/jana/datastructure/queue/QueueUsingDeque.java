package com.jana.datastructure.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueUsingDeque {

	public static void main(String[] args) {

		Deque<Integer> dq = new ArrayDeque<>();

		dq.offer(30);
		dq.offer(20);
		dq.offer(10);
		dq.offer(40);

		System.out.println("Queue: "+dq);
		System.out.println("Remove: "+ dq.poll());
		System.out.println("Access: "+ dq.peek());

	}


//	Feature             LinkedList            ArrayDeque           		PriorityQueue        	ConcurrentLinkedQueue   LinkedBlockingQueue
//	Ordering            FIFO                  FIFO                 		Priority Heap Order  	FIFO                    FIFO
//	Backing Structure   Doubly-Linked List    Resizable Circular Array  Binary Heap Array    	Linked Nodes            Linked Nodes
//	Null Elements       Yes                   No                   		No                   	No                      No
//	Thread Safety       Not thread-safe       Not thread-safe     	 	Not thread-safe      	Lock-free (CAS)         Lock-based
//	Performance         Moderate              Fastest              		Moderate             	Fast (Concurrent)       Moderate (Blocking)
//	Memory Overhead     High                  Low                  		Low                  	High                    High

}
