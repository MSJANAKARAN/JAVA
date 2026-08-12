package a.com.jana.java;

public interface CalculatorInterface9 {

	int add(int a, int b);

//		Can have multiple default, static, private methods
//		Java 8+ default method
	default void show() {
		System.out.println("Default show");
		test();
		test1();
	}

	default void verify() {
		System.out.println("Default verify");
		test();
	}

	default void verify1() {
		System.out.println("Default verify1");
		test();
	}
//		Java 8+ static method
	static void print() {
		System.out.println("Static print");
		stest();
	}

	static void check() {
		System.out.println("Static check");
		stest();
	}

	// Java 9+ private method for default
	private void test() {
		System.out.println("Java 9 Private");
	}

	private void test1() {
		System.out.println("Java 9 Private 1");
	}

	// Java 9+ private method for static
	private static void stest() {
		System.out.println("Java 9 Static Private");
	}

}
