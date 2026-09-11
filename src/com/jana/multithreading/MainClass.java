package com.jana.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainClass {

//	What is multithreading in Java?
//	Multithreading in Java allows multiple threads to run concurrently within a single program. 
//	This enables efficient CPU usage by allowing the operating system to execute different parts of a program at the same time.

//	How do you create a thread in Java?
//	You can create a thread in Java by either:
//	Extending the Thread class: Create a subclass of Thread and override the run() method to define the task.
//	Implementing the Runnable interface: Create a class that implements Runnable and define the run() method. 
//		Then, pass an instance of the class to a Thread object and start the thread by calling its start() method.

//	CPU-bound Tasks
//	Definition: Tasks that use a lot of CPU power (e.g., calculations, data processing).
//
//	Threading: More threads won’t help much, and can actually hurt performance due to context switching.
//	Optimal Threads: Typically, 1 thread per CPU core is enough.

//	main - non-daemon thread, default thread
	public static void main(String[] args) {
//		Extending the Thread class
		Thread t1 = new ExtendingThreadClass("Cricket");
		Thread t2 = new ExtendingThreadClass("Football");
		Thread t3 = new ExtendingThreadClass();
		t1.start();
		t2.start();
		t3.start();
		t1.run();

//		Implementing the Runnable interface
		Thread th1 = new Thread(new ImplementingRunnableInterface());
		Thread th2 = new Thread(new ImplementingRunnableInterface());
		Thread th3 = new Thread(new ImplementingRunnableInterface());

		th1.start();
		th1.run();
		th2.start();
		th3.start();

		Thread th11 = new Thread(() -> {
			System.out.println("Lambda Runnable 1: " + Thread.currentThread().getName());
		});

		th11.start();
		th11.run();

		Runnable th12 = () -> {
			System.out.println("Lambda Runnable 2: " + Thread.currentThread().getName());
		};
		new Thread(th12).start();

//		Executor Framework (java.util.concurrent)
//		Instead of managing threads manually, Java provides the Executor Framework, which simplifies thread management and improves scalability.

//		ExecutorService
//		ExecutorService is an interface that provides methods to manage and control thread execution.
//		Common Implementations:
//			Executors.newFixedThreadPool(int nThreads)
//			Executors.newCachedThreadPool()
//			Executors.newSingleThreadExecutor()
//			Executors.newScheduledThreadPool(int corePoolSize)

//		Factory Method                 Core Pool Size    Max Pool Size          Best Used For
//		-----------------------------------------------------------------------------------------------------------------------------------------
//		newFixedThreadPool(n)          Fixed (n)         Fixed (n)              Predictable workloads with a controlled
//		                                                                        number of concurrent threads.
//
//		newCachedThreadPool()          0                 Unlimited              Short-lived, asynchronous tasks where
//		                                                 (Integer.MAX_VALUE)    workload spikes unpredictably.
//
//		newSingleThreadExecutor()      1                 1                      Sequential task execution where tasks
//		                                                                        must run one after another in order.
//
//		newScheduledThreadPool(n)      Fixed (n)         Unlimited              Delayed execution or tasks that need to
//		                                                 (Integer.MAX_VALUE)    run repeatedly at a specific interval.

//		Key Methods:
//			submit(): Submits a task for execution.
//			shutdown(): Initiates an orderly shutdown.
//			shutdownNow(): Attempts to stop all actively executing tasks.
//			invokeAll(): Executes a collection of tasks and waits for all to finish.
//			invokeAny(): Executes a collection and returns the result of the fastest successful one.
		System.out.println("============================================================================");

		// Create a fixed thread pool with 3 threads
		ExecutorService executor1 = Executors.newFixedThreadPool(3);

		// List of Callable tasks [Callable - The Task That Can Return a Result]
		List<Callable<String>> tasks = new ArrayList<>();

		for (int i = 1; i <= 8; i++) {
			int taskId = i;
			tasks.add(() -> {
				Thread.sleep(1000);
				return "Task " + taskId + " completed by " + Thread.currentThread().getName();
			});

		}

		// Submit one task using submit()[Future - The Handle to Get the Result Later]
		Future<String> singleResult = executor1.submit(() -> "Single Task Done");

		// Get result from single task
		try {
			System.out.println("Fixed ThreadPool Single Task Result: " + singleResult.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		try {
//          Run all tasks and wait for them to complete

			List<Future<String>> results = executor1.invokeAll(tasks);

			// Print results
			for (Future<String> result : results) {
				System.out.println(result.get());
			}

			// Use invokeAny: returns the result of the fastest successful task
			String fastestResult = executor1.invokeAny(tasks);
			System.out.println("Fixed ThreadPool Fastest result: " + fastestResult);

		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		// Shutdown the executor
		executor1.shutdown();

		// Get the number of available CPU cores
		int cores = Runtime.getRuntime().availableProcessors();
		System.out.println("Available CPU cores: " + cores);
//		For CPU-bound tasks, use 1 thread per core.
//		For I/O-bound tasks, use more threads (e.g., double the number of cores).

//        Callable and Future: How They Help in Java Concurrency
//        In Java multithreading, Callable and Future provide powerful tools that go beyond the basic Runnable and Thread model.

//        1. Callable<T>: The Task That Can Return a Result
//        Unlike Runnable, which only runs code and doesn't return anything, Callable<T> allows you to:
//        Return a result.
//        Throw checked exceptions.
//        Be submitted to an ExecutorService.

//        2. Future<T>: The Handle to Get the Result Later
//        When you submit a Callable to an executor, it gives you a Future<T> object.
//        This Future acts like a placeholder for the result that will be available after the task completes.
//        Key methods:
//        get(): Waits (blocks) until the result is available.
//        isDone(): Checks if the task is completed.
//        cancel(true/false): Cancels the task if it's still running.
//        isCancelled(): Checks if the task was cancelled.

	}

//	How do threads communicate with each other?
//		Threads communicate using wait(), notify(), and notifyAll() methods, which are part of the Object class in Java. 
//		These methods are typically used for inter-thread communication in situations 
//		where threads need to coordinate their execution based on some shared state or condition.
		
		
		






}
