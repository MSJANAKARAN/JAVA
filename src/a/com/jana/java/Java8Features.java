package a.com.jana.java;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Features implements CalculatorInterface8 {

//	Before Java 8:
//		Lots of anonymous inner classes
//		Verbose code
//		Difficult collection processing
//		Limited functional programming support
//
//	Java 8 introduced:
//		Lambda Expressions
//		Functional Interfaces
//		Method References
//		Stream API
//		Optional
//		New Date & Time API
//		CompletableFuture
//	    Base64 API
//		Nashorn JavaScript Engine (removed in Java 15)

	public Java8Features() {
		// empty
	}

	String name;
	Integer age;

	public Java8Features(String name, Integer age) {
		this.name = name;
		this.age = age;
		System.out.println(name + " " + age);
	}

	public String print() {
		return "Method Reference";
	}

	@Override
	public int add(int a, int b) {
		show();
		CalculatorInterface8.super.show();
		verify();
		CalculatorInterface8.super.verify();
		CalculatorInterface8.super.verify1();
		CalculatorInterface8.check();
		CalculatorInterface8.print();
		return a + b;
	}

	@Override
	public void verify() {
		System.out.println("Java8 verify");
		CalculatorInterface8.super.verify();
	}

	@Override
	public void show() {
		System.out.println("Java8 show + static print");
		CalculatorInterface8.super.show();
		CalculatorInterface8.print();
	}

	@Override
	public void verify1() {
		System.out.println("verify1 overrided + static check");
		CalculatorInterface8.check();
	}

	public static void main(String[] args) {

		System.out.println("==========Java 8 - Lambda Expressions(->) ==========");
//		A lambda expression is an anonymous function that 
//		can be passed as an argument or stored in a variable.
//		It has:
//			No name
//			No return type declaration
//			No access modifier
//		Can Lambda replace every interface?
//			No. It only works with Functional Interfaces.
//		Can Lambda work without a Functional Interface?
//				No. Lambda expressions require a target type that is a functional interface.
//		Can Lambda have loops? Yes.
//		What is a Functional Interface? Can you create your own?
//			An interface with exactly one abstract method.
//			Yes, use @FunctionalInterface to enforce this rule at compile time.
//		How do Lambdas achieve performance benefits over Anonymous Inner Classes?
//			Inner classes create a new .class file and instantiate a new object at runtime.
//			Lambdas use JVM invokedynamic (Indy) instructions.
//			This avoids creating heavy object overhead on every execution.
//		Can a Lambda expression extend a class or implement multiple interfaces?
//			No. Lambdas can only target a single functional interface.
//			You must use an anonymous inner class if multiple interfaces are required.
//		What is an "effectively final" variable, and why must local variables be so in Lambdas?
//			A variable whose value is never changed after initialization. 
//			Local variables live on the stack; Lambdas live on the heap.
//			The JVM makes a copy of the variable for the Lambda.
//			Preventing changes avoids race conditions and synchronization bugs.
//		How do you handle Checked Exceptions inside a Lambda expression?
//			Lambdas cannot throw checked exceptions(checked at compile time) unless the functional interface method declares them.
//			Wrap the risky code in a standard try-catch block inside the Lambda body.
//			Extract the logic into a helper method to keep the code readable. Wrap it inside a custom runtime exception wrapper.

//		Before
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("Running...");
			}
		};
		r1.run();
//		Java 8 Lambda
		Runnable r2 = () -> System.out.println("Running in Lambda...");
		r2.run();

		System.out.println("\n==========Java 8 - Functional Interfaces ==========");
//		A Functional Interface contains exactly one abstract method.
//		It may also have:
//			Default methods
//			Static methods
//			Private methods (Java 9+)
//		@FunctionalInterface Annotation: This annotation is optional but highly recommended. 
//		It forces the compiler to verify that the interface meets the criteria. 
//		If you add a second abstract method, it will trigger a compilation error.

