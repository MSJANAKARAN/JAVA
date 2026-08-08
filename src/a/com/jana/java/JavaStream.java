package a.com.jana.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStream {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.add(7);
		list.add(3);
		list.add(4);
		list.add(1);
		list.add(8);

		Stream<Integer> s = list.stream();
		s.forEach(System.out::println);
//		s.forEach(System.out::println); // calling again wll throw exception
		System.out.println("=".repeat(50));

		List<Integer> list1 = IntStream.range(1, 100).parallel().boxed().collect(Collectors.toList());

		list1.stream().forEach(System.out::println);
	}

}
