package com.jana.collections;

import java.util.TreeSet;

public class TreeSetClass {

//	TreeSet internally uses a TreeMap, 
//	storing each set element as a key and a dummy PRESENT object as the value.
//	TreeSet itself doesn't sort the elements separately; 
//	the underlying Red-Black Tree maintains their sorted relationship.
	
//	Important difference from HashSet
//	HashSet determines equality primarily through: hashCode() + equals()
//	TreeSet determines uniqueness through: compareTo() or Comparator.compare()
//	If:	compare(a, b) == 0 .TreeSet treats the two elements as duplicates for Set purposes.
	public static void main(String[] args) {
//		TreeSet internally uses a TreeMap, and the TreeMap is implemented using a Red-Black Tree. 
//		When an element is added to TreeSet, it is stored as a key in the underlying TreeMap with a dummy PRESENT object as the value.
//		The element's natural ordering or a supplied Comparator determines its position in the tree. 
//		If comparison returns zero, TreeSet considers the element a duplicate and doesn't add it. 
//		Since the Red-Black Tree remains balanced, add, remove, and contains take O(log n), and iteration produces elements in sorted order.
		TreeSet<Integer> set = new TreeSet<>();

		set.add(30);
		set.add(10);
		set.add(20);
		set.add(35);
		
		System.out.println(set);
	}

//	| Feature                    | HashSet             | LinkedHashSet                   | TreeSet        |
//	| -------------------------- | ------------------- | ------------------------------- | -------------- |
//	| Internally uses            | HashMap             | LinkedHashMap                   | TreeMap        |
//	| Structure                  | Hash table          | Hash table + doubly linked list | Red-Black Tree |
//	| Duplicate                  | ❌                   | ❌                               | ❌              |
//	| Order                      | No guaranteed order | Insertion order                 | Sorted order   |
//	| `add()`                    | O(1) avg.           | O(1) avg.                       | O(log n)       |
//	| `contains()`               | O(1) avg.           | O(1) avg.                       | O(log n)       |
//	| `remove()`                 | O(1) avg.           | O(1) avg.                       | O(log n)       |
//	| Uses hashCode              | ✅                   | ✅                               | ❌              |
//	| Uses Comparator/Comparable | ❌                   | ❌                               | ✅              |

}