//		Interface			Input		Output		Method
//		Predicate<T>		T			boolean		test()
//		Function<T,R>		T			R			apply()
//		Consumer<T>			T			void		accept()
//		Supplier<T>			None		T			get()
//		UnaryOperator<T>	T			T			apply()
//		BinaryOperator<T>	T,T			T			apply()

		System.out.println("\n==========Java 8 - Method References(::) ==========");
//		Method references provide a shorthand for lambdas that simply call an existing method.
//		If your lambda expression does nothing except pass an argument directly to an existing method, 
//		you can replace it with a method reference to make your code more readable.
//		Types of Method References
//		Static Method Reference [ClassName::staticMethodName]
//			When the lambda calls a utility or static helper method
		Function<String, Integer> parser = Integer::parseInt;
		System.out.println("Static Method Reference: " + parser.apply("100"));

//		Instance Method of a Particular Object [containingObjectInstance::instanceMethodName]
//			When you are calling a method on an existing external variable or object instance.
		String text = "Java";
		Supplier<String> upper = text::toUpperCase;
		System.out.println("Instance Method of a Particular Object Reference: " + upper.get());

		Java8Features feature = new Java8Features();
		Supplier<String> method = feature::print;
		System.out.println("Instance Method of a Particular Object Reference: " + method.get());

//		Instance Method of an Arbitrary Object of a Particular Type [ClassName::instanceMethodName]
//			When the method being called belongs to the target object passed as the first parameter of the lambda
		List<String> names = Arrays.asList("java", "spring", "javascript");
		System.out.println("Instance Method of an Arbitrary Object of a Particular Type: "
				+ names.stream().map(String::toUpperCase).collect(Collectors.joining(" ")));
//		Constructor Reference [ClassName::new]
//			When the lambda expression's sole job is to instantiate a fresh object.
		// Lambda
		BiConsumer<String, Integer> instant1 = (a, b) -> new Java8Features(a, b);
		System.out.println("Lambda Reference: ");
		instant1.accept("Jana", 25);
		// We cannot use int in BiConsumer as it allows only objects.
		// Java
		// Method Reference
		BiConsumer<String, Integer> instant2 = Java8Features::new;
		System.out.println("Constructor Reference: ");
		instant2.accept("Jana", 25);

		System.out.println("\n==========Java 8 - Default Methods ==========");
//		Before Java 8, adding a new abstract method to an existing interface could break implementing classes.

//		Default Methods [InterfaceName.super().methodName()]
//		Allows you to add new methods to an interface with a default implementation
//		Implementing classes can optionally choose to override a default method to customize its behavior

		CalculatorInterface8 cal = new Java8Features();
		cal.show();
		System.out.println("-----------------------------------------");
		cal.verify();
		System.out.println("-----------------------------------------");
		cal.verify1();
//		Why Default Methods?
//			Main purpose: Interface evolution / backward compatibility.
//		    For example, Java could add functionality to existing interfaces without forcing every implementation to immediately implement a new abstract method.

		System.out.println("==========Java 8 - Static Methods ==========");
//		Static Methods [InterfaceName.methodName()]
//		Acts as a utility method tightly coupled to the interface domain.
//		Static methods cannot be overridden by implementing classes. They belong strictly to the interface.
		CalculatorInterface8.check();
		System.out.println("-----------------------------------------");
		CalculatorInterface8.print();

//		Private Methods - Java 9
//		Used to encapsulate repetitive logic shared between multiple default or static methods within the same interface.
//		They are hidden from implementing classes and outside calls, strictly serving as internal helper methods
//		non-static (to help default methods) or static (to help static methods)

