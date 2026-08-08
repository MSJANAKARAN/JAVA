package a.com.jana.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Java7features {

	public static void main(String[] args) throws Exception {

		System.out.println("===Java 7 - Try-with-Resources ===");
//		Try-with-resources is a Java 7 feature that automates resource management. 
//		It ensures that files, database connections, or network sockets close automatically when code execution finishes.
//		
//		Before Java 7, you had to manually close resources in a finally block. 
//		This required verbose, nested code and risked leaking resources if an exception occurred during the close operation itself.
//		Before
		String input = "/Users/janakaran/PROJECTS/com.jana.java/src/a/com/jana/java/input.txt";

		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(input));
			System.out.println(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

//		Java 7
//		declare the resource inside the try parentheses. 
//		Java guarantees it will close as soon as the block exits, 
//		whether it completes normally or throws an exception.
		try (BufferedReader br1 = new BufferedReader(new FileReader(input))) {

			System.out.println(br1.readLine());

		} catch (IOException e) {
			e.printStackTrace();
		}
//		AutoCloseable - the compiler generates code that automatically calls the 
//		resource's close() method at the end of the try block.
//		Can declare multiple resources by separating them with a semicolon. They close in the reverse order of their creation.
//			try (FileReader fr = new FileReader("input.txt"); FileWriter fw = new FileWriter("output.txt")) {
//				// Code here
//			} catch(){}// fw closes first, then fr closes

		System.out.println("===Java 7 - Multi-Catch ===");
//		Multi-Catch - Catch multiple exception types in a single catch block.
//		
//		Before Java 7
//		try {
//
//		} catch (IOException e) {
//
//		} catch (SQLException e) {
//
//		}
//		
//		Java 7
//		try {
//
//		} catch (IOException | SQLException e) {
//
//		    System.out.println("Handled");
//
//		}

		System.out.println("===Java 7 - Diamond Operator (<>) ===");

//		Reduces generic type boilerplate.
//
//		Before Java 7
		List<String> list = new ArrayList<String>();
		System.out.println(list);
//		Java 7
		List<String> list1 = new ArrayList<>();
		System.out.println(list1);
//		The compiler infers the generic type.

		System.out.println("===Java 7 - NIO.2 (New File API) ===");
//		NIO.2 (Non-blocking I/O version 2) 
//		is a comprehensive file management and I/O overhaul introduced in Java 7 under the java.nio.file package. 
//		It was designed to replace the old, limited, and inefficient java.io.File class.
//		Before Java 7
		File file = new File(input);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line;
			// Loop until readLine() returns null
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// Nested try-catch was mandatory to prevent resource leaks
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
//		Java 7
		Path path = Paths.get(input);
		if (Files.exists(path)) {
			System.out.println("File Exists");
			byte[] bytes;
			try {
				bytes = Files.readAllBytes(path);
				String content = new String(bytes, StandardCharsets.UTF_8);
				System.out.println(content);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("File not Exist");

		}
//		Read All Lines as List
		try {
			List<String> list2 = Files.readAllLines(path);
			System.out.println(list2);
		} catch (IOException e) {
			e.printStackTrace();
		}
//		Copy File
//			Files.copy(source, destination);
//		Delete File
//			Files.delete(path);
//		Create Directory
//			Files.createDirectory(Paths.get("docs"));

//		Java 11 later added Files.readString() and Files.writeString() for even simpler text file handling.

		System.out.println("===Java 7 - String in Switch ===");
//		Before Java 7, switch worked only with numeric types, enums, and char.
//		Java 7 
		String role = "ADMIN";
		switch (role) {
		case "ADMIN":
			System.out.println("Administrator");
			break;
		case "USER":
			System.out.println("Normal User");
			break;
		default:
			System.out.println("Unknown");
		}

		System.out.println("===Java 7 - Binary Literals ===");
//		Binary Literals - Write numbers in binary form.
		int number = 0b1010;
		System.out.println(number);
//		Unlike binary literals, which were added late in Java 7, 
//		octal and hexadecimal literals have been part of Java since Java 1.0 (1996)
		int simpleHex = 0xF;
		System.out.println(simpleHex);

		// Decimal value: 8 (Not 10!)
		int eight = 010;
		System.out.println(eight);

		// Linux standard read/write/execute permissions (Decimal value: 493)
		int chmodPermissions = 0755;
		System.out.println(chmodPermissions);
//		The Octal Trap: Because a leading zero triggers octal mode, 
//		accidentally putting a 0 in front of a normal number changes its value completely

		System.out.println("===Java 7 - Underscores in Numeric Literals ===");
//		Improves readability.
//		It allows you to place underscores (_) between digits in a numeric literal, 
//		acting exactly like commas or spaces do in written numbers
//		Before
		int amount = 1000000000;

//		Java 7
		int amount1 = 1_000_000_000;
//		The value remains the same.
		System.out.println(amount == amount1);

		System.out.println("===Java 7 - Improved Exception Handling (Precise Rethrow) ===");
//		Improved Exception Handling (Precise Rethrow)
//		The compiler can infer the specific exception type being rethrown.
//		It allows a developer to catch a generic superclass exception (like Exception), do some processing, 
//		and rethrow it without having to declare the generic Exception in the method's throws clause.
//
//		Before: Forces you to broaden your throws clause
//			public void processFile() throws Exception { // Bad API design!
//			    try {
//			        if (checkCondition()) {
//			            throw new SQLException("DB Error");
//			        } else {
//			            throw new IOException("File Error");
//			        }
//			    } catch (Exception e) {
//			        log.error("Error occurred", e);
//			        throw e; // Compiler only sees this as a generic 'Exception'
//			    }
//			}

//		 Java 7 Way: Clean catch, precise throws clause
//			public void processFile() throws SQLException, IOException { // Safe, specific API
//			    try {
//			        if (checkCondition()) {
//			            throw new SQLException("DB Error");
//			        } else {
//			            throw new IOException("File Error");
//			        }
//			    } catch (Exception e) { // Catches both
//			        log.error("Shared logging logic here");
//			        throw e; // Compiler knows 'e' can ONLY be SQLException or IOException!
//			    }
//			}

//		This allows more precise exception analysis during compilation.
	}

}
