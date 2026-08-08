package com.jana.collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapClass {

//	Java 1.4: LinkedHashMap was introduced, bringing both insertion order (default) and access order configurations.
//	LinkedHashMap Internal Working
//	LinkedHashMap extends HashMap and adds a doubly linked list to maintain the order of entries.
//			LinkedHashMap
//			    |
//			+------------+------------+
//			|                         |
//		HashMap buckets          Doubly linked list
//			|                         |
//			v                         v
//		[0] [1] [2] [3] ...       A <-> B <-> C
//	Inside the Bucket (Locally): Singly-Linked List using the .next pointer to handle hash collisions.
//		i.e) The nodes connect to each other locally using a Singly-Linked List via the .next pointer.
//	Across the Map (Globally): Doubly-Linked List using the .before and .after pointers to maintain the chronological iteration order.
//		i.e) The exact same nodes connect to each other globally using a Doubly-Linked List via .before and .after pointers.
//	the hash table finds the entry; the doubly linked list maintains the iteration order.
//	LinkedHashMap uses the same basic hash-table mechanism as HashMap:
//				key
//				 ↓
//				hashCode()
//				 ↓
//				hash
//				 ↓
//				bucket index
//				 ↓
//				entry
//	But each entry additionally maintains links to the previous and next entries.
//	The linked list is what preserves iteration order.
//	
//	put() Internal Working
//		1. Calculate hash
//		    ↓
//		2. Find bucket
//		    ↓
//		3. Check whether key exists
//		    ↓
//		4. If new → create entry
//		    ↓
//		5. Put entry into HashMap bucket
//		    ↓
//		6. Link entry into LinkedHashMap's doubly linked list
//	The exact internal insertion/linking is handled by LinkedHashMap's overridden hooks around HashMap operations.
	
//	Why Hashmap plus Doubly LinkedList, why not Singly Linked List?
//		LinkedHashMap uses a doubly linked list because each entry needs to maintain its previous and next entries. 
//		This allows an entry to be removed or moved within the ordering in O(1), which is particularly important for access-order mode and LRU-cache implementations. 
//		A singly linked list would require finding the previous node, potentially making these operations O(n).
		

	public static void main(String[] args) {

//		LinkedHashMap extends HashMap and uses the same hash-table mechanism for key-value storage. 
//		In addition, each entry maintains before and after references, forming a doubly linked list. 
//		This linked list maintains insertion order by default, while an accessOrder option can maintain access order. 
//		Therefore, LinkedHashMap provides average O(1) lookup like HashMap while preserving predictable iteration order, 
//			at the cost of additional memory for the linked-list pointers.
		LinkedHashMap<Integer, String> map = new LinkedHashMap<>();

		map.put(10, "A");
		map.put(20, "B");
		map.put(30, "C");
		
//		Access Order (most important LinkedHashMap interview concept)
//		Constructor => new LinkedHashMap<>(16, 0.75f, true);
//		The third parameter:
//			accessOrder = true
//			means the map maintains access order instead of insertion order.
		LinkedHashMap<Integer, String> accessMap = new LinkedHashMap<>(16, 0.75f, true);

		accessMap.put(1, "A");
		accessMap.put(2, "B");
		accessMap.put(3, "C");
		System.out.println(accessMap.keySet());
//		Initially: 1 <-> 2 <-> 3
		accessMap.get(2);
//		On Access: Calling .get(), .getOrDefault(), .put(), or .replace() on a key instantly moves 
//			that key-value pair to the very end (tail) of the iteration order.
		System.out.println(accessMap.keySet());
//		This feature makes LinkedHashMap useful for implementing LRU caches.
//		The Result: The first element returned during iteration is always the Least Recently Used (LRU), 
//			and the last element is the Most Recently Used (MRU).
//		LRU Cache Example
		LinkedHashMap<Integer, String> cache =
		        new LinkedHashMap<>(3, 0.75f, true) {
//			Java 7 & 8: Completely banned using the diamond operator <> on anonymous inner classes. 
//				The compiler required full type specifications on the right side. ex: LinkedHashMap<Integer,String>
//			Java 9 and newer: The compiler was upgraded to allow <> with anonymous inner classes if the inferred type is denotable.
		            @Override
		            protected boolean removeEldestEntry(
		                    Map.Entry<Integer, String> eldest) {
		                return size() > 3;
		            }
		        };
		cache.put(2, "Two");
		cache.put(3, "Three");
		cache.put(1, "One");
		cache.put(4, "Four");
		System.out.println(cache);
		cache.get(1);
		System.out.println(cache);

		        
	}

//	| Feature            | HashMap               | LinkedHashMap |
//	| ------------------ | --------------------- | ------------- |
//	| Hash table         | ✅                     | ✅             |
//	| Average `get()`    | O(1)                  | O(1)          |
//	| Average `put()`    | O(1)                  | O(1)          |
//	| Insertion order    | ❌                     | ✅             |
//	| Access order       | ❌                     | ✅             |
//	| Doubly linked list | ❌                     | ✅             |
//	| Memory             | Lower                 | Higher        |
//	| LRU cache          | Not directly suitable | ✅             |

}
