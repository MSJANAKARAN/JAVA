package a.com.jana.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java910Features implements CalculatorInterface9, CalculatorInterface8 {

	public static void main(String[] args) {

		System.out.println("===Java 9 - Java Platform Module System (JPMS)===");
//		Java Platform Module System (JPMS)
//		A module is a regular Java package structure that includes a special configuration file at its root directory 
//		named module-info.java. Without this file, the code runs on the legacy classpath as an unnamed module.
//		Inside this file, you declare:
//			The name of your module.What it needs from other modules (requires).
//			What it opens up for other modules to use (exports)
//		
//		Strong Encapsulation: 
//			A public class is no longer truly public unless its parent package is explicitly exports-ed. 
//			This prevents developers from accidentally tying code to internal implementation details.
//		Reliable Configuration (No more NoClassDefFoundError): 
//			The JVM checks all requires statements at startup. If a dependency module is missing, 
//			application crashes immediately with clear error instead of failing hours later in production runtime.
//		
//		Before Java 9
//		Everything on the classpath was accessible.
//		Application
//		   ↓
//		Entire JAR
//		
//		No encapsulation.
//		
//		Java 9
//		i.e) to organize applications into modules.
//		A module explicitly declares: What it exports, What it requires.
//			Application
//		      ↓
//		 Module A  ----requires----> Module B
//		      │
//		   exports
//		      │
//		 Public Packages
//		
//		module-info.java
//		
//		module banking.app {
//		    requires java.sql;
//		    exports com.bank.service;
//		}
//
//		Meaning:
//			Requires java.sql
//			Only com.bank.service is visible outside the module
//		Advantages:
//			Better encapsulation
//			Faster startup
//			Smaller runtime
//			Better dependency management
//		Why was JPMS introduced?
//				To improve encapsulation, dependency management, and scalability for large applications.
//
//		Note: Many Spring Boot applications still use the traditional classpath instead of JPMS, so 
//		understanding the concept is usually more important than hands-on usage.

		System.out.println("===Java 9 - Collection Factory Methods===");
//		Collection Factory Methods
//		Creates immutable collections.
//			Immutable
//			Cleaner code
//			Faster creation
//		
//		Before Java 9
		List<String> list = new ArrayList<>();

		list.add("Java");
		list.add("Spring");
		System.out.println("Before List: " + list);

//		Java 9
		List<String> list1 = List.of("Java", "Spring");
		System.out.println("List: " + list1);
		Map<Integer, String> map = Map.of(1, "One", 2, "Two", 3, "Three");
		System.out.println("Map: " + map);
		Set<Integer> set = Set.of(2, 4, 1);
		System.out.println("Set: " + set);
//		list1.add("Test"); //UnsupportedOperationException
//		map.remove(0); //UnsupportedOperationException

		System.out.println("===Java 9 - Stream API Improvements===");
//		Stream API Improvements
//		takeWhile() - Keeps elements while the condition is true. (Short-Circuiting):
//		Only use takeWhile() when your data has a guaranteed, meaningful sort order.
		System.out.println("Take While: ");

		List.of(1, 2, 3, 4, 1, 2).stream().takeWhile(n -> n < 4).forEach(System.out::println);
		// stops at 4
//		filter() evaluates every single element in the stream, 
//		takeWhile() stops processing completely the moment it encounters the first element that does not match the condition

//		dropWhile() - Skips elements while the condition is true. (NOT Short-Circuiting)
		System.out.println("Drop While: ");
		List.of(1, 2, 3, 4, 1, 2).stream().dropWhile(n -> n < 4).forEach(System.out::println);

//		ofNullable() - Produces an empty stream instead of throwing an exception.. Useful for null-safe stream pipelines.
//		Before
//		Stream.of(null).forEach(System.out::println); //NPE
		System.out.println("Stream.ofNullable: ");

		Stream.ofNullable(null).forEach(System.out::println);
//		Stream.iterate() method was improved by adding a new overloaded version that accepts a Predicate to act as a termination condition.
		// Before
		Stream<Integer> num3 = Stream.iterate(1, n -> n + 1);
		num3.limit(4).forEach(System.out::println);
		// Java 9 (The for Loop Equivalent)
		Stream.iterate(1, n -> n < 5, n -> n + 1).forEach(System.out::println);

		System.out.println("===Java 9 - Optional Improvements===");

//		----Optional.stream()
//		Converts the Optional object into a sequential Stream containing either a single element or zero elements if empty	
		List<Optional<String>> optionalList = Arrays.asList(Optional.of("Java"), Optional.empty(),
				Optional.of("Optional"));
//		Before
		List<String> values = optionalList.stream().filter(Optional::isPresent).map(Optional::get)
				.collect(Collectors.toList());
		System.out.println("Before Java 9: " + values);
//		Java 9
		List<String> values1 = optionalList.stream().flatMap(Optional::stream).collect(Collectors.toList());
		System.out.println("Java 9: " + values1);

//		----ifPresentOrElse()
//		Takes an action to perform if a value exists, and a second backup action (runnable) to run if the value is empty
//		Before
		Optional<String> userRole = Optional.empty();
		System.out.println("Before Java 9: ");

		if (userRole.isPresent()) {
			System.out.println("Access granted as: " + userRole.get());
		} else {
			System.out.println("Access denied. Please log in.");
		}
//		Java 9
		System.out.println("Java 9: ");

		userRole.ifPresentOrElse(role -> System.out.println("Access granted as: " + role),
				() -> System.out.println("Access denied. Please log in."));
//		----or()
//		Returns the current Optional if it has a value, or returns an alternative Optional supplied by a function if it is empty.
		Optional<String> adminRole = Optional.of("Database");
		Optional<String> role = Optional.empty();
//		Before
		System.out.println("Before Java 9: ");
		Optional<String> result = role.isPresent() ? role
				: (adminRole.isPresent() ? adminRole : Optional.of("Default"));
		System.out.println(result.get());
		// Java 9
		System.out.println("Java 9: ");
		Optional<String> result1 = role.or(() -> adminRole);
		System.out.println(result1.get());

		System.out.println("===Java 9 - JShell===");
//		JShell (introduced in Java 9) is Java’s official REPL (Read-Eval-Print Loop) tool.
//		It allows you to execute Java code snippets, test APIs, and experiment with logic directly in your terminal without writing a 
//		full public static void main(String[] args) method, creating a class, or compiling the code manually.
//		To open the tool, type jshell into your terminal or command prompt
//		Example:
//		jshell> int x = 10;
//		x ==> 10
//		jshell> int y = 20;
//		y ==> 20
//		jshell> x + y
//		$3 ==> 30
//		jshell> String msg = "Hello from JShell";
//		msg ==> "Hello from JShell"
//		jshell> msg.toLowerCase()
//		$5 ==> "hello from jshell"

		System.out.println("===Java 9 - Private Methods===");

//		Private Methods - Java 9
//		Used to encapsulate repetitive logic shared between multiple default or static methods within the same interface.
//		They are hidden from implementing classes and outside calls, strictly serving as internal helper methods
//		non-static (to help default methods) or static (to help static methods)
//		Check CalculatorInterface.java

//		Default Methods [InterfaceName.super().methodName()]
		System.out.println("Java 8 interface default: ");
		CalculatorInterface8 cal1 = new Java910Features();
		cal1.show();
		System.out.println("-----------------------------------------");
		cal1.verify1();
		System.out.println("-----------------------------------------");
		System.out.println("Java 9 interface default: ");
		CalculatorInterface9 cal2 = new Java910Features();
		cal2.verify();
		System.out.println("-----------------------------------------");
		cal2.verify1();

		System.out.println("-----------------------------------------");
//		Static Methods [InterfaceName.methodName()]
		System.out.println("Java 8 interface static: ");
		CalculatorInterface8.check();
		System.out.println("-----------------------------------------");
		System.out.println("Java 9 interface static: ");
		CalculatorInterface9.print();
		System.out.println("===Java 10 - Local Variable Type Inference (var)===");
//		Local Variable Type Inference (var)
//		It allows you to omit the explicit data type declaration for local variables, instructing the compiler to 
//		automatically infer the correct type based on the initialization value at compile time.

//		Rules and Constraints
//			1. No Missing Initializers
//			var x; // ❌ COMPILER ERROR: Cannot infer type without an initializer
//			2. No Null Assignments
//			var user = null; // ❌ COMPILER ERROR: Variable initializer is 'null'
//			3. No Instance Fields or Class Variables - You cannot use var for global variables or properties of a class.
//			public class Employee {
//			    var salary = 50000; // ❌ COMPILER ERROR: 'var' is not allowed here
//			}
//			4. No Method Parameters or Return Types
//			public var calculate(var input) { ... } // ❌ COMPILER ERROR
//			5. No Lambda Expressions without Explicit Casting - Lambdas need an explicit functional interface type to bind to.
//			var printer = s -> System.out.println(s); // ❌ COMPILER ERROR

//		Before
		ArrayList<String> names = new ArrayList<>();
//		Java 10
		var names1 = new ArrayList<String>();

		var number = 100; // compiler infers -> int number = 100;
		var text = "Java"; // compiler infers -> String text = "Java";

		System.out.println("===Java 10 - Unmodifiable Collection Collectors===");
//		Unmodifiable Collection Collectors
//		to let you collect stream results directly into unmodifiable collections in a single step
//		Before Java 10, creating a truly unmodifiable list or set from a stream required a verbose, multi-step wrapping process. 
//		Java 10 added four static factory methods to the java.util.stream.Collectors class:
//			toUnmodifiableList(), 
//			toUnmodifiableSet(), 
//			and two variants of toUnmodifiableMap()
//		
//		Before, To get unmodifiable list
		List<String> ulist = Stream.of("A", "B", "C")
				.collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
		System.out.println("Before Java 10 List: " + ulist);

//		Java 10
		List<String> ulist1 = Stream.of("A", "B", "C").collect(Collectors.toUnmodifiableList());
		System.out.println("Java 10 List: " + ulist1);
		Set<Integer> uset1 = Stream.of(1, 2, 2, 3).collect(Collectors.toUnmodifiableSet()); // Results in [1, 2, 3]
		System.out.println("Java 10 Set: " + uset1);
		Map<Integer, String> umap1 = Stream.of("AA", "BBB", "C")
				.collect(Collectors.toUnmodifiableMap(String::length, str -> str));
		System.out.println("Java 10 Map: " + umap1);

		Map<Integer, String> umap2 = Stream.of("AA", "BBB", "BAB", "C")
				.collect(Collectors.toUnmodifiableMap(String::length, str -> str, (existing, replacement) -> existing));
		System.out.println("Java 10 Map: " + umap2);
//		By default, map collectors crash with an IllegalStateException if two items try to use the exact same key. 
//		This merge function tells the compiler exactly how to resolve a tie-breaker.
//		existing: The value already saved in the map ("BBB").
//		replacement: The new value trying to get in ("BAB").-> existing: Tells Java: "If a duplicate key occurs, ignore the new one and keep the one we already have."

//		Rules and Characteristics
//		Null Elements Disallowed: 
//			Unlike standard collectors (Collectors.toList()), unmodifiable collectors throw a NullPointerException 
//			if the stream contains any null elements, keys, or values.
//		True Disassociation: 
//			The returned collections are completely decoupled from any underlying data.
//			They are structurally identical to collections created via List.of() or Set.of().
//		Not Immutable (Shallow Immutability): 
//			The collection wrapper is unmodifiable (you cannot add, remove, or clear items). 
//			However, if the objects inside the collection are mutable, you can still alter their internal states.
	}

	@Override
	public int add(int a, int b) {
		show();
		verify();
		CalculatorInterface8.check();
		CalculatorInterface8.print();
		return a + b;
	}

	@Override
	public void verify() {
		System.out.println("Java9 overrided");
		CalculatorInterface9.super.verify();
		CalculatorInterface9.print();
	}

	@Override
	public void show() {
		System.out.println("Java8 overrided");
		CalculatorInterface8.super.show();
		CalculatorInterface8.print();
	}

	@Override
	public void verify1() {
		System.out.println("verify1 overrided");
		CalculatorInterface8.check();
	}

}
