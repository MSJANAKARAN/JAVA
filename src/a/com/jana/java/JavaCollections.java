package a.com.jana.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaCollections {

	public static void main(String[] args) {

		List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
		list1.set(0, 5);
//		Arrays.asList() return a fixed size list backed by priginal array, cannot do structural modification like add/remove
//		list.add(3); //throw UnsupporttedOperationError
		System.out.println(list1);
		List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

		list2.add(4);
		System.out.println(list2);
		System.out.println("=".repeat(50));

		// Introduced in Java 9, fully immutable list, doesnot support any modifications
		List<Integer> list3 = List.of(1, 2, 3, 4);
//		list3.set(0, 3);//throw UnsupporttedOperationError
		System.out.println(list3);

		List<Integer> list4 = new ArrayList<>(List.of(1, 2, 3, 4));
		list4.set(0, 3);
		System.out.println(list4);
		System.out.println("=".repeat(50));


		
	}

}
