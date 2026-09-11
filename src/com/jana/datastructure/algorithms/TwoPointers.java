package com.jana.datastructure.algorithms;

import java.util.HashMap;
import java.util.Map;

public class TwoPointers {

	public static void main(String[] args) {
//		Sorted array + pair / comparison / remove duplicates
		
//		Two Sum in Sorted Array
		int [] arr= {2,4,2,6,7,12};
		twoSum(arr,10);
		
//		Valid Palindrome
		System.out.println("Valid Palindrome: "+isPalindrome("radar"));
		
//		Remove Duplicates from Sorted Array
		int arr1[]= {1,2,4,4,5,7,7};
		System.out.println("Remove Duplicates from Sorted Array: "+removeDuplicates(arr1));
	}

	static void twoSum(int[] arr,int target) {
		int left=0;
		int right=arr.length-1;
		
		while(left<right) {
			if(arr[left]+arr[right]==target) {
				System.out.println("Indices add up to target are "+left+" , "+right);
				return;
			}else if(arr[left]+arr[right]<target) {
				left++;
			}else {
				right--;
			}
		}
	}
	
	static boolean isPalindrome(String s) {
		int left=0;
		int right=s.length()-1;
		while(left<right) {
			if(s.charAt(left) !=s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	
	static int removeDuplicates(int[] arr) {
		int slow=0;
		for(int fast=1;fast<arr.length;fast++) {
			if(arr[fast]!=arr[slow]) {
				slow++;
				arr[slow]=arr[fast];
			}
		}
        // indec represents the count of unique elements
		return slow+1;
	}
}