//		Abstract Methods: You must implement them. Call them using this.methodName() or just methodName().
//		Default Methods: Inherited automatically. Call them directly, or override them. If overridden, access the original via InterfaceName.super.methodName().
//		Static Methods: Not inherited. You must call them using the interface name: InterfaceName.methodName().
//		Private Methods: Invisible to the implementing class. You cannot call them.
//		Feature                  Abstract Method   Default Method   Static Method    Private Method
//		--------------------------------------------------------------------------------------------
//		Java Version             Java 1.0+         Java 8+          Java 8+         Java 9+
//		Has Body?                No                Yes              Yes              Yes
//		Can Override?            Must override     Optional         No               No
//		How to Call              Class Instance    Class Instance   Interface Name   Internal only

		System.out.println("\n==========Java 8 - Stream API ==========");
//		A Stream is a sequence of elements that supports functional-style operations for processing data.
//					      SOURCE
//					        |
//					        ↓
//					┌───────────────┐
//					│   Stream      │
//					└───────────────┘
//					        |
//					        ↓
//					INTERMEDIATE OPERATIONS [Transform a stream into another stream.]
//					filter() map() flatMap() sorted() distinct() peek() limit() skip()
//					        |
//					        ↓
//					TERMINAL OPERATION [End the stream pipeline and produce a result or side effect.]
//					  collect() forEach() reduce() count() min() max() findFirst() findAny() anyMatch() allMatch() noneMatch()
//					        |
//					        ↓
//					     RESULT
		List<Integer> list = Arrays.asList(7, 3, 8);
		Stream<Integer> s = list.stream();
		s.forEach(System.out::println);
//		s.forEach(System.out::println); // calling again wll throw exception
		System.out.println(Stream.generate(() -> "===").limit(20).collect(Collectors.joining()));

		List<Integer> list1 = IntStream.range(1, 100).parallel().boxed().collect(Collectors.toList());
		list1.stream().forEach(System.out::print);

		System.out.println("\n==========Java 8 - Optional ==========");
//		Optional<T> is a container that may or may not contain a non-null value.
//		It was introduced in Java 8 mainly to make absence of a value explicit and reduce accidental NullPointerExceptions.
//		Before
		String name1 = "John";
		if (name1 != null) {
			System.out.println(name1);
		}
		// Java 8 Optional
		Optional<String> name2 = Optional.of("John");
		System.out.println(name2);
//		get() - Returns the contained value.
		System.out.println(name2.get());
//		Why was Optional introduced?
//			To represent an optional/absent value explicitly and provide APIs for safer value handling.

