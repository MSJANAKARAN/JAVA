package com.jana.multithreading;

public class ImplementingRunnableInterface implements Runnable {

	@Override
	public void run() {
		System.out.println("Executing Runnable task: "+Thread.currentThread().getName());
	}

}
