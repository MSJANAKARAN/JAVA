package com.jana.datastructure.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class HeapPriorityQueue {

	public static void main(String[] args) {
//		Top K / Kth largest / Kth smallest / continuously maintain min/max

//		Kth Largest Element
//		Use a min heap of size K.
		int[] arr = { 2, 4, 2, 6, 7, 12 };

		System.out.println("Kth Largest Element: " + kthLargest(arr, 3));

//		Top K Frequent Elements
		int[] arr1 = { 2, 4, 2, 6, 7, 2, 6, 7, 12 };

		System.out.println("Top K Frequent Elements: " + Arrays.toString(kFrequentElements(arr1, 3)));

//		Merge K Sorted Lists
//		Core idea:
//			Put first element of every list into min heap.
//			Take smallest.
//			Add next element from that list.
		List<List<Integer>> lists = List.of(List.of(2, 4, 5), List.of(6, 7), List.of(2, 6, 7, 12));

		System.out.println("Merge K Sorted Lists: " + mergeKSorted(lists));

	}

	static int kthLargest(int[] arr, int k) {
		// Min Heap
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		for (int a : arr) {
			heap.offer(a);

			if (heap.size() > k) {
				heap.poll();
			}
		}
		return heap.peek();
	}

	static int[] kFrequentElements(int[] arr, int k) {
		int[] result = new int[k];
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : arr) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

		for (int num : map.keySet()) {
			heap.offer(num);
			if (heap.size() > k) {
				heap.poll();
			}
		}
		for (int i = k - 1; i >= 0; i--) {
			result[i] = heap.poll();
		}
		return result;
	}

	static List<Integer> mergeKSorted(List<List<Integer>> lists){
		List<Integer> result = new ArrayList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		//It is ineffective, as list is already sorted, priority queue sorting again
		for(List<Integer> list:lists) {
			pq.addAll(list);
		}
		
		while(!pq.isEmpty()) {
			result.add(pq.poll());
		}
		return result;
	}

}