//		Creating Optional
//		Optional.of() - Used when the value is definitely non-null.
		try {
			Optional<String> name3 = Optional.of(null);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
//		Optional.ofNullable() - Used when the value might be null.
		Optional<String> name4 = Optional.ofNullable(null);
		System.out.println(name4); // Optional.empty
//		isPresent() - Checks whether a value exists.
//		isEmpty() - Checks whether Optional contains no value. [Java 11]
//		orElse() - Returns the value if present; otherwise returns a default value.
//		orElse() evaluates its fallback eagerly, 
		Optional<String> name5 = Optional.ofNullable(null);
		System.out.println(name5.orElse("Default"));
//		orElseGet() - Uses a Supplier to generate the fallback only when needed.
//	    orElseGet() evaluates the supplier lazily only when the Optional is empty.
		System.out.println(name5.orElseGet(() -> "Default"));
//		orElseThrow() - Throws an exception if empty.
//		Java 10 introduced the no-argument version:
		try {
			System.out.println(name5.orElseThrow(() -> new Exception("Null")));
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
//		ifPresent() - Executes code only when a value exists.
		name2.ifPresent(System.out::println);
//		ifPresentOrElse() - Introduced in Java 9. Allows handling both cases.
//		name2.ifPresentOrElse(
//		        value -> System.out.println("Found: " + value),
//		        () -> System.out.println("Not found")
//		);
//		filter() - Filters the Optional value based on a condition.
//		map() - Transforms the value inside Optional.
		Optional<String> name6 = Optional.of("john");
		Optional<String> upper1 = name6.map(String::toUpperCase);
		System.out.println(upper1.get());
//		flatMap() - Used when the mapping function itself returns an Optional.
//		or() - 	Introduced in Java 9. Provides an alternative Optional if the current one is empty.
//		Optional<String> result1 =
//		        Optional.<String>empty()
//		                .or(() -> Optional.of("Default"));
//		stream() - Introduced in Java 9. Converts an Optional into a Stream containing:
//			0 elements → empty Optional
//			1 element  → present Optional
//		Should Optional be used everywhere?
//			No, Avoid blindly using: Optional<String> name; as entity fields or DTO fields. 
//			In typical Java/Spring applications, Optional is most useful as a return type when absence is a valid outcome, especially repository/service lookup methods.

		System.out.println("\n==========Java 8 - Date & Time API ==========");
//		Java 8 introduced the modern java.time API. 
//		Old APIs such as: java.util.Date, java.util.Calendar have several design problems
//		Java 8 provides:
//				LocalDate        -No time and no timezone.
//				LocalTime        -Time without date/timezone.
//				LocalDateTime    -Date + Time but no timezone.
//				ZonedDateTime    -Date + Time + Zone
//				Instant			 -Point on UTC timeline
//				Period			 -represents a date-based amount
//				Duration		 -represents a time-based amount.
//				ZoneId			 -Represents a timezone.
//				DateTimeFormatter-Used to format and parse dates.

		LocalDate today1 = LocalDate.now();
		System.out.println(today1);
//		Get Components
//			date.getYear();
//			date.getMonth();
//			date.getDayOfMonth();
//			date.getDayOfWeek();
		LocalDate date1 = LocalDate.of(2002, 02, 11); // creating a date
		System.out.println(date1);
		System.out.println(today1.plusDays(1)); // Tomorrow
		System.out.println(today1.plusMonths(1)); // Next Month
		System.out.println(today1.plusYears(1)); // Next Year
//		LocalDate is immutable. Above doesn't change date.
//		Comparing Dates
		System.out.println(date1.isBefore(today1));
		System.out.println(date1.isAfter(today1));
		System.out.println(date1.isEqual(today1));
		System.out.println("-----------------------------------------");

		LocalTime time1 = LocalTime.now();
		System.out.println(time1);
		LocalTime time2 = LocalTime.of(14, 10, 45);
		System.out.println(time2);
//		Time calculations
//			time.plusHours(2);
//			time.plusMinutes(30);
//			time.minusMinutes(10);
		System.out.println("-----------------------------------------");

		LocalDateTime now1 = LocalDateTime.now();
		System.out.println(now1);
		LocalDateTime date2 = LocalDateTime.of(2002, 02, 11, 2, 15, 45);
		System.out.println(date2);
//		DISADVANTAGE: 
//		In distributed systems, primary disadvantage of using LocalDateTime is that it completely lacks time zone and offset context
//		A LocalDateTime represents nothing more than a static wall-clock reading (e.g., "October 25, 2026, at 3:00 PM"). 
//		Without knowing where that clock is located, it cannot be reliably pinpointed to a specific instant on the global timeline
//		For Distributed Systems, use Instant or OffsetDateTime or ZonedDateTime
		System.out.println("-----------------------------------------");

		Instant now2 = Instant.now();
		System.out.println(now2);
		System.out.println("-----------------------------------------");

		OffsetDateTime off1 = OffsetDateTime.now();
		System.out.println(off1);
		System.out.println("-----------------------------------------");

		ZonedDateTime indiaTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
		System.out.println(indiaTime);
//		To Convert between zones, 
		ZonedDateTime newYorkTime = indiaTime.withZoneSameInstant(ZoneId.of("America/New_York"));
		System.out.println(newYorkTime);
		ZoneId zone = ZoneId.of("Asia/Kolkata");
		System.out.println(zone);
		System.out.println("-----------------------------------------");

		Period period1 = Period.of(1, 2, 10);
		System.out.println(period1);
//		Difference between dates: LocalDate
		Period period2 = Period.between(date1, today1);
		System.out.println(period2);
		System.out.println("-----------------------------------------");

		Duration duration1 = Duration.ofHours(5);
		System.out.println(duration1);
//		Difference between times: LocalTime
		Duration duration2 = Duration.between(time1, time2);
		System.out.println(duration2);
		System.out.println("-----------------------------------------");

		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		System.out.println(date1.format(formatter1));

		System.out.println("\n==========Java 8 - CompletableFuture ==========");
//		CompletableFuture was introduced in Java 8.
//		It provides an API for asynchronous and non-blocking-style composition of tasks.
//		Package: java.util.concurrent.CompletableFuture
//		Non-Blocking Chains: 
//			It uses a callback-driven approach. You attach tasks to execute automatically after a previous task finishes.
//		ForkJoinPool Threading: 
//			By default, asynchronous methods (those ending in Async) execute their tasks inside the global JVM ForkJoinPool.commonPool(). 
//			You can also pass a custom executor thread pool as a second argument.

//		1. Running a Background Task (No Return Value)
//			Use runAsync() if you want to kick off a task that just updates a database or logs an event.
		CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
			System.out.println("Running Asynchronously");
		});

		System.out.println(future1);

