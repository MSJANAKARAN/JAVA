package a.com.jana.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public class Java21Features {

	public static void main(String[] args) {

//		To use preview features, you must explicitly tell both the Java Compiler (javac) and the Java Runtime (java) 
//		to allow them using a special flag: --enable-preview.
//		As we are using Java 17 run :
//		java --source 17 --enable-preview Java21Features.java
		
		System.out.println("===Java 17/21 - Pattern Matching for switch ===");

//		Pattern Matching for switch - Preview (Stable in Java 21)
//		you can write and run preview version codes, but they are disabled by default.
//		 Before
		Object obj = 100;
		if (obj instanceof Integer) {
			Integer i = (Integer) obj;
			System.out.println("Before: " + i);

		} else if (obj instanceof String) {
			String s = (String) obj;
			System.out.println("Before: " + s);

		}
		
		System.out.println();
//		Java 21
		switch (obj) {
		case Integer i -> System.out.println("Java 17 Preview: " + i);
		case String s -> System.out.println("Java 17 Preview: " + s);
		default -> System.out.println("Unknown");
		}
		
		System.out.println("===Java 19/21 - Virtual Threads ===");
//		Virtual Threads
//		Historically, one Java thread mapped directly to one heavy Operating System (OS) thread. 
//		Java 21 introduces Virtual Threads—lightweight, user-mode threads managed by the JVM rather than the OS.
//		
//		The Benefit: 
//			You can now spin up millions of virtual threads on a single machine 
//			without running out of memory or crashing performance.
//		Why it matters: 
//			It completely eliminates the need for complex, unreadable 
//			asynchronous/reactive code (like WebFlux) for high-throughput I/O applications.
		
//		Creating a Single Virtual Thread
//		You can start a virtual thread immediately using the Thread.ofVirtual() builder API.
		
//			Thread vThread = Thread.ofVirtual().start(
//					()-> System.out.println("Virtual Thread running: "+Thread.currentThread())
//					);
		
//		Using an Executor ServiceFor managing multiple tasks, Java 21 introduced Executors.newVirtualThreadPerTaskExecutor(). 
//		This executor does not pool threads; instead, it spawns a brand new virtual thread for every single task submitted.
		
//			try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
//			    executor.submit(() -> {
//         			//Simulate blocking network or database I/O
//			        Thread.sleep(Duration.ofSeconds(1));
//			        return "Done";
//			    });
//			}

		System.out.println("===Java 21 - Record Patterns ===");
//		Allows you to deconstruct a record class inside an instanceof check or switch block, 
//		instantly extracting its fields into variables without writing nested getter calls.
//		Before Old way: check, cast, and call getters
//		public record Point(int x, int y) {}
//		
//		public void printObject(Object obj) {
//			if(obj instanceof Point) {
//				Point p = (Point) obj;
//			    System.out.println("Coordinates: " + p.x + ", " + p.y);
//			}
//		}
//		
//		Java 21
//		// Modern Java 21 way: inline deconstruction
//		public void printObject(Object obj) {
//			if (obj instanceof Point(int x, int y)) {
//			    System.out.println("Coordinates: " + x + ", " + y);
//			}
//		}
		
		System.out.println("===Java 21 - Sequenced Collections ===");
//		Before Java 21, Java didn't have a uniform way to get the first or last element of common collections 
//		(e.g., a List uses .get(0), a LinkedHashSet requires an iterator, a Deque uses .getFirst()).
//		Every structure required a different trick to access the ends or flip the order 
		List<String> list = new ArrayList<>(List.of("A", "B", "C"));
		LinkedHashSet<String> set = new LinkedHashSet<>(List.of("X", "Y", "Z"));

		// --- GETTING FIRST ELEMENT ---
		String firstList = list.get(0);
		String firstSet = set.iterator().next(); // 🛑 Inefficient & verbose!

		// --- GETTING LAST ELEMENT ---
		String lastList = list.get(list.size() - 1);
		String lastSet = null;
		for (String s : set) { lastSet = s; }   // 🛑 Terrible loop boilerplate!

		// --- REVERSING THE COLLECTION ---
		Collections.reverse(list);               // 🛑 Modifies the original collection in place!
		
		System.out.println("""
				firstList : %s
				firstSet : %s
				lastList : %s
				lastSet : %s
				list : %s
				""".formatted(firstList,firstSet,lastList,lastSet,list));
//		Java 21
//		List<String> list = new ArrayList<>(List.of("A", "B", "C"));
//		LinkedHashSet<String> set = new LinkedHashSet<>(List.of("X", "Y", "Z"));
//
//		// --- GETTING FIRST & LAST (Unified across List & Set) ---
//		String firstList = list.getFirst(); // "A"
//		String firstSet  = set.getFirst();  // "X"
//
//		String lastList  = list.getLast();  // "C"
//		String lastSet   = set.getLast();   // "Z"
//
//		// --- REVERSING (Unified) ---
//		// Returns a live, reversed VIEW without making copies or altering the original object
//		SequencedCollection<String> reversedSet = set.reversed();

//		Java 21 introduces three central interfaces to tie this structure together:
//			SequencedCollection: Implemented by List, Deque, and LinkedHashSet.
//			SequencedSet: Specifically enforces unique elements while maintaining step order 
//						  (e.g., LinkedHashSet, SortedSet).
//			SequencedMap: Introduces methods like firstEntry(), lastEntry(), putFirst(),
//						  and reversed() to key/value pairings like LinkedHashMap.

	}

}
