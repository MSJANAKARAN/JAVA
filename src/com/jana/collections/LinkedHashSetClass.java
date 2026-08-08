package com.jana.collections;

import java.util.LinkedHashSet;

public class LinkedHashSetClass {

//	LinkedHashSet Internal Working
//	LinkedHashSet extends HashSet, and internally it uses a LinkedHashMap instead of a normal HashMap.
	public static void main(String[] args) {
//		LinkedHashSet extends HashSet and internally uses a LinkedHashMap. 
//		When we add an element, the element becomes the key of the LinkedHashMap and a dummy PRESENT object is used as its value. 
//		The hash table provides efficient O(1) average lookup and uniqueness through hashCode() and equals(), 
//			while LinkedHashMap's doubly linked list maintains insertion order. 
//		Therefore, LinkedHashSet provides unique elements while preserving insertion order.
		LinkedHashSet<String> set = new LinkedHashSet<>();

		set.add("Java");
		set.add("Spring");
		set.add("Kafka");
		System.out.println(set);
	}

//	| Feature                   | HashSet | LinkedHashSet |
//	| ------------------------- | ------- | ------------- |
//	| Internal map              | HashMap | LinkedHashMap |
//	| Unique elements           | ✅       | ✅             |
//	| Hash table                | ✅       | ✅             |
//	| Maintains insertion order | ❌       | ✅             |
//	| Doubly linked list        | ❌       | ✅             |
//	| Average `add()`           | O(1)    | O(1)          |
//	| Average `contains()`      | O(1)    | O(1)          |
//	| Extra memory              | Lower   | Higher        |

}
