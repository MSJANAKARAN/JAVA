package a.com.jana.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreamAPI {
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
//	Intermediate Operations
//		Transform a stream into another stream.
//		Examples:
//			filter()   -selects elements based on a condition.
//			map() 	   -transforms each element into another value. Can Change the Type also
//			flatMap()  -Produces a single flattened stream
//			sorted()   -Sort elements
//			distinct() -Remove duplicates
//			peek()     -Inspect/debug elements
//			limit()    -Take first N elements (Short-Circuiting)
//			skip()     -Skip first N elements
//			boxed()    -convert a primitive stream into an object stream
//			takeWhile()-[Java 9] It checks elements sequentially. When predicate turns false, it shuts down the pipeline. (Short-Circuiting)
//			takeWhile()-[Java 9] It drops elements while the predicate is true. it cannot discard elements without reading them all, (NOT Short-Circuiting)

//		They are generally lazy.
//	Terminal Operations
//		End the stream pipeline and produce a result or side effect.
//		Examples:
//			forEach()  -Process each element
//			collect()  -accumulate stream elements into a result.
//			reduce()   -combine all elements of a stream into a single summary result.
//			count()    -Count elements
//			min()      -Find minimum
//			max()      -Find maximum
//			findFirst()-Find first element (Short-Circuiting)
//			findAny()  -Find any element (Short-Circuiting)
//			anyMatch() -Check if at least one matches (Short-Circuiting)
//			allMatch() -Check if all match (Short-Circuiting)
//			noneMatch()-Check if none match (Short-Circuiting)
//			toList()   -[Java 16] .toList() instead of .collect(Collectors.toList())
//	Short Circuiting Operations
//		short-circuiting refers to intermediate or terminal operations that can produce a finite result even when processing an infinite stream as input, 
//		or skip evaluating the remaining elements of a large stream as soon as a condition is satisfied.
//	
//	Why Are Intermediate Operations Lazy?
//		Intermediate operations are lazy because they don't execute until a terminal operation triggers the stream pipeline.
//		i.e) To allow the Stream implementation to optimize the pipeline and process elements only when a terminal result is required.
//	Important Stream Characteristics
//		1. Streams don't modify the original collection
//		2. A Stream Cannot Normally Be Reused
//		3. Intermediate Operations Are Lazy
//		4. Streams Can Be Sequential or Parallel
//		5. Streams run element by element

	public static void main(String[] args) {

		System.out.println("========== Creating Streams ==========");
		System.out.println("------ From Collection ------");

		List<String> names1 = Arrays.asList("John", "Alice", "Bob", "David");
		List<String> names2 = List.of("John", "Alice", "Bob", "David"); // Java 9 List.of
		List<Integer> num1 = Arrays.asList(7, 3, 4, 8);
		names1.stream().forEach(System.out::println);

		System.out.println("------ From Collection Set ------");
		Set<String> names3 = Set.of("John", "Alice", "Bob", "David"); // Java 9 Set.of
		names3.stream().forEach(System.out::println);

		System.out.println("------ From Collection Map ------");
//		A Map is structured as Key-Value pairs, so you have to choose which part of 
//		the map you want to stream using one of three conversion methods
//		1. Stream the Entries (Keys + Values together) [.entrySet()]
		Map<String, Integer> maps1 = Map.of("Alice", 25, "Bob", 30, "John", 24);
		maps1.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
//		2. Stream only the Keys [.keySet()]
		maps1.keySet().stream().forEach(entry -> System.out.println(entry));
//		2. Stream only the Values [.values()]
		maps1.values().stream().forEach(System.out::println);

		System.out.println("\n------ Using Array ------");
		String[] names4 = { "John", "Alice", "Bob", "David" };
		int[] num2 = { 7, 3, 4, 8 };
		Arrays.stream(names4).forEach(System.out::println);
		IntStream stream1 = Arrays.stream(num2); // For Primitive Arrays
		stream1.forEach(System.out::println);

		System.out.println("\n------ Using Stream.of() ------");
		Stream<String> stream2 = Stream.of("Java", "Spring", "Kafka");
		stream2.forEach(System.out::println);

		System.out.println("\n------ Empty Stream ------");
		Stream<String> emptyStream1 = Stream.empty();
		emptyStream1.forEach(System.out::println);
		String name1 = null;
		Stream<String> emptyStream2 = Stream.ofNullable(name1); // Java 9 - If name is null, it creates an empty stream.
		emptyStream2.forEach(System.out::println);

//		Primitive Streams
//			IntStream
//			LongStream
//			DoubleStream
		
		System.out.println("\n------ Infinite Stream with generate() ------");
//		Produces a collection of independent values.
		Stream.generate(Math::random).limit(4).forEach(System.out::println);

		System.out.println("\n------ Infinite Stream with iterate() ------");
//		Produces a sequence.
		Stream<Integer> num3 = Stream.iterate(1, n -> n + 1);
		num3.limit(4).forEach(System.out::println);
		System.out.println(Stream.generate(() -> "---").limit(30).collect(Collectors.joining()));
		Stream.iterate(1, n -> n < 5, n -> n + 1).forEach(System.out::println); // Java 9

		System.out.println("========== Intermediate vs Terminal Operations ==========");
		System.out.println("\n------ sorted() ------");
		List<Integer> list1 = num1.stream().sorted().collect(Collectors.toList());
		System.out.println(list1);
		List<Integer> list2 = Arrays.stream(num2).sorted().boxed().collect(Collectors.toList());
		System.out.println(list2);

		System.out.println("\n------ sorted() reverse------");
		List<Integer> list3 = num1.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		System.out.println(list3);
		List<Integer> list4 = Arrays.stream(num2).sorted().boxed().collect(Collectors.toList());
		System.out.println(list4);

		System.out.println("\n------ Objects sorted() ------");
		Account acc1 = new Account("ACC1", 4500);
		Account acc2 = new Account("ACC3", 2500);
		Account acc3 = new Account("ACC2", 7500);
		Account acc4 = new Account("ACC1", 5500);
		Account acc5 = new Account("ACC2", 5400);

		List<Account> account1 = List.of(acc1, acc2, acc3);

		List<Account> list5 = account1.stream().sorted(Comparator.comparing(Account::getBalance))
				.collect(Collectors.toList());
		System.out.println(list5);// don't forget to add toString to print values
		List<Account> list6 = account1.stream().sorted((a1, a2) -> a1.getBalance() - a2.getBalance())
				.collect(Collectors.toList());
		System.out.println(list6);

		System.out.println("\n------ Objects sorted() reverse------");
		List<Account> list7 = account1.stream().sorted(Comparator.comparing(Account::getBalance).reversed())
				.collect(Collectors.toList());
		System.out.println(list7);
		List<Account> list8 = account1.stream().sorted((a1, a2) -> a2.getBalance() - a1.getBalance())
				.collect(Collectors.toList());
		System.out.println(list8);

		System.out.println("\n------ reduce() ------");
		int totalBalance = account1.stream().map(value -> value.getBalance()).reduce(0, Integer::sum); // .reduce(0,(a,b)->a+b)
		System.out.println(totalBalance);

		System.out.println("\n------ collect() Collectors.toList() ------");
		List<String> names5 = Stream.of("John", "Alice", "Bob").collect(Collectors.toList());
		System.out.println(names5);
//		The list returned by Collectors.toList() is not guaranteed by the Collector contract to be a particular List implementation or to have a particular mutability guarantee.

		System.out.println("\n------ collect() Collectors.toSet() ------");
		Set<String> names6 = Stream.of("John", "Alice", "Bob").collect(Collectors.toSet());
		System.out.println(names6);
//		Duplicates are removed. The exact iteration order is not guaranteed.

		System.out.println("\n------ collect() Collectors.toMap() ------");
//		Collectors.toMap(keyMapper,valueMapper)
		Map<String, Integer> map1 = account1.stream()
				.collect(Collectors.toMap(Account::getAccountNumber, Account::getBalance));
		System.out.println(map1);

//		Duplicate Key Problem - IllegalStateException if two same accountNumber exists
		List<Account> account2 = List.of(acc1, acc2, acc3, acc4, acc5);
		Map<String, Integer> map2 = account2.stream()
				.collect(Collectors.toMap(Account::getAccountNumber, Account::getBalance, (oldKey, newKey) -> newKey));
		System.out.println(map2);

		System.out.println("\n------ collect() Collectors.joining() ------");
		System.out.println(Stream.of("Java", "Spring", "Boot").collect(Collectors.joining(", ")));
		System.out.println(Stream.of("Java", "Spring", "Boot").collect(Collectors.joining(", ", "[", "]")));

		System.out.println("\n------ collect() Collectors.groupingBy() ------");
//		It groups elements based on a key. similar to SQL: GROUP BY
		Map<String, List<Account>> map3 = account2.stream().collect(Collectors.groupingBy(Account::getAccountNumber));
		System.out.println(map3);

		System.out.println("\n------ collect() Collectors.groupingBy() + counting() ------");
		// counting() - counts to grouped data as Long
		Map<String, Long> map4 = account2.stream()
				.collect(Collectors.groupingBy(Account::getAccountNumber, Collectors.counting()));
		System.out.println(map4);

		System.out.println("\n------ collect() Collectors.groupingBy() + summingDouble() ------");
		Map<String, Integer> map5 = account2.stream()
				.collect(Collectors.groupingBy(Account::getAccountNumber, Collectors.summingInt(Account::getBalance)));
		System.out.println(map5);

		System.out.println("\n------ collect() Collectors.partitioningBy() ------");
//		partitioningBy() divides elements into exactly two groups based on a boolean condition
		Map<Boolean, List<Map.Entry<String, Integer>>> map6 = map5.entrySet().stream()
				.collect(Collectors.partitioningBy(n -> n.getValue() >= 10000));
		System.out.println(map6);
		// Extra: To Transform Stream<Entry> into Stream<Value> using Map
		// .map(Map.Entry::getValue)

//		| `groupingBy()`         | `partitioningBy()`           |
//		| ---------------------- | ---------------------------- |
//		| Groups by a key        | Divides by boolean condition |
//		| Can create many groups | Two groups: true/false       |
//		| `Map<K, List<T>>`      | `Map<Boolean, List<T>>`      |

		System.out.println("\n------ collect() mapping() ------");
//		mapping() is a downstream collector. It allows you to transform elements inside another collector, such as groupingBy()
		Map<String, List<Integer>> map7 = account2.stream().collect(Collectors.groupingBy(Account::getAccountNumber,
				Collectors.mapping(Account::getBalance, Collectors.toList())));
		System.out.println(map7);

		System.out.println("\n------ collect() Collectors.partitioningBy() + mapping() ------");

		Map<Boolean, List<String>> map8 = map5.entrySet().stream()
				.collect(Collectors.partitioningBy(n -> n.getValue() >= 10000, // partioning condition
						Collectors.mapping(Map.Entry::getKey, Collectors.toList()))); // collect only account names
//		 Fetching Key of map5 and storing as value in map8. Map entering stream as Entry, we need to map to correct type
		System.out.println(map8);

		System.out.println("\n------ collect() Collectors.collectingAndThen() ------");
//		collectingAndThen() performs a collection operation and then applies another function to the result.
		List<Integer> list9 = Stream.of(2, 3, 4, 5, 3)
				.collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
//		Collections::unmodifiableList making list immutable
		System.out.println(list9);

		System.out.println("\n------ collect() Collectors.summarizingInt() ------");
//		Creates summary statistics for integer values like count() sum()	min() max()	average()
		IntSummaryStatistics stats = Stream.of(2, 3, 4, 5, 3).collect(Collectors.summarizingInt(Integer::intValue));
		System.out.println(stats);

		System.out.println("\n------ collect() Averaging Collectors ------");
//		averagingInt() averagingLong() averagingDouble()
		double average1 = account2.stream().collect(Collectors.averagingDouble(Account::getBalance));
		System.out.println(average1);

		System.out.println("\n------ collect() Collectors.teeing() ------");
//		Java 12 introduced Collectors.teeing(), which allows you to split a single stream data flow into 
//		two separate collectors simultaneously, and then merge their individual results using a user-defined bi-function.
		double average2 = Stream.of(10, 20, 30, 40).collect(Collectors.teeing(Collectors.summingDouble(n -> n),
				Collectors.counting(), (sum, count) -> sum / count));
//		 Collector 1: Get the sum, Collector 2: Get the total count, Merger: Divide sum by count
		System.out.println(average2);

	}

	static class Account {
		String accountNumber;
		int balance;

		public Account(String acc, int amt) {
			accountNumber = acc;
			balance = amt;
		}

		public String getAccountNumber() {
			return accountNumber;
		}

		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}

		public int getBalance() {
			return balance;
		}

		public void setBalance(int balance) {
			this.balance = balance;
		}

		@Override
		public String toString() {
			return "Account [accountNumber=" + accountNumber + ", balance=" + balance + "]";
		}
	}

//	| Collector             | Purpose                            | Result                 |
//	| --------------------- | ---------------------------------- | ---------------------- |
//	| `toList()`            | Collect into List                  | `List<T>`              |
//	| `toSet()`             | Collect unique elements            | `Set<T>`               |
//	| `toMap()`             | Create key-value map               | `Map<K,V>`             |
//	| `joining()`           | Join strings                       | `String`               |
//	| `groupingBy()`        | Group by key                       | `Map<K, ...>`          |
//	| `partitioningBy()`    | Divide by condition                | `Map<Boolean, ...>`    |
//	| `mapping()`           | Transform inside another collector | Depends on downstream  |
//	| `collectingAndThen()` | Collect then transform result      | Depends on finisher    |
//	| `summarizingInt()`    | Count/sum/min/max/avg              | `IntSummaryStatistics` |
//	| `averagingInt()`      | Average integer values             | `double`               |
//	| `averagingLong()`     | Average long values                | `double`               |
//	| `averagingDouble()`   | Average double values              | `double`               |
//	| `counting()`          | Count elements                     | `Long`                 |

}
