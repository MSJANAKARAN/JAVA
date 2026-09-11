package com.jana.datastructure.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Hashing {

	public static void main(String[] args) {
//		Use HashMap / HashSet when you need fast lookup, frequency, duplicates, or complement checking.
		
//		Two Sum
//		Question: Find two indices whose values add up to target.
		
		int [] arr= {2,4,2,6,3,6,12};
		twoSum(arr,10);
		
//		Count Frequency
//		Pattern: Frequency → HashMap / groupingBy.
		countFrequency(arr);
		
//		First Non-Repeating Character
		System.out.println("First Non-Repeating Character: "+firstNonRepeating("aakash"));
	}
	static void twoSum(int[] arr,int target) {
		Map<Integer,Integer> map = new HashMap<>();
		
		for(int i=0;i<arr.length;i++) {
			int compliment = target - arr[i];
			
			if(map.containsKey(compliment)) {
				System.out.println("Indices add up to target are "+map.get(compliment)+" , "+i);

				return;
			}
			map.put(arr[i], i);
		}
	}
	
	static void countFrequency(int[] arr) {
		Map<Integer,Long> frequency = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		System.out.println(frequency);
		
		HashMap<Integer,Integer> freq = new HashMap<>();
		for(int a:arr) {
			freq.put(a, freq.getOrDefault(a, 0)+1);
		}
		System.out.println(freq);
	}
	
	static char firstNonRepeating(String s) {
		Map<Character,Integer> map = new LinkedHashMap<>();
		for(char c:s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		for(char c : s.toCharArray()) {
			if(map.get(c)==1) {
				return c;
			}
		}
		return '\0';
	}
}
