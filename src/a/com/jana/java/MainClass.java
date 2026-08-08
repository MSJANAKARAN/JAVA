package a.com.jana.java;

public class MainClass {

//	public static void main: Entry point of every Java application. When you run a Java program, the JVM looks for this exact method.
//	public: Means accessible from anywhere. JVM is outside your class, so it must be able to access the method.
//	static: A static method belongs to the class, not to any object. JVM starts your program before creating any object.
//		Why static is needed? for static, No object needed. for non-static, need object.
//		Why main() static? JVM must invoke it without creating an object. static method belongs to class and can be called immediately after class is loaded.
//	void:	Returns nothing. When your program ends, there is nothing to return to JVM.
//	main: Just the predefined method name. JVM specifically searches for main
//	String[] args: Stores command-line arguments.

	public static void main(String[] args) {
		System.out.println("Hello World");
	
//		Access Modifier   Inside same      Inside same       Subclasses       Everywhere
//						   class		    package	   (different package)
//		--------------------------------------------------------------------------------
//		private            Yes              No                  No               No     
//		
//		default            Yes              Yes                 No               No      
//		(no keyword)
//		protected          Yes              Yes                 Yes              No      
//		
//		public             Yes              Yes                 Yes              Yes    
		
	}


//	Why one java file splits into multiple classs file?
//	The compiler generates one .class file for each compiled type (class, interface, enum, record) and additional .class files for anonymous/local classes.
//	$ - nested or synthetic classes.
}
