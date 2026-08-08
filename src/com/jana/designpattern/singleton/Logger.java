package com.jana.designpattern.singleton;

public class Logger {
//  Only one instance
	private static Logger instance;
	
//	private Constructor
	private Logger() {
	}
	
//	Global Access
//	without synchronized : Consider two threads. Both can create new objects. Then two instances exist. Singleton is broken.
//	synchronized : (Thread-Safe)Only one thread can execute getInstance() at a time.
	public static synchronized Logger getInstance() {
		if(instance == null) {
			instance = new Logger();

		}

		return instance;
	}

	public void log(String message) {
		System.out.println(message);
	}
}
