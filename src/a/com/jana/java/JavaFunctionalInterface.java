package a.com.jana.java;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class JavaFunctionalInterface {

	@FunctionalInterface
	public static interface Calculator {
		int add(int a, int b);

		default void show() {
			System.out.println("Default");
			test();
		}

		static void print() {
			System.out.println("Static");
			stest();
		}
		// Java 9+
		private void test() {
			System.out.println("Java 9 Private");
		}
		
		private static void stest() {
			System.out.println("Java 9 Private");
		}
		
	}

	public static class CalculatorClass implements Calculator {

		@Override
		public int add(int a, int b) {
			return a + b;
		}

	}

	public static void main(String[] args) {

		System.out.println("==========Java 8 - Functional Interfaces ==========");
//		A Functional Interface contains exactly one abstract method.
//		It may also have:
//			Default methods
//			Static methods
//			Private methods (Java 9+)
//		@FunctionalInterface Annotation: This annotation is optional but highly recommended. 
//		It forces the compiler to verify that the interface meets the criteria. 
//		If you add a second abstract method, it will trigger a compilation error.

//		To call an interface in the main method, instantiate a concrete class that implements the interface, 
//		or create an anonymous inner class or lambda expression.
		//Concrete Class
		Calculator cal1 = new CalculatorClass();
		System.out.println("Concrete Class: "+ cal1.add(3, 9));
		//Anonymous Inner Class
		Calculator cal2 = new Calculator() {
			@Override
			public int add(int a, int b) {
				return a+b;
			}
		};
		System.out.println("Anonymous Inner Class: "+ cal2.add(4, 9));

		//Lambda Expression
		Calculator cal3 = (a,b)->a+b;
		System.out.println("Lambda Expression: "+ cal3.add(3, 5));

//		Built-in Functional Interfaces
//		Interface			Input		Output		Method
//		Predicate<T>		T			boolean		test()
		Predicate<Integer> even = n -> n % 2 == 0;
		System.out.println("Predicate: " + even.test(10));
//		Function<T,R>		T			R			apply()
		Function<String, Integer> length = text -> text.length();
		System.out.println("Function: " + length.apply("Java"));
//		Consumer<T>			T			void		accept()
		Consumer<String> printer = x -> System.out.println("Consumer: " + x);
		printer.accept("Java");
//		Supplier<T>			None		T			get()
		Supplier<Double> random = Math::random;
		System.out.println("Supplier: " + random.get());
//		UnaryOperator<T>	T			T			apply()
		UnaryOperator<Integer> square = x -> x * x;
		System.out.println("UnaryOperator: " + square.apply(4));
//		BinaryOperator<T>	T,T			T			apply()
		BinaryOperator<Integer> add = (a, b) -> a + b;
		System.out.println("BinaryOperator: " + add.apply(6, 4));

	}

}
