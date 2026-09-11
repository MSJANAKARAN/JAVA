package com.jana.multithreading;

public class ConcurrencyIssuesClass {
	static class Counter {

	    private int count = 0;

	    public void increment() {
	        count++;
	    }

	    public int getCount() {
	        return count;
	    }
	}

	public static void main(String[] args) {

		
//		1. Race Condition
//		A race condition occurs when multiple threads access shared mutable data concurrently, 
//		and the final result depends on the timing/order of execution.
		Counter counter = new Counter();

		Thread t1 = new Thread(() -> {
		    for (int i = 0; i < 1000; i++) {
		        counter.increment();
		    }
		});

		Thread t2 = new Thread(() -> {
		    for (int i = 0; i < 1000; i++) {
		        counter.increment();
		    }
		});

		t1.start();
		t2.start();
		System.out.println(counter.getCount()); //Expected 2000, but output will be lesser
		
//		How to Fix Race Conditions? Check ThreadSafeClass.java
//		Solution 1: synchronized
//		Solution 2: AtomicInteger
//		Solution 3: Lock

		System.out.println("============================================================================");

//		2. Deadlock
//		A deadlock occurs when two or more threads are permanently blocked 
//		because each is waiting for a resource held by another.
		
		Object lock1 = new Object();
		Object lock2 = new Object();
		
		// Thread 1
		Thread t3 =new Thread(()->{
			synchronized(lock1) {
				System.out.println("Thread 1 locked 1");

				synchronized(lock2) {
					System.out.println("Thread 1 locked 2");
				}
			}
		});
		
		// Thread 2 (Causes Deadlock by reversing the lock order!)
		Thread t4 = new Thread(()->{
			synchronized(lock2) {
				System.out.println("Thread 2 locked 2");

				synchronized(lock1) {
					System.out.println("Thread 2 locked 1");
				}
			}
		});
		
		t3.start();
		t4.start();

//		Thread1 holds lock1, waiting for lock2
//		Thread2 holds lock2, waiting for lock1
		
		
//		How to Fix: Always acquire locks in the exact same global order across all threads, 
//		or use explicit timeouts via ReentrantLock.tryLock()
		System.out.println("============================================================================");

//		3. Starvation
//		Starvation occurs when a thread never gets the CPU or a required resource 
//		because other threads continuously get preference.
//		Suppose:
//			High-priority thread keeps running.
//			Low-priority thread is always postponed.
		
//		Common Causes:
//			Setting a thread's priority too low (Thread.MIN_PRIORITY).
//			A thread waiting indefinitely to enter a synchronized block because other threads keep cutting the line.
		
//		How to Fix: Use a "fair lock" mechanism (new ReentrantLock(true)), 
//		which grants access to the thread that has been waiting the longest.
	
		System.out.println("============================================================================");
//		4. Livelock
//		A livelock occurs when threads are not blocked, but 
//		they keep reacting to each other and make no progress.
//		Example:
//		Thread A move left
//		Thread B move left
//		Thread A move right
//		Thread B move right
//		Everyone is active, but nothing gets done.
	}

}
