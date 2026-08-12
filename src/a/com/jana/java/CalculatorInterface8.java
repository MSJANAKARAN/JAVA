package a.com.jana.java;

public interface CalculatorInterface8 {

	int add(int a, int b);

//	Can have multiple default, static methods
//	Java 8+ default method
	default void show() {
		System.out.println("Default show");

	}

	default void verify() {
		System.out.println("Default verify");
	}

	default void verify1() {
		System.out.println("Default verify1");
	}
//	Java 8+ static method
	static void print() {
		System.out.println("Static print");
	}

	static void check() {
		System.out.println("Static check");
	}

}
