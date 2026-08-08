package a.com.jana.java;

import java.util.Random;
import java.util.random.RandomGenerator;

public class Java17Features {

	public static void main(String[] args) {

		System.out.println("===Java 17 - Sealed Classes and Interfaces ===");
//		Provides explicit restriction over which sub-classes or sub-interfaces are allowed to extend or implement them.

//		Before Java 17
//		Anyone could extend your class. You cannot control inheritance.
//		
//		class Account {
//
//		}
//
//		class SavingsAccount extends Account {
//
//		}
//
//		class LoanAccount extends Account {
//
//		}
//
//		class HackerAccount extends Account {
//
//		}

//		Java 17
//		final: No one else can extend this subclass.
//		sealed: Only a newly specified list of permitted classes can extend it.
//		non-sealed: Anyone can extend this subclass

//		public sealed class Account permits SavingsAccount, LoanAccount{
//			
//		}
//		Only these classes may extend Account.
//
//		final class SavingsAccount extends Account{
//			
//		}
//		
//		non-sealed class LoanAccount extends Account{
//			
//		}
//		Trying below will throw compile error
//		class CurrentAccount extends Account{
//			
//		}
//		CurrentAccount is not allowed to extend sealed class Account

		System.out.println("===Java 17 - Enhanced Random Number Generator ===");
//		Java 17 introduced a single interface called java.util.random.RandomGenerator
//		Stream Support for Primitives
//		Before Java 17
		Random random= new Random();
		System.out.println("Before Java 17: "+random.nextInt());
		
		//Java 17
//		Supports multiple random algorithms.
		RandomGenerator random1 = RandomGenerator.getDefault();
		System.out.println("Java 17: "+random1.nextInt());

		System.out.println("===Java 17/21 - Pattern Matching for switch ===");

//		Pattern Matching for switch - Preview (Stable in Java 21)
//		you can write and run preview version codes, but they are disabled by default.
//		To use preview features, you must explicitly tell both the Java Compiler (javac) and the Java Runtime (java) 
//		to allow them using a special flag: --enable-preview.
//		run : java --source 17 --enable-preview Java17Features.java
		// Before
		Object obj = 100;
		if (obj instanceof Integer) {
			Integer i = (Integer) obj;
			System.out.println("Before: " + i);

		} else if (obj instanceof String) {
			String s = (String) obj;
			System.out.println("Before: " + s);

		}
		System.out.println();

//		Java 17 Preview
//		switch (obj) {
//		case Integer i -> System.out.println("Java 17 Preview: " + i);
//		case String s -> System.out.println("Java 17 Preview: " + s);
//		default -> System.out.println("Unknown");
//		}
		
//		System.out.println("===Java 17 - Strong Encapsulation ===");
//
//		Java 17 Strong Encapsulation
//		Strong Encapsulation in Java refers to a foundational security and architecture mechanism that permanently 
//		locks down and hides internal Java Development Kit (JDK) APIs from application code
//		Java 17 strongly encapsulates JDK internal APIs.
//		Benefits:
//			Better security
//			Stable APIs
//			Less dependency on internal JDK implementation
		
	}

}
