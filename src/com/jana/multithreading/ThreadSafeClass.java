package com.jana.multithreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadSafeClass {

//	What are the ways to achieve thread safety in Java?
//	Thread safety can be achieved using:
//		Synchronization and Locking: Using synchronized blocks or methods to control access to shared resources.
//		Volatile Variables: Ensuring that changes to variables are immediately visible to other threads.
//		Atomic Variables: Using classes like AtomicInteger or AtomicReference to perform operations atomically.
//		Concurrent Collections: Using thread-safe collections like ConcurrentHashMap or CopyOnWriteArrayList for managing shared data.
//	    Immutable Objects: If an object cannot be changed after it is created (using the final keyword and 
//							containing no setter methods), it is automatically thread-safe
//		ThreadLocal: Instead of sharing an object, ThreadLocal creates a unique, isolated copy of that object 
//					for every individual thread. No thread can ever see or modify another thread's data.

//	Synchronization
	static class Counter1 {

		private int count = 0;

		public synchronized void increment() {
			count++;
		}

		public synchronized int getCount() {
			return count;
		}
	}

//	ReentrantLock
	static class Counter2 {

		private int count = 0;

		private final ReentrantLock lock = new ReentrantLock();

		public void increment() {
			lock.lock();
			try {
				count++;
			} finally {
				lock.unlock();
			}
		}

		public int getCount() {
			return count;
		}
	}

//	ReadWriteLock
	static class Counter3 {

		private int count = 0;

		private final ReadWriteLock lock = new ReentrantReadWriteLock();

		public void increment() {
			lock.writeLock().lock();
			try {
				count++;
			} finally {
				lock.writeLock().unlock();
			}
		}

		public int getCount() {
//			lock.readLock().lock();
//			try {
//			    // read
//			} finally {
//			    lock.readLock().unlock();
//			}
			return count;
		}
	}

	// Atomic Integer
	static class Counter4 {

		private final AtomicInteger count = new AtomicInteger(0);

		public void increment() {
			count.incrementAndGet();
		}

		public int getCount() {
			return count.get();
		}
	}

	public static void main(String[] args) {
//		1. Synchronization and Locking (Pessimistic Locking)
//		This strategy blocks other threads from accessing a resource while one thread is currently modifying it.
//		synchronized Keyword: Locks a method or block of code using an intrinsic lock (monitor). 
//				Only one thread can execute that code at a time.
//		ReentrantLock: A more flexible, manual lock class from java.util.concurrent.locks. 
//				It offers advanced features like timed lock acquisition, fairness policies, 
//				and the ability to interrupt a thread waiting for a lock.
//		ReadWriteLock: Allows multiple threads to read data simultaneously, 
//				but grants exclusive access to a single thread for writing

		Counter1 counter1 = new Counter1();
		Counter2 counter2 = new Counter2();
		Counter3 counter3 = new Counter3();
		Counter4 counter4 = new Counter4();

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				counter1.increment();
				counter2.increment();
				counter3.increment();
				counter4.increment();
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				counter1.increment();
				counter2.increment();
				counter3.increment();
				counter4.increment();
			}
		});

		t1.start();
		t2.start();
		try {
			// Wait for both threads to finish
			t1.join();
			t2.join();
			System.out.println("Synchronized count: " + counter1.getCount());
			System.out.println("ReentrantLock count: " + counter2.getCount());
			System.out.println("ReadWriteLock count: " + counter3.getCount());

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("============================================================================");
//		2. Volatile Variables: Ensures that changes made to a variable by one thread are instantly visible to all other threads. 
//		When one thread updates a volatile variable, other threads can see the updated value rather than continuing to use a stale value.	
		try {
			Worker worker = new Worker();
			Thread workerThread = new Thread(worker);

			workerThread.start();

			Thread.sleep(1000);

			System.out.println("Main Thread stopping worker");
			worker.stop();
			workerThread.join();

			System.out.println("Main thread finished");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		Using volatile
//		Thread 1                    Thread 2
//		---------                   ---------
//		reads running
//		                            running = false
//		                            ↓
//		                            visible to other threads
//		reads running = false
//		↓
//		loop exits
//		volatile provides the required visibility guarantees.

		System.out.println("============================================================================");
//		3.Atomic Variables: Classes like AtomicInteger, AtomicLong, and AtomicBoolean utilize low-level CPU Compare-And-Swap (CAS) 
//		operations to perform thread-safe increments, decrements, and updates without traditional locking.
//		The most commonly used classes are:
//				AtomicInteger
//				AtomicLong
//				AtomicBoolean
//				AtomicReference
		System.out.println("Atomic Integer count: " + counter4.getCount());

//		| Method                            | Meaning                                   | Example                               | Return        |
//		| --------------------------------- | ----------------------------------------- | ------------------------------------- | ------------- |
//		| `get()`                           | Get current value                         | `x.get()`                             | Current value |
//		| `set(value)`                      | Set value                                 | `x.set(10)`                           | `void`        |
//		| `lazySet(value)`                  | Eventually set value                      | `x.lazySet(10)`                       | `void`        |
//		| `getAndSet(value)`                | Set new value, return old                 | `x.getAndSet(10)`                     | Old value     |
//		| `compareAndSet(expected, update)` | Update only if current == expected        | `x.compareAndSet(10, 20)`             | `boolean`     |
//		| `weakCompareAndSet(...)`          | Weak CAS; may fail spuriously             | `x.weakCompareAndSet(10, 20)`         | `boolean`     |
//		| `incrementAndGet()`               | Increment, return new value               | `x.incrementAndGet()`                 | New value     |
//		| `getAndIncrement()`               | Increment, return old value               | `x.getAndIncrement()`                 | Old value     |
//		| `decrementAndGet()`               | Decrement, return new value               | `x.decrementAndGet()`                 | New value     |
//		| `getAndDecrement()`               | Decrement, return old value               | `x.getAndDecrement()`                 | Old value     |
//		| `addAndGet(n)`                    | Add n, return new value                   | `x.addAndGet(5)`                      | New value     |
//		| `getAndAdd(n)`                    | Add n, return old value                   | `x.getAndAdd(5)`                      | Old value     |
//		| `updateAndGet(fn)`                | Apply function, return new value          | `x.updateAndGet(v -> v * 2)`          | New value     |
//		| `getAndUpdate(fn)`                | Apply function, return old value          | `x.getAndUpdate(v -> v * 2)`          | Old value     |
//		| `accumulateAndGet(x, fn)`         | Combine current + given value, return new | `x.accumulateAndGet(5, Integer::sum)` | New value     |
//		| `getAndAccumulate(x, fn)`         | Combine current + given value, return old | `x.getAndAccumulate(5, Integer::sum)` | Old value     |
//		| `intValue()`                      | Get as `int`                              | `x.intValue()`                        | `int`         |
//		| `longValue()`                     | Get as `long`                             | `x.longValue()`                       | `long`        |
//		| `floatValue()`                    | Get as `float`                            | `x.floatValue()`                      | `float`       |
//		| `doubleValue()`                   | Get as `double`                           | `x.doubleValue()`                     | `double`      |
//		| `byteValue()`                     | Get as `byte`                             | `x.byteValue()`                       | `byte`        |
//		| `shortValue()`                    | Get as `short`                            | `x.shortValue()`                      | `short`       |

		System.out.println("============================================================================");
//		Concurrent Collections: Highly optimized collections like ConcurrentHashMap, CopyOnWriteArrayList, and 
//		ConcurrentLinkedQueue that allow thread-safe access with minimal blocking. 
//		For example, ConcurrentHashMap uses bucket-level locking so threads don't block the entire map.
//		Common concurrent collections:
//		| Collection              | Use case                      | Concurrency characteristic       |
//		| ----------------------- | ----------------------------- | -------------------------------- |
//		| `ConcurrentHashMap`     | Shared key-value data         | Concurrent reads/updates         |
//		| `CopyOnWriteArrayList`  | Many reads, few writes        | Reads don't require locking      |
//		| `CopyOnWriteArraySet`   | Many reads, few writes        | Copy-on-write                    |
//		| `ConcurrentLinkedQueue` | Non-blocking queue            | Lock-free style operations       |
//		| `ConcurrentLinkedDeque` | Concurrent double-ended queue | Non-blocking                     |
//		| `BlockingQueue`         | Producer-consumer             | Threads can wait for space/items |

		Map<String, Integer> map = new ConcurrentHashMap<>();
		map.put("A", 100);
		map.put("B", 200);
		System.out.println(map);

		List<String> users = new CopyOnWriteArrayList<>();
		users.add("Jan");
		users.add("John");
		System.out.println(users);
//		Synchronized Wrappers: Built using methods like Collections.synchronizedList() or Collections.synchronizedMap(). 
//		These wrap standard collections in a fully synchronized layer, though they are generally slower than modern concurrent collections.
		List<String> list = Collections.synchronizedList(new ArrayList<>());
		list.add("John");
		list.add("Jaan");
		list.add("Jeen");

//		Iteration with synchronized wrappers
//		For iteration, you should manually synchronize:
		synchronized (list) {
			for (String value : list) {
				System.out.println(value);
			}
		}
	}

	static class Worker implements Runnable {
//		The Problem Without volatile
//		Thread 1                    Thread 2
//		---------                   ---------
//		execute()
//		while(running)
//		                            stop()
//		                            running = false
//		But without proper synchronization, Thread 1 is not guaranteed by the Java Memory Model to observe that update promptly.
//		It may continue seeing the old value.

		private volatile boolean running = true;

		@Override
		public void run() {
			System.out.println("Worker started");
			if (running) {
				System.out.println("Worker running...");
			}
			System.out.println("Worker stopped");

		}

		public void stop() {
			running = false;
		}

	}

}
