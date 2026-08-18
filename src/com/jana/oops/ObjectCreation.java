package com.jana.oops;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ObjectCreation implements Cloneable, Serializable {
//	List of Methods to Create Objects in Java
//	Using new keyword
//	Using clone() method
//	Using Deserialization
//	Using Constructor.newInstance() from Reflection API
//	Using Class.forName().newInstance()

	String name = "Object Creation";

	public ObjectCreation(String string) {
		this.name = name;
	}

	public ObjectCreation() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("------ new Keyword ------");

//		Method 1: Using new Keyword (Most Common)
//		new keyword allows us to call any constructor, whether it's a default or parameterized one.
		ObjectCreation obj1 = new ObjectCreation();
		System.out.println(obj1.name);

		System.out.println("------ clone() Method ------");
//		Method 2: Using clone() Method
//		The clone() method creates a shallow copy of the object. It does not invoke any constructor. 
//		The target class must implement the Cloneable marker interface, or it will throw a CloneNotSupportedException
		ObjectCreation obj2 = null;
		try {
			obj2 = (ObjectCreation) obj1.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(obj2.name);

		System.out.println("------ Deserialization ------");
//		Method 3: Using Deserialization //Extracting an object from byte streams
//		When an object is deserialized, Java creates a new object without calling the constructor. 
//		The class must implement the Serializable interface.
		serialize();
		// Then deserialize it and print the name
		deserialize();
//		When you deserialize an object using ObjectInputStream, 
//		Java reads a binary stream from a file or network and reconstructs the object in memory.
//		Like cloning, this process does not call any constructor.

		System.out.println("------ Constructor.newInstance() from Reflection API ------");
//		Method 4: Using Constructor.newInstance() from Reflection API
//		Constructor.newInstance() method is part of Java's Reflection API and can be used to invoke private constructors, 
//		parameterized constructors, or even bypass normal object instantiation flow.

//		getConstructor(...) targets only public constructors.
		try {
			Constructor<ObjectCreation> cons1 = ObjectCreation.class.getConstructor(String.class);
			ObjectCreation obj3 = cons1.newInstance("Reflect Object Creation");
			System.out.println(obj3.name);
//			getDeclaredConstructor(...) targets any constructor explicitly declared by the class, regardless of visibility (public, protected, package-private, or private).
			Constructor<ObjectCreation> cons2 = ObjectCreation.class.getDeclaredConstructor();
//			Making the constructor accessible (useful if it's private)
			cons2.setAccessible(true);
			ObjectCreation obj4 = cons2.newInstance();
			System.out.println(obj4.name);

		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		new has one massive limitation: it requires you to know the class name and arguments at the exact moment you write the code.
//		Using Reflection: Allows you to load a class by passing its name as a string at runtime.
		System.out.println("------ Class.forName().newInstance() ------");
//		Method 5: Class.forName().newInstance()
//		This method is deprecated in Java 9 because it throws checked exceptions awkwardly and 
//		only works with no-arg public constructors
		try {
//			forName(Fully Qualified Name)
			ObjectCreation obj5 = (ObjectCreation) Class.forName("com.jana.oops.ObjectCreation").newInstance();
			System.out.println(obj5.name);
			ObjectCreation obj6 = ObjectCreation.class.newInstance();
			System.out.println(obj6.name);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Method to serialize the object
	public static void serialize() {
		try {
			ObjectCreation obj = new ObjectCreation("Java Object Creation");
			FileOutputStream fos = new FileOutputStream("com/jana/oops/file.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(obj);
			oos.close();
			fos.close();
			System.out.println("Object has been serialized");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Method to deserialize the object
	public static void deserialize() {
		try {
			FileInputStream fis = new FileInputStream("com/jana/oops/file.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			ObjectCreation obj = (ObjectCreation) ois.readObject();
			ois.close();
			fis.close();
			System.out.println("Deserialized object name: " + obj.name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	new => Knowing the exact class name at compile time.
//	Reflect => Knowing the class name or arguments only as dynamic strings/arrays at runtime.
//	.clone() => An already existing, populated object instance.
}
