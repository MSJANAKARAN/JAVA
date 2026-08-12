package a.com.jana.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamAPIAdvanced {
//	A Stream is a sequence of elements that supports functional-style operations for processing data.
//	A stream does not store data. It processes data from a source such as:
//		Collection	Array	List	Set		File	Generated values
//			  SOURCE
//			    |
//			    ↓
//			┌───────────────┐
//			│   Stream      │
//			└───────────────┘
//			    |
//			    ↓
//			INTERMEDIATE OPERATIONS
//			filter → map → sorted
//			    |
//			    ↓
//			TERMINAL OPERATION
//			collect / forEach
//			    |
//			    ↓
//			 RESULT
//	
//	A Stream:
//		doesn't own/store the elements as a collection
//		represents a computation over a source
//		is generally single-use
//		supports functional-style processing
//	    are not automatically faster than loops.

	public static void main(String[] args) {
		List<Integer> num1 = Arrays.asList(7, 3, 5, 2, 4, 8);

		System.out.println("========== reduce() ==========");

//		reduce() combines multiple stream elements into one result.
		int sum1 = num1.stream().reduce(0, (a, b) -> a + b);
		System.out.println(sum1);
		System.out.println("------ reduce() Identity + accumulator ------");
		System.out.println(num1.stream().reduce(0, (a, b) -> a + b));
		System.out.println(num1.stream().reduce(0, Integer::max));

		System.out.println("------ reduce() without Identity ------");
		System.out.println(num1.stream().reduce((a, b) -> a + b));
		Optional<Integer> sum2 = num1.stream().reduce(Integer::sum);
		System.out.println(sum2);
//		Why Optional?
//			Because the stream could be empty.

		System.out.println("------ reduce() Parallel-friendly three-argument version ------");
//		identity -> 0
//		accumulator -> combine element with partial result
//		combiner -> combine partial results
		int sum3 = num1.parallelStream().reduce(0, Integer::sum, Integer::sum);
		System.out.println(sum3);

		System.out.println(Stream.of("Java", " ", "Spring", " ", "Boot").reduce("", String::concat));
//		reduce()  → combine → one result
//		collect() → accumulate → collection/result structure

		System.out.println("========== Parallel Streams ==========");
//		A parallel stream divides stream processing across multiple threads.
		num1.parallelStream().map(n -> n * 2).forEach(System.out::println);
//		Don't rely on ordering for forEach, in paraller stream, Order isn't guaranteed

		System.out.println("------ Parallel Streams forEachOrdered ------");
//		Use forEachOrdered() when encounter order is required.
		num1.parallelStream().map(n -> n * 2).forEachOrdered(System.out::println);

//		list.stream() - uses sequential processing.
//		list.parallelStream() - allows parallel processing.
//		list.stream().parallel() - (Sequential converted to Parallel)
//		list.parallelStream().sequential() - (Parallel converted to Sequential)

//		Important Warning: Parallel Does NOT Always Mean Faster
//		Parallelism has overhead:
//				Task splitting
//				    +
//				Thread scheduling
//				    +
//				Synchronization/combining
//				    +
//				Context switching
//		
//		For small datasets:
//			Sequential
//			    ↓
//			often faster
//
//		For sufficiently large, CPU-intensive, independent operations:
//			Parallel
//			    ↓
//			may be faster
//		But we should measure, not assume.

		System.out.println("========== Internal Working of Streams ==========");
//		Elements flow through the pipeline vertically(one element at a time). i.e Element by Element
//		[ Element 1 ] ──> .filter() ──> .map() ──> .forEach() (Completed)
//		[ Element 2 ] ──> .filter() ──> .map() ──> .forEach() (Completed)
//		[ Element 3 ] ──> .filter() ──> .map() ──> .forEach() (Completed)

		System.out.println("========== Lazy Evaluation ==========");
//		Intermediate operations are lazy.
		Stream<Integer> stream = num1.stream().filter(n -> {
			System.out.println("Filtering " + n);
			return n > 3;
		});
//		Nothing is printed yet. Because there is no terminal operation.
		long count = stream.count(); // The pipeline executes.
//		System.out.println("count: " + count);

		System.out.println("------ Lazy Evaluation Example ------");
//		Lazy evaluation allows Java to: Avoid unnecessary processing
		Optional<Integer> result = Stream.of(5, 10, 15, 20, 25).filter(n -> {
			System.out.println("filter: " + n);
			return n > 10;
		}).map(n -> {
			System.out.println("map: " + n);
			return n * 2;
		}).findFirst();
//				 5
//				 ↓
//				filter → false
//		
//				10
//				 ↓
//				filter → false
//		
//				15
//				 ↓
//				filter → true
//				 ↓
//				map → 30
//				 ↓
//				findFirst → STOP

		System.out.println("========== Common Mistakes ==========");
//		1. Forgetting Terminal Operation
//		2. Reusing a Stream
//		3. Using peek() for Business Logic
//			peek() is primarily intended for inspection/debugging.
//			Prefer explicit transformation or business logic outside the pipeline where appropriate.
//		4. Modifying Source
//			Avoid modifying the source collection while streaming it: ConcurrentModificationException
//			Use a separate result or appropriate collection operation.
		try {
			num1.stream().forEach(n -> num1.remove(n));
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
//		5. Shared Mutable State
//			Bad:
		List<Integer> result1 = new ArrayList<>();
		num1.parallelStream().forEach(result1::add);
//			Use:
		List<Integer> result2 = num1.parallelStream().collect(Collectors.toList());
//			The collector is designed for stream reduction.
//		6. Using parallelStream() Everywhere
//			Parallelism introduces overhead and can make small/simple workloads slower.
//		7. Using sorted() Just to Find Min
//			Avoid:
		System.out.println(num1.stream().sorted().findFirst());
//			Prefer:
		System.out.println(num1.stream().min(Integer::compareTo));
//		8. Using collect() When count() Is Enough
//			Instead of:
		long count1 = num1.stream().collect(Collectors.counting());
//			simply use:
		long count2 = num1.stream().count();
//			counting() becomes useful as a downstream collector:
//			groupingBy(
//			    Transaction::getStatus,
//			    Collectors.counting()
//			)
//		9. findAny() Ordering Assumption
//			Don't write code that assumes:
//				parallelStream().findAny()
//			returns the first element.
//			If you need the first element:
//				findFirst()
//		10. Side Effects
//			Avoid:
		List<Integer> res1 = new ArrayList<>();
		num1.stream().map(n -> {
			res1.add(n * 2);
			return n * 2;
		}).collect(Collectors.toList());
		System.out.println(res1);
//			You're mixing functional stream processing with external mutable state.
//			Prefer:
		List<Integer> res2 = num1.stream().map(n -> n * 2).collect(Collectors.toList());
		System.out.println(res2);

	}

//	Basic
//	1. What is Stream API?
//		  Stream API provides a declarative way to process collections and other data sources 
//		  using operations such as filtering, mapping, sorting, grouping and aggregation.
//	2. Is Stream a collection?
//		  No. A Stream represents a pipeline for processing elements from a source; 
//		  it doesn't store the elements itself.
//	3. Can a Stream be reused?
//		  No. A Stream is generally single-use. After a terminal operation, a new stream must be created.
//	4. What are intermediate operations?
//		  Operations that return another Stream and are generally lazy, such as filter(), map(), sorted() and distinct().
//	5. What are terminal operations?
//		  Operations that produce a final result or side effect and trigger stream processing, 
//		  such as collect(), reduce(), count() and forEach().
//	6. What is lazy evaluation?
//		  Intermediate stream operations aren't executed when they're declared. 
//		  They execute when a terminal operation triggers the pipeline.

//	reduce() Questions
//	7. What is reduce()?
//		  reduce() combines stream elements into a single result.
//	8. Why does reduce() sometimes return Optional?
//		  When no identity is supplied, the stream might be empty, 
//		  so Java uses Optional to represent the absence of a result.
//	9. What is the identity in reduce()?
//		  The identity is the initial value that doesn't change the result of the reduction, 
//		  such as 0 for addition or 1 for multiplication.
//	10. What is the combiner in reduce()?
//		  In the three-argument form, the combiner merges partial results, which is particularly important for parallel reduction.
//	11. reduce() vs collect()?
//		  reduce() is generally for combining elements into a value; 
//		  collect() is designed for mutable reduction and collecting into structures such as lists, maps and grouped results.

//	Parallel Stream Questions
//	12. What is a parallel stream?
//		  A stream that can process elements concurrently using multiple threads.
//	13. How do you create one?
//		  list.parallelStream();
//		  list.stream().parallel();
//  14. Is parallel stream always faster?
//		  No. Thread-management, splitting and combining introduce overhead. It depends on data size, workload and hardware.
//	15. When should you use parallel streams?
//		  Mainly for sufficiently large, CPU-intensive, independent operations where benchmarking shows a benefit.
//	16. Are parallel streams suitable for database calls?
//	      Usually not as a default design. Parallelizing blocking I/O can consume threads and overload downstream systems.
//	17. Is ordering guaranteed with parallel forEach()?
//		  No. Use forEachOrdered() when encounter order is required.
//	Performance Questions
//	18. Are streams faster than loops?
//		  Not inherently. Streams often improve readability, while performance depends on the workload.
//	19. Why can streams be slower?
//		  Lambda invocation, pipeline machinery, boxing, allocation and other overhead can outweigh their benefits for simple operations.
//	20. How can you improve numeric stream performance?
//		  Consider primitive streams such as IntStream, LongStream and DoubleStream to reduce boxing/unboxing.
//	21. How can short-circuiting improve performance?
//		  Operations such as findFirst(), findAny(), anyMatch() and limit() can stop processing once the required result is known.
	
//	Internal Working Questions
//	22. What are the three components of a Stream pipeline?
//		  Source → Intermediate Operations → Terminal Operation
//	23. Are intermediate operations executed immediately? What triggers execution?
//		  No. They are generally lazy. A terminal operation triggers execution.
//	24. What happens if there is no terminal operation?
//		  The intermediate operations aren't executed.
//	25. Does every intermediate operation create a new collection?
//		  No. The stream framework can process elements through the pipeline without materializing a collection at each stage.
	
	
}