//		2. Running a Background Task with a Return Value
//			Use supplyAsync() when your background task needs to fetch or compute data.
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
			return "Fetched Data Result";
		});
		System.out.println(future2);

//		it will not print the result of the background task. The Task is Still Running (Incompleted)
		System.out.println("-----------------------------------------");

//			| Method       | Uses result? | Returns            |
//			| ------------ | ------------ | ------------------ |
//			| thenApply()  | Yes          | transformed result |
//			| thenAccept() | Yes          | Void`(consume)     |
//			| thenRun()    | No           | Void (just execute)|
		future2.thenAccept(result -> System.out.println(result));
		future2.thenApply(String::toUpperCase).thenAccept(result -> System.out.println(result));
		future2.thenAccept(result -> System.out.println(result));
		future2.thenRun(() -> System.out.println("Completed"));
		System.out.println(future2);
//		Print the result of the background task. The Task Finished Successfully (Completed)
		System.out.println("-----------------------------------------");

//		Combining Multiple Futures
//		thenCompose() - Used to chain dependent asynchronous operations.
		CompletableFuture<Integer> lengthFuture = CompletableFuture.supplyAsync(() -> {
			return 30;
		});
		// we can change by .thenApply() also which is synchronous. Just to demonstrate
		CompletableFuture<Integer> heightFuture = lengthFuture
				.thenCompose(a -> CompletableFuture.supplyAsync(() -> a + 5));
		heightFuture.thenAccept(System.out::println);

//		thenCombine() - Used when two independent asynchronous operations need to be combined.
		CompletableFuture<Integer> widthFuture = CompletableFuture.supplyAsync(() -> {
			return 40;
		});
		CompletableFuture<Integer> areaFuture = heightFuture.thenCombine(widthFuture, (a, b) -> a * b);
		areaFuture.thenAccept(System.out::println);
		System.out.println("-----------------------------------------");
//		allOf() - Waits for multiple futures to complete. Useful for independent operations.
		CompletableFuture<Void> success1 = CompletableFuture.allOf(future1, future2, lengthFuture);
		System.out.println(success1);
//		anyOf() - Completes when any one of the supplied futures completes.
		CompletableFuture<Object> success2 = CompletableFuture.anyOf(future1, future2, lengthFuture);
		System.out.println(success2);
		System.out.println("-----------------------------------------");

//		Exception Handling
		CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
			throw new RuntimeException("Database error");
		});
