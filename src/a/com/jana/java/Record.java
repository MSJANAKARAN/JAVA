package a.com.jana.java;

//Record
//public record Record(String name, int age) {}
//
//Java automatically generates like 
//
//public final class Record extends java.lang.Record {
//	private final String name;
//	private final int age;
//	
//	//Constructor
//	public Record(String name, int age) {
//		this.name=name;
//		this.age=age;
//	}
//	//Getters, in java class, getName(), in record name()
//	public String name() {
//		return name;
//	}
//	
//	public int age() {
//		return age;
//	}
//	
//	//equals()
//	//hashcode()
//	//toString()
//}

public record Record(int width, int height) {
	public int area() {
		return width*height;
	}
}