package com.jana.datastructure;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
//	[Naive Approach - 1] LRU Cache using an Array of Nodes - O(n) Time and O(n) Space
//	[Naive Approach - 2] LRU Cache using Singly Linked List - O(n) Time and O(n) Space
	
//	[Expected Approach] LRU Cache using Doubly Linked List and Hashing- O(1) Time and O(1) Space
//		Input: [LRUCache cache = new LRUCache(2) , put(1 ,1) , put(2 ,2) , get(1) , put(3 ,3) , get(2) , put(4 ,4) , get(1) , get(3) , get(4)]
//		Output: [1 ,-1, -1, 3, 4]
//		Explanation: The values mentioned in the output are the values returned by get operations. 
//		Initialize LRUCache class with  capacity = 2.
//		cache.put(1, 1):  (key, pair) = (1,1) inserted and has the highest priority.
//		cache.put(2, 2):  (key , pair) = (2,2) inserted and has the highest priority.
//		cache.get(1):  For key 1, value is 1, so 1 returned and (1,1) moved to the highest priority.
//		cache.put(3, 3):  Since cache is full, remove least recently used that is (2,2),  (3,3) inserted with the highest priority.
//		cache.get(2): returns -1 (key 2 not found)
//		cache.put(4, 4): Since the cache is full, remove least recently used that is (1,1). (4,5) inserted with the highest priority.
//		cache.get(1): return -1 (not found)
//		cache.get(3): return 3 , (3,3) will moved to the highest priority.
//		cache.get(4): return 4 ,  (4,4) moved to the highest priority.
	private static int capacity;
	private static Map<Integer,Integer> cacheMap;
	private static LinkedList<Integer> lru;

	LRUCache(int capacity){
		LRUCache.capacity = capacity;
		cacheMap =new HashMap<>();
	    lru=new LinkedList<>();
	}
	
	public void put(int key,int value) {
		if(cacheMap.containsKey(key)) {
			cacheMap.put(key, value);
			lru.remove(Integer.valueOf(key));
		} else {
			if(cacheMap.size()>=capacity) {
				int lastKey = lru.removeLast();
				cacheMap.remove(lastKey);

			}
			cacheMap.put(key, value);
		}
		lru.addFirst(key);
	}
	
	public  int get(int key) {
		if(!cacheMap.containsKey(key)) {
			return -1;
		} 
		
		lru.remove(Integer.valueOf(key));
		lru.addFirst(key);
		return cacheMap.get(key);
	}
	
	public static class LRUCache1<K,V> extends LinkedHashMap<K,V>{
		private static final long serialVersionUID = 1L;
		private int capacity;
		
		public LRUCache1(int capacity) {
			super(capacity,0.75f,true);
			this.capacity=capacity;
		}
		
		@Override
	    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
	        // Evicts the least recently used item when size exceeds capacity
	        return size()>capacity;
	    }
		
		public V getCached(K key) {
			return super.get(key);
		}
		
		public void putCached(K key, V value) {
			super.put(key, value);
		}
	}
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(3);
		cache.put(1,1);
		cache.put(2,2);
		cache.put(3,3);
		System.out.println(cache.get(1));
		System.out.println(lru);

		cache.put(4,4);
		System.out.println(cache.get(2));
		System.out.println(lru);

		System.out.println(cache.get(3));
		System.out.println(lru);

//		You can implement a clean and efficient Least Recently Used (LRU) cache in Java 
//		by extending LinkedHashMap and overriding the removeEldestEntry method. 
//		Set the accessOrder parameter to true in the constructor to reorder elements on every read or write.
		System.out.println("-----------------------------------------------");
		LRUCache1<Integer,Integer> cache1 =new LRUCache1<>(3);
		// calling parent LinkedHashMap put instead of putCached, 
		cache1.put(1,1);
		cache1.put(2,2);
		cache1.putCached(3,3);
		
		System.out.println(cache1.get(1));

		cache1.put(4,4);
		System.out.println(cache1.get(2));

		System.out.println(cache1.get(3));
	}

}
