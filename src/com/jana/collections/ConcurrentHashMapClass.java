package com.jana.collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapClass {

//	ConcurrentHashMap Internal Working
//	ConcurrentHashMap is a thread-safe Map designed for high concurrency. It allows 
//	multiple threads to read/update different parts of map concurrently without locking entire map.
//	
//	Java 7
//	ConcurrentHashMap used: Segment-based locking
//		ConcurrentHashMap
//		 ├── Segment 1 → buckets
//		 ├── Segment 2 → buckets
//		 ├── Segment 3 → buckets
//		 └── Segment 4 → buckets
//		 Each segment had its own lock.
//	Java 8+
//	The implementation changed significantly. It no longer uses the old Segment architecture.
//	
//	Uses:	Bucket array
//				+
//		Compare-And-Swap (CAS)
//			    +
//		synchronized on individual bins when required
//				+
//		Red-Black Tree for heavily-collided bins
//	A bucket can contain: Linked List or Red-Black Tree
//	How put() Works?
//	If the bucket is empty, ConcurrentHashMap attempts to insert the node using CAS.
//		Compare-And-Swap : It is an atomic CPU-level operation. This avoids locking the entire map.
//	if the Bucket Already Contains a Node.
//    	ConcurrentHashMap uses synchronization around the affected bin/node when necessary
//    	It does not lock the entire map. Only the relevant bucket/bin is protected for the contended update.
//	Collision Handling - Just like modern HashMap
//	Why CAS + synchronized?
//			Empty bucket : use CAS
//			Existing bucket : use synchronized in bucket
//	
//	How Does get() Work?
//			Reads generally do not require locking.	This allows multiple threads to perform reads concurrently.

	private static final ConcurrentHashMap<String, Integer> transactionCount = new ConcurrentHashMap<>();

	public static void main(String[] args) throws InterruptedException {

//		HashMap is not thread-safe.
		Map<String, Integer> map = new HashMap<>();
//		You could synchronize the whole map:
		Map<String, Integer> smap = Collections.synchronizedMap(new HashMap<>());
//		But this can cause contention because operations effectively require synchronization around the map

//		ConcurrentHashMap is a thread-safe hash-based map designed for high concurrent access. 
//		In Java 8+, it uses a bucket array and avoids a global lock. 
//		For insertion into an empty bucket, it can use CAS, 
//		while modifications to an existing bin may synchronize on that bin. 
//		Collisions are handled using linked nodes and can be treeified into Red-Black Trees under high collision conditions. 
//		Reads generally don't require locking, and the map provides atomic operations such as putIfAbsent, computeIfAbsent, and merge. 
//		It doesn't allow null keys or values and provides weakly consistent iterators.
		Runnable task = () -> {
			for (int i = 0; i < 1000; i++) {
				// hash map
				map.put("ACC1000", smap.getOrDefault("ACC1000", 0) + 1);

				// synchronized map
				synchronized (smap) {
					smap.put("ACC1001", smap.getOrDefault("ACC1001", 0) + 1);
				}
				// concurrent hashmap
				transactionCount.merge("ACC1002", 1, Integer::sum);
			}
		};
//      Use ConcurrentHashMap when multiple threads need to access and modify a shared map. 
//      Use atomic methods such as putIfAbsent(), computeIfAbsent(), and merge() when the complete update operation must be thread-safe.
		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		Thread t3 = new Thread(task);

		t1.start();
		t2.start();
		t3.start();

		t1.join();
		t2.join();
		t3.join();

		System.out.println(map);
		System.out.println(smap);
		System.out.println(transactionCount);

		System.out.println("======= Concurrent Hash Set ========");
//		Java does not provide a standard ConcurrentHashSet class.
//		The High-Throughput Way: ConcurrentHashMap.newKeySet()
//		The Legacy Way: Collections.synchronizedSet()
//		Read-Heavy Way: CopyOnWriteArraySet
	}
//	Fail-Safe
//	ConcurrentHashMap does not provide a traditional fail-fast iterator like many ordinary collections.
//	It does not throw ConcurrentModificationException merely because another thread modifies the map.
//			
//	| Feature                | `HashMap`           | Synchronized Map                            | `ConcurrentHashMap`                             |
//	| ---------------------- | ------------------- | ------------------------------------------- | ----------------------------------------------- |
//	| Creation               | `new HashMap<>()`   | `Collections.synchronizedMap()`             | `new ConcurrentHashMap<>()`                     |
//	| Thread-safe            | ❌                  | ✅                                          | ✅                                               |
//	| Internal structure     | Hash table          | Backing `HashMap` + synchronization         | Hash table + CAS + fine-grained synchronization |
//	| Concurrent reads       | Unsafe              | Synchronized                                | Efficient                                       |
//	| Concurrent writes      | Unsafe              | One lock                                    | High concurrency                                |
//	| Locking                | None                | Map-level/coarse-grained                    | Fine-grained/bin-level + CAS                    |
//	| `get()` average        | O(1)                | O(1)                                        | O(1)                                            |
//	| `put()` average        | O(1)                | O(1)                                        | O(1)                                            |
//	| `null` key             | ✅ One              | Depends on backing map                      | ❌                                               |
//	| `null` value           | ✅                  | Depends on backing map                      | ❌                                               |
//	| Atomic `putIfAbsent()` | ❌                  | Not a compound atomic operation             | ✅                                               |
//	| Atomic `merge()`       | ❌                  | Not the main advantage                      | ✅                                               |
//	| High concurrency       | ❌                  | Poorer                                      | ✅ Best choice                                   |
//	| Iterator behavior      | Fail-fast generally | Requires synchronization for safe iteration | Weakly consistent(Fail-safe)                               |


//	Does ConcurrentHashMap Allow null?
//		Neither keys nor values can be null. Because in a concurrent environment, 
//		null would make it difficult to distinguish between key is absent and key exists with null value
}
