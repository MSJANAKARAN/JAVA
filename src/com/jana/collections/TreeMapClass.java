package com.jana.collections;

import java.util.TreeMap;

public class TreeMapClass {
//	TreeMap Internal Working
//	TreeMap is internally implemented using a Red-Black Tree, which is a self-balancing binary search tree.
//	Unlike HashMap and LinkedHashMap, TreeMap does not use buckets or hashing hashCode().
//	TreeMap stores and handles key-value pairs by wrapping each pair inside a single, 
//	dedicated node object called an Entry, which acts as a node in its Red-Black Tree architecture
//	Why Red-Black Tree?
//		A normal Binary Search Tree can become unbalanced. 
//		TreeMap avoids this by using a self-balancing Red-Black Tree.
//		It keeps the tree approximately balanced, giving:
//			get()    → O(log n)
//			put()    → O(log n)
//			remove() → O(log n)
//	
//	How put() Works?
//		TreeMap compares the new key with existing keys.
//		example: 40 < 50 -> go left
//				 40 > 30 -> go right
//				 40 inserted
//		Natural ordering using Integer.compareTo() or custom Comparator
//	What Happens During get()?
//		TreeMap starts from the root.
//		example: 40 < 50 -> go left
//			 40 > 30 -> go right
//			 40 found
//	assuming the tree remains balanced.
//	
//	After insertion or deletion, TreeMap may need to rebalance the tree.
//	
//	How Does TreeMap Maintain Sorted Order?
//		TreeMap maintains sorted order because it stores entries in a Red-Black Tree. 
//		Keys are positioned according to their natural ordering or a supplied Comparator. 
//		During iteration, an in-order traversal of the tree visits the keys from smallest to largest, 
//		so TreeMap provides sorted-key iteration without separately sorting the entries.
	public static void main(String[] args) {
//		TreeMap internally uses a Red-Black Tree, which is a self-balancing binary search tree. 
//		When we insert or search for a key, TreeMap compares the key with existing nodes using 
//		either the natural ordering through Comparable or a supplied Comparator. 
//		Based on the comparison, it moves left or right in the tree. 
//		After insertion or deletion, Red-Black Tree rotations and recoloring maintain balance. 
//		Because the tree remains balanced, put, get, and remove take O(log n), 
//		and an in-order traversal provides keys in sorted order.
		TreeMap<Integer, String> map = new TreeMap<>();

		map.put(50, "A");
		map.put(30, "B");
		map.put(70, "C");
		map.put(20, "D");
		map.put(40, "E");
		System.out.println(map);
//		Because the data is sorted, TreeMap provides operations that HashMap doesn't naturally provide
		System.out.println(map.firstKey());
		System.out.println(map.lastKey());
		System.out.println(map.lowerKey(30));
		System.out.println(map.higherKey(30));
		System.out.println(map.floorKey(35));
		System.out.println(map.ceilingKey(35));

	}

//	| Feature            | HashMap         | LinkedHashMap            | TreeMap                          |
//	| ------------------ | --------------- | ------------------------ | -------------------------------- |
//	| Internal structure | Hash table      | Hash table + linked list | Red-Black Tree                   |
//	| Ordering           | None guaranteed | Insertion/access order   | Sorted by key                    |
//	| `get()` average    | O(1)            | O(1)                     | O(log n)                         |
//	| `put()` average    | O(1)            | O(1)                     | O(log n)                         |
//	| `remove()` average | O(1)            | O(1)                     | O(log n)                         |
//	| `hashCode()`       | Yes             | Yes                      | No                               |
//	| `Comparator`       | No              | No                       | Yes                              |
//	| Sorted keys        | ❌              | ❌                       | ✅                               |
//	| Null key           | One allowed     | One allowed              | Usually no with natural ordering |
//	| LRU use            | ❌              | ✅                       | ❌                               |

//	Because TreeMap must call a comparison method (key.compareTo(otherKey)) on every single insertion, 
//	it cannot accept null keys. If you try to pass null as a key, Java will instantly throw a NullPointerException 
//	because it cannot invoke a method on a null reference.

}
