package com.jana.collections;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class HashSetClass {

//	HashSet is internally backed by a HashMap.
//	Set value stored in HashMap key with a default value of PRESENT
//	HashSet
//	   |
//	   v
//	HashMap
//	   |
//	   +-- "Java"   -> PRESENT
//	   +-- "Spring" -> PRESENT
//	
//	What does HashSet.add() actually do?
//			HashSet maintains an internal HashMap and uses a dummy object as the value.
//			The element is the HashMap key.
//	How does duplicate prevention work?
//		Calculate "Java".hashCode()
//		Find the bucket.
//		Search that bucket.
//		Compare the existing key using equals().
//		Since "Java".equals("Java") is true, HashMap finds that the key already exists.
//		No new entry is inserted.
//	If the element is newly added: hashSet.add() return true, else if already exists return false
//	Collision Handling same like Hashmap
	public static void main(String[] args) {
//		HashSet internally uses a HashMap. Each Set element is stored as a HashMap key with a constant dummy value. During add(), 
//		HashMap uses the element's hashCode() to locate the bucket and equals() to determine whether an equivalent key already exists. 
//		If it exists, the element is not added. This is how HashSet maintains uniqueness.
		Set<String> set = new HashSet<>();

		set.add("Java");
		set.add("Spring");
		set.add("Java");
		set.add("Kafka");
		System.out.println(set);

		System.out.println("======= Concurrent Hash Set ========");
//		Java does not provide a standard ConcurrentHashSet class.
//		The High-Throughput Way: ConcurrentHashMap.newKeySet() [Recommended]
		Set<String> set1 = ConcurrentHashMap.newKeySet();
		set1.add("ThreadSafeData");
		System.out.println(set1.contains("ThreadSafeData"));
//		The Legacy Way: Collections.synchronizedSet()
		Set<String> set2 = Collections.synchronizedSet(new HashSet<>());
		set2.add("Java");
		set2.add("Spring");
		set2.add("Java");
		set2.add("Kafka");
		synchronized (set2) {
			for (String item : set2) {
				System.out.println(item);
			}
		}
//		Read-Heavy Way: CopyOnWriteArraySet
		Set<String> set3 = new CopyOnWriteArraySet<>();
		set3.add("Java");
		set3.add("Spring");
		set3.add("Java");
		set3.add("Kafka");
		System.out.println(set3);
		for (String item : set3) {
			if (item.equals("Java")) {
//				Modifying Set in loop, Fail-Safe, normal HashSet throw ConcurrentModificationException(Fail-fast)
				set3.add("Java 17");
			}
		}
		System.out.println(set3);

	}

//	| HashSet                        | HashMap                        |
//	| ------------------------------ | ------------------------------ |
//	| Stores unique elements         | Stores key-value pairs         |
//	| Internally uses HashMap        | Uses bucket array              |
//	| Element becomes HashMap key    | Key + value                    |
//	| Dummy `PRESENT` value          | Actual value                   |
//	| No duplicate elements          | Duplicate values allowed       |
//	| One `null` element allowed     | One `null` key allowed         |
//	| Uses `hashCode()` + `equals()` | Uses `hashCode()` + `equals()` |

//	| Feature              | HashSet      | LinkedHashSet | TreeSet               | Concurrent Set        |
//	| -------------------- | ------------ | ------------- | --------------------- | --------------------- |
//	| Internal map         | HashMap      | LinkedHashMap | TreeMap               | ConcurrentHashMap     |
//	| Thread-safe          | ❌           | ❌            | ❌                    | ✅                     |
//	| Ordering             | No guarantee | Insertion     | Sorted                | No ordering guarantee |
//	| Average `add()`      | O(1)         | O(1)          | O(log n)              | O(1)                  |
//	| Average `contains()` | O(1)         | O(1)          | O(log n)              | O(1)                  |
//	| `null`               | One allowed  | One allowed   | Depends on comparator | ❌                     |
//	| High concurrency     | ❌            | ❌           | ❌                    | ✅                     |

}
