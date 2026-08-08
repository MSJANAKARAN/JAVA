package com.jana.collections;

import java.util.HashMap;

public class HashMapClass {
//	Java 1.2: HashMap was introduced
//	A HashMap internally consists of an array called buckets.
//	Initial capacoty 0 during hashmap creation.
//	During first put, hashmap initializes default capacity of 16. load factor of 0.75
//	can define both capacity and load factor in a HashMap. => new HashMap<>(initialCapacity, loadFactor); ex: new HashMap<>(64,0.75)
//	capcity will be in 16,32,64,128... upto 2power 30
//	While inserting data:
//		Compute the key's hash code. int hash = key.hashCode();
//		Improve hash distribution. hash = hash ^ (hash >>> 16)
//		Calculate the bucket index. index = (n - 1) & hash where n is current capacity
//		If bucket is empty: insert node
//		If bucket already contains nodes:
//			if key already exists (equals() returns true), update its value
//			Otherwise, add a new node
//			If many nodes,
//				Java 7: continue using linkedlist
//				Java 8: linkedlist convert to red-black tree when bucket size exceeds size 8 and bucket capacity >=64
//					if size exceeds and bucket capacity lesser, doubles the existing capacity and rehashes values to bucket
//	Collision Handling
//		A collision occurs when two different keys map to the same bucket.
//		Hashmap handles using linkedlist and red-black tree
//	Rehashing (Resizing)
//	LoadFactor = 0.75 for bucket capacity , initial capacity = 16
//		when number exceeds threshold 0.75 of capacity or bucket size exceeds 8 and less than 64 capacity, Capacity doubles.
//	Retrieving Data (get(key))
//		Compute the hash
//		Find the bucket index
//		Traverse the bucket: Compare hash values. Compare keys using equals()
//		Return the matching value.
//	
//	While removing data, HashMap or Set bucket capacity never shrinks,  
//		In a bucket when linkedlist size exceeds 8, converted red-black tree,then when size decreases to 6, red-black tree converted to linkedlist
//	
//	Why specifically a Red-Black Tree?
//			Java could theoretically use another balanced tree, but Red-Black Trees have useful properties:
//			Self-balancing
//			Search: O(log n)
//			Insertion: O(log n)
//			Deletion: O(log n)
//			Relatively low balancing overhead
//			Well suited to frequent modifications
	
	public static void main(String[] args) {
//		HashMap stores data in key–value pairs.
//		It uses an array of buckets internally.
//		The bucket index is computed from the key's hashCode().
//		If multiple keys map to the same bucket, collisions are handled using a linked list, 
//			which may be converted to a red-black tree in Java 8+.
//		hashCode() determines the bucket, and equals() identifies the correct key within that bucket.
//		When the number of entries exceeds capacity × load factor (default 16 × 0.75 = 12), 
//			the map resizes (rehashes) by doubling its capacity.
		HashMap<Integer, String> map = new HashMap<>();
		map.put(101, "Alice");
		
		System.out.println("======= Hash Table ========");
		
//		Hashtable Introduced in java 1.0 and is a legacy synchronized Map implementation. 
//		Internally, it uses an array of buckets and stores key-value entries based on the key's hash. 
//		During put() or get(), it calculates the hash, determines the bucket, and uses key comparison to find the exact entry. 
//		Collisions are handled using linked entries. Hashtable synchronizes its operations, making it thread-safe, 
//		but this coarse-grained synchronization can reduce concurrency. 
//		It also doesn't allow null keys or values. 
//		For modern highly concurrent applications, ConcurrentHashMap is generally preferred.
	}
	
//	| Operation  | Average | Worst Case                                              |
//	| ---------- | ------- | ------------------------------------------------------- |
//	| `put()`    | O(1)    | O(log n) with tree bins (O(n) in older implementations) |
//	| `get()`    | O(1)    | O(log n) with tree bins (O(n) in older implementations) |
//	| `remove()` | O(1)    | O(log n) with tree bins (O(n) in older implementations) |


	
}
