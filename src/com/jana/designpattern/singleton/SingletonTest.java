package com.jana.designpattern.singleton;

public class SingletonTest {
//	Creational Design Pattern ###
//	Singleton Design Pattern ensures that only one instance of a class is created 
//	throughout the application and provides a global access point to that instance.
//	Ensures only one object exists.

//	A banking application has many modules:
//
//		Account Service
//		Loan Service
//		Payment Service
//		Transaction Service
//
//		All need logging. Every service uses the same Logger object.

	public static void main(String[] args) {

		Logger logger1 = Logger.getInstance();

		Logger logger2 = Logger.getInstance();

		Logger logger3 = Logger.getInstance();

		logger1.log("Logger 1 logging message...");
		logger2.log("Logger 2 logging message...");
		logger3.log("Logger 3 logging message...");

	}

}
