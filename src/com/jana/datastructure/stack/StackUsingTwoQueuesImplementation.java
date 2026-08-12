package com.jana.datastructure.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueuesImplementation {

//	Push O(n) Pop(1)
	public class Stack1 {

		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();

		void push(int val) {
	        // Push x first in empty q2
			q2.offer(val);
			
			// Push all the remaining elements in q1 to q2.
			while(!q1.isEmpty()) {
//				q2.offer(q1.poll());
				q2.offer(q1.peek());
				q1.poll(); //If we need to throw error, use .remove()
			}
			
	        // swap the names of two queues
			Queue<Integer> temp=q1;
			q1=q2;
			q2=temp;
		}
		
		int pop() {
			if(q1.size()==0) {
				System.out.println("Stack is Empty");
				return -1;
			}
			return q1.poll();
		}
		
		int peek() {
			if(q1.size()==0) {
				System.out.println("Stack is Empty");
				return -1;
			}
			return q1.peek();
		}


		boolean isEmpty() {
			return q1.isEmpty();
		}

		int size() {
			return q1.size();
		}
	}

//	Push O(1) Pop(n)
	static class Stack2 {

		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();

		void push(int val) {
			q1.offer(val);
		}

		int pop() {
			if (q1.size() == 0) {
				System.out.println("Stack is Empty");
				return -1;
			}

			while (q1.size() != 1) {
				q2.offer(q1.poll());

			}

			int val = q1.poll();

			Queue<Integer> temp = q1;
			q1 = q2;
			q2 = temp;

			return val;
		}

		int peek() {
			if (q1.size() == 0) {
				System.out.println("Stack is Empty");
				return -1;
			}
			while (q1.size() != 1) {
				q2.offer(q1.poll());
			}

			int val = q1.peek();
			q2.offer(q1.poll());

			Queue<Integer> temp = q1;
			q1 = q2;
			q2 = temp;

			return val;
		}

		boolean isEmpty() {
			return q1.isEmpty();
		}

		int size() {
			return q1.size();
		}

	}

	public static void main(String[] args) {

		StackUsingTwoQueuesImplementation stack = new StackUsingTwoQueuesImplementation();
		//called public, Push O(n) Pop O(1)
		Stack1 st=stack.new Stack1();
		//called static, Push O(1) Pop O(n)
//		Stack2 st= new Stack2();
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
