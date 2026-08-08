package a.com.jana.java;

public class Java14Features {

	static class Employee {
		private String name;
		private int age;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
	}

	public static void main(String[] args) {
		System.out.println("===Java 12/14 - Switch Expressions===");
//		Switch Expressions (introduced as a preview in Java 12 and standardized in Java 14) 
//		transform the traditional switch from a rigid, error-prone control flow statement into a flexible, value-returning expression.
//		They introduce a new arrow syntax, eliminate the risk of accidental fall-through, and can be assigned directly to variables
		// Before Java14
		int day = 2;
		String result;

		switch (day) {
		case 1:
			result = "Monday";
			break;
		case 2:
			result = "Tuesday";
			break;
		default:
			result = "Unknown";
		}
		System.out.println("Before Java 14 Day: " + result);

		// Java 14 - Switch Expressions
		// No break
		// No Accidental fail-through
		// Can return a value directly
		String result1 = switch (day) {
		case 1 -> "Monday";
		case 2 -> "Tuesday";
		default -> "Unknown";
		};

		System.out.println("Java 14 Day: " + result1);

//		Before Java 14, yield() was known exclusively as a static method on the Thread class: Thread.yield().
//		This method is a hint to the operating system's thread scheduler that the current thread 
//		willing to yield its current use of a processor core

//		Yield is a context-dependent keyword introduced in Java 14 as part of the production-ready Switch Expressions.
//		Its sole purpose is to return a value from a switch expression block, immediately 
//		exiting the block and passing that value back to the receiving variable
//		No Return Needed for Single Lines: If you use a single-line arrow (->), the value is returned implicitly. 
//		You only use yield when you open a curly brace block {}

		String result2 = switch (day) {
		case 1 -> {
			System.out.println("Processing Monday...");
//			yield returns the value from the switch expression.
			yield "Monday";
		}
		case 2 -> {
			System.out.println("Processing Tuesday...");

			yield "Tuesday";
		}
		default -> "Unknown";
		};

		System.out.println("Java 14 Day: " + result2);

		System.out.println("===Java 14 - Helpful NullPointerExceptions===");

//		Before Java 14
//		NullPointerException - You didn't know which object was null.

//		Java 14 - Helpful NullPointerExceptions
//		The JVM now analyzes bytecode instructions to precisely describe which variable or call was null.

		Employee emp = null;

//		System.out.println(emp.getName());

		System.out.println("===Java 14/15 - Text Blocks===");

//		Text Blocks (standardised in Java 15 after being previewed in Java 14)
//		are multi-line string literals that eliminate the need for most escape sequences like \n

		String json = """
				{
				"name":"Java"
				"version::"14"
				}
				""";

		System.out.println(json);

//		String.formatted() introduced in java 15 
		String name = "Alice";
		int score = 95;
		// Before
		String message1 = String.format("Player %s scored %d points.", name, score);
		// Java 15
		String message2 = "Player %s scored %d points.".formatted(name, score);

		System.out.println("===Java 14/16 - Records===");

//		Records (introduced as a preview in Java 14 and standardized in Java 16) 
//		are a special type of class designed to act as immutable data carriers.

		System.out.println("===Java 14/16 - Pattern Matching for instanceof===");

//		Pattern Matching for instanceof (introduced as a preview in Java 14 and standardized in Java 16) 
//		combines type checking and object casting into a single, atomic step.It eliminates the 
//		repetitive boilerplate of explicitly casting an object immediately after checking its type.

//		Before Java 14

		Object obj = "Java";

		if (obj instanceof String) {
			String s = (String) obj;
			System.out.println("Before Java 14: " + s.length());
		}

//		Java 14 as preview
//		The compiler performs the cast automatically.
		if (obj instanceof String t) {
			System.out.println("Java 14: " + t.length());
		}
	}

}
