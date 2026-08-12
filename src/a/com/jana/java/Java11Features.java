package a.com.jana.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class Java11Features {
	
//	New HTTP Client API (Standard)
//	Before Java 11, developers commonly used: HttpURLConnection, Apache HttpClient, OkHttp
//	Java 11 introduced a modern HTTP client.
//	HTTP/2 support
//	Async programming
//	WebSocket support
//	Cleaner API
//	Replaces old HttpURLConnection
//	==============================================================================
	
//	Single File Source Execution
//	Earlier
//	javac Test.java
//	java Test
//	Now
//	java Test.java
//	Java compiles and runs automatically.
//	Useful for Scripts, Interviews, Quick testing
//	==============================================================================
	
//	Nest-Based Access Control in compiler
//	Before Java 11
//	If an inner class accessed private members of the outer class, the compiler generated synthetic accessor methods.
//	Example
//	class A {
//	    private int x = 10;
//	    class B {
//	        void print() {
//	            System.out.println(x);
//	        }
//	    }
//	}
//	The JVM (before Java 11) treated Outer and Outer$Inner as completely separate classes.
//	Files generated:
//	Outer.class
//	Outer$Inner.class
//	From the JVM's perspective:
//	Outer.class
//	        ❌ private field x
//	Outer$Inner.class
//	Since x is private, Outer$Inner.class could not access it directly.
//	So the compiler generated:
//	Outer.access$000()
//	which had package-level access and simply returned the private field.
//	
//	Java 11 lets nested classes access each other's private members directly using JVM support, reducing generated synthetic methods and slightly improving performance.
//	Now the JVM understands that:
//		Outer.class
//		Outer$Inner.class
//		belong to the same nest (family).
//		Nest Host
//		   |
//		   +-- Outer
//		   |
//		   +-- Outer$Inner
//		So Outer$Inner can directly access Outer's private field.


	public static void main(String[] args) throws IOException {
//		String.isBlank()
		String s = "   ";
		System.out.println("Before Java 11: " + s.trim().isEmpty());
		System.out.println("Java 11: " + s.isBlank());
		System.out.println("===".repeat(20));
//		==============================================================================
//		String.lines()
		String text = "Java\nSpring\nReact";
		System.out.println("Before Java 11: " );
		Arrays.stream(text.split("\n")).forEach(System.out::println);
		System.out.println("Java 11: ");
		text.lines().forEach(System.out::println);
		System.out.println("===".repeat(20));
//		==============================================================================
//		String.repeat()
		System.out.print("Before Java 11: ");
		for(int i=0;i<5;i++) {
			System.out.print("#");
		}
		System.out.println("\nJava 11: "+ "#".repeat(5));
		System.out.println("===".repeat(20));
//		==============================================================================
//		String.strip()
		String s1 = "   Hello   ";
		System.out.println("Before Java 11: " +s1.trim()); //ASCII only
		System.out.println("Java 11: " +s1.strip()); //Unicode aware
		System.out.println("===".repeat(20));
//		==============================================================================
		
//		Files.readString() && Files.writeString()
//		Before Java 11
		String input = "/Users/janakaran/PROJECTS/com.jana.java/src/a/com/jana/java/input.txt";
		String input11 = "/Users/janakaran/PROJECTS/com.jana.java/src/a/com/jana/java/input11.txt";

		byte[] data = Files.readAllBytes(Paths.get(input));
		String text1 = new String(data);
		System.out.println("Before Java 11 Read: " + text1);

		Files.write(Paths.get(input), (text1+"\nHello").getBytes());
		System.out.println("Before Java 11 Write: " + text1);
		System.out.println("Before Java 11 Read again: " + new String(Files.readAllBytes(Paths.get(input))));

		System.out.println("===".repeat(10));

//		Now
		String text2 = Files.readString(Path.of(input11));
		System.out.println("Java 11 Read: " + text2);
		Files.writeString(Path.of(input11), text2+"\nWorld");

		System.out.println("Java 11 Write: " + text2);
		System.out.println("Java 11 Read again: " + Files.readString(Path.of(input11)));

		System.out.println("===".repeat(20));

//		==============================================================================
		
//		Optional.isEmpty()
		Optional<String> op =  Optional.empty();
		System.out.println("Before Java 11: " + !op.isPresent());
		System.out.println("Java 11: " + op.isEmpty());
		System.out.println("===".repeat(20));

//		==============================================================================
//		var in Lambda Parameters
		var name ="Java"; //introduced in java 10
		BiFunction<Integer,Integer,Integer> add = (var a, var b)-> a+b;
		System.out.println("Java 11: " + add.apply(20, 30));
		System.out.println("===".repeat(20));

//		Local Variable Syntax in Lambda
//		Example
//		Function<String,Integer> f = (var s) -> s.length();
//		Cannot mix => (var a, b) -> ... ❌ Invalid.
//		Either all parameters use var or none do.
		BiConsumer<String, Integer> instant1 = (var a , var b) -> new Java8Features(a,b);
		System.out.println("Lambda Reference: " );
		instant1.accept("Jana",25);
//		==============================================================================
		
//		New Collection.toArray()
//		Before
        List<String> list = List.of("Java", "Spring", "React");
		String[] arr= list.toArray(new String[0]);
		System.out.println("Before Java 11: " +Arrays.toString(arr));
//		You pass an empty array: new String[0]
//				The Collection checks:
//					Is the array large enough?
//					        ↓
//					        No
//					        ↓
//					Create a new array internally
//					        ↓
//					Copy elements
//					        ↓
//					Return it
//The array you passed is usually not reused (unless it's already large enough
//		Java11
		String[] arr1 = list.toArray(String[]::new);
		System.out.println("Java 11: " + Arrays.toString(arr1));
//		String[]::new => constructor Reference.class 
//		When you know the required size, create a String[] of that size.
	}

//	Feature	Benefit
//	HttpClient	Modern HTTP client with HTTP/2 and async support
//	String.isBlank()	Checks for empty or whitespace-only strings
//	String.lines()	Converts multiline text into a stream of lines
//	String.repeat()	Repeats a string multiple times
//	String.strip()	Unicode-aware trimming
//	stripLeading()	Removes leading whitespace
//	stripTrailing()	Removes trailing whitespace
//	Files.readString()	Reads a file directly into a String
//	Files.writeString()	Writes a String directly to a file
//	Optional.isEmpty()	Readable alternative to !isPresent()
//	var in lambda	Supports var for all lambda parameters
//	Single-file execution	Run java MyFile.java without separate compilation
//	Collection.toArray(String[]::new)	Cleaner typed array creation
//	Nest-based access	Better inner/outer class access without synthetic methods
//	Flight Recorder	Built-in performance profiling
//	TLS 1.3	Improved secure communication
//	Unicode 10	Expanded character support example: emojis, symbols, new languages
//	Java EE module removal  removed JAXB(javax.xml.bind), JAX-WS, CORBA etc.. from JDK; use external dependencies.
//	Nashorn deprecated	Beginning of JavaScript engine removal
//
//	Java 11 Interview Questions
//	1. Why is Java 11 important?
//	It is a Long-Term Support (LTS) release widely adopted in enterprise applications, providing long-term updates, a modern HTTP client, improved String and File APIs, and JVM enhancements.
//
//	2. What replaces HttpURLConnection in Java 11?
//	The java.net.http.HttpClient API, which supports synchronous/asynchronous requests, HTTP/2, and WebSockets.
//
//	3. Difference between trim() and strip()?
//	trim() removes only ASCII whitespace, while strip() is Unicode-aware and handles a broader range of whitespace characters.
//
//	4. What is single-file source execution?
//	You can execute a source file directly using java MyProgram.java, which is useful for scripts and quick experiments.
//
//	5. Can lambda parameters mix var and explicit types?
//	No. Either all lambda parameters use var, or none of them do.
//
//	6. Why were JAXB and CORBA removed from the JDK?
//	To reduce the size of the JDK and decouple enterprise APIs from the core platform. Applications that need them must include them as external dependencies.
}
