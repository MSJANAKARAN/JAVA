package com.jana.designpattern.singleton;

//Pattern                       Thread-Safe?  Lazy Loaded?   Performance    Verdict
//1. Lazy Initialization         No            Yes           Fast (broken)  Avoid entirely. Dangerous for production.
//2. Double-Checked Locking      Yes           Yes           Medium         Too complex. High risk of bugs if volatile is forgotten.
//3. Bill Pugh Implementation    Yes           Yes           Excellent      Best Choice. Elegant, safe, and highly performant.

// Lazy Initialization (Not Thread-Safe)
//public class Logger {
////  Only one instance
//	private static Logger instance;
//
////	private Constructor
//	private Logger() {
//	}
//
////	Global Access
////	without synchronized : Consider two threads. Both can create new objects. Then two instances exist. Singleton is broken.
////	synchronized : (Thread-Safe)Only one thread can execute getInstance() at a time.
//	public static synchronized Logger getInstance() {
//		if (instance == null) {
//			instance = new Logger();
//
//		}
//
//		return instance;
//	}
//
//	public void log(String message) {
//		System.out.println(message);
//	}
//}

//Thread-Safe Double-Checked Locking (Optimized)
//public class Logger {
////	volatile ensure thread safety when multiple threads read and write to a shared variable.
////	volatile keyword is mandatory here to prevent JVM instruction reordering from returning an uninitialized object wrapper to another thread
//	private static volatile Logger instance;
//	
//	private Logger() {
//	}
//	
//	public static Logger getInstance() {
//		if (instance == null) { // First check (no locking)
//            synchronized (Logger.class) {
//                if (instance == null) { // Second check (with locking)
//                    instance = new Logger();
//                }
//            }
//        }
//		return instance;
//	}
//
//	public void log(String message) {
//		System.out.println(message);
//	}
//}

//Static Inner Class (Best Java-Specific Way)
public class Logger {
//	A class is loaded into memory only once by the JVM.
//	An inner class is loaded only when it is referenced.
//	Therefore, the Singleton instance is created lazily, only when the getInstance() method accesses the inner class.

	private static class LoggerHelper{
		private static final Logger INSTANCE = new Logger();
	}

	public static Logger getInstance() {
		//inner class LoggerHelper
		return LoggerHelper.INSTANCE;
	}

	public void log(String message) {
		System.out.println(message);
	}
}