//		exceptionally() - Acts like a functional catch block. Allows you to intercept a failure.
		try {
			future3.exceptionally(ex -> "Error: " + ex);
			// Prevents the main script thread from closing before the async task prints
			future3.join();

		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

//		handle() - Handles both success and failure.
		try {
			future3.handle((value, ex) -> {
				if (ex != null) {
					return "Error: Failed";
				}
				return value;
			});
			future3.get();

		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

//		whenComplete() - Executes after completion for observation/side effects.
		try {
			future3.whenComplete((value, ex) -> {
				if (ex != null) {
					System.out.println("Error: " + ex);
				} else {
					System.out.println(value);

				}
			});
//			it doesn't transform the result. using get() or join()
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

//		Both handle() and whenComplete() are powerful bi-consumer/bi-function methods used to process the outcome of a CompletableFuture. 
//		They both trigger automatically whether the previous task completed successfully or with an exception.
//		The core difference lies in their intent and return type: 
//			handle() is designed to transform and recover data (Intermediate operation), 
//			whereas whenComplete() is designed for side-effects and logging without changing the outcome (Terminal operation).

//		join() vs get()
//		Both can wait for a CompletableFuture.
//		future.get() - throws checked exceptions. ExecutionException
//		future.join() - throws unchecked CompletionException on failure.

		System.out.println("\n==========Java 8 - Base64 API ==========");
//		Java 8 introduced: java.util.Base64
//		Base64 converts binary data into a textual representation.
//		Common use cases:
//			HTTP Basic Authentication
//			encoding small binary data
//			tokens/protocols where Base64 representation is required
//		Important:
//			Base64 is encoding, not encryption.
//			Anyone who has the encoded value can decode it.

		String text1 = "Hello";
		String encoded1 = Base64.getEncoder().encodeToString(text1.getBytes());
		System.out.println(encoded1);

		byte[] decode = Base64.getDecoder().decode(encoded1);
		System.out.println(decode.toString());
		String decoded1 = new String(decode);
		System.out.println(decoded1);
//		Extra Knowledge:
//		The reason new String(decoded) works while decoded.toString() fails is because of 
//		how Java handles arrays vs. objects, and how strings are constructed from raw binary data.

//		In Java, arrays (byte[], int[], etc.) are low-level primitives wrapped in basic objects, 
//		but they do not override the default Object.toString() method.
//		new String(byte[] bytes) is an explicit constructor specifically engineered to perform decoding.

//		While new String(decoded) works, relying on it blindly is dangerous in distributed or cloud environments. 
//		If no encoding is specified, Java defaults to the host operating system's native charset.
//		If Service A runs on a Windows server (using Windows-1252) and Service B runs on a Linux container (using UTF-8), 
//		new String(decoded) can silently corrupt special characters (like é, ü, or £).
//		Always explicitly specify the character encoding (typically StandardCharsets.UTF-8)
//		both when generating and decoding your strings
		String encoded2 = new String(Base64.getEncoder().encode(text1.getBytes()), StandardCharsets.UTF_8);
		String encoded3 = Base64.getEncoder().encodeToString(text1.getBytes(StandardCharsets.UTF_8));
		System.out.println(encoded2);
		System.out.println(encoded3);
		String decoded2 = new String(Base64.getDecoder().decode(encoded2), StandardCharsets.UTF_8);
		System.out.println(decoded2);

//		Useful when the encoded value is intended for URLs.
//			Base64.getUrlEncoder()
//			Base64.getUrlDecoder()
//		Designed for MIME-style encoding.
//			Base64.getMimeEncoder()
//			Base64.getMimeDecoder()

		System.out.println("\n==========Java 8 - Nashorn JavaScript Engine ==========");
//		Java 8 introduced the Nashorn JavaScript engine.
//		It allowed Java applications to execute JavaScript.
		try {
//			directly calling without import to make it throw Exception without breaking code
			javax.script.ScriptEngine engine = new javax.script.ScriptEngineManager().getEngineByName("nashorn");
			engine.eval("print('Hello from JavaScript')");
		} catch (javax.script.ScriptException e) {
			System.out.println("Error: " + e);
		} catch (Exception e) {
			//Another catch to fetch ScriptExecution import error
			System.out.println("Error: " + e);
		}
		
//		Nashorn is mainly a historical Java 8 feature. It was deprecated in Java 11 and removed in Java 15.

	}

}
